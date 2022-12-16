package android.tvz.hr.fitnessclienttracker.ui.register

import android.tvz.hr.fitnessclienttracker.ui.register.presentation.RegistrationFormEvent
import android.tvz.hr.fitnessclienttracker.ui.register.presentation.RegistrationFormState
import android.tvz.hr.fitnessclienttracker.ui.register.use_case.ValidatePassword
import android.tvz.hr.fitnessclienttracker.ui.register.use_case.ValidateRepeatedPassword
import android.tvz.hr.fitnessclienttracker.ui.register.use_case.ValidateUsername
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val validateUsername: ValidateUsername,
    private val validatePassword: ValidatePassword,
    private val validateRepeatedPassword: ValidateRepeatedPassword,

): ViewModel() {

    var state by mutableStateOf(RegistrationFormState())
    private val validationEventChannel = Channel<ValidateEvent> { }
    val validationEvent = validationEventChannel.receiveAsFlow()

    fun onEvent(event: RegistrationFormEvent){
        when(event){
            is RegistrationFormEvent.UsernameChanged -> {
                state = state.copy(username = event.username)
            }
            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is RegistrationFormEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            RegistrationFormEvent.Submit -> {
                submitData()

            }
        }
    }

    private fun submitData() {
        val usernameResult = validateUsername.execute(state.username)
        val passwordResult = validatePassword.execute(state.password)
        val repeatedPasswordResult = validateRepeatedPassword
            .execute(state.password,state.repeatedPassword)

        val hasErrors = listOf(
            usernameResult,
            passwordResult,
            repeatedPasswordResult
        ).any{ !it.successful }

        if(hasErrors){
            state = state.copy(
                usernameError = usernameResult.errorMessage,
                passwordError = passwordResult.errorMessage,
                repeatedPasswordError = repeatedPasswordResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            validationEventChannel.send(ValidateEvent.Success)
        }


    }
}

sealed class ValidateEvent(){
    object Success : ValidateEvent()
}