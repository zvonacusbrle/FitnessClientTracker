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
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val validateUsername: ValidateUsername,
    private val validatePassword: ValidatePassword,
    private val validateRepeatedPassword: ValidateRepeatedPassword,

): ViewModel() {

    var state by mutableStateOf(RegistrationFormState())

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

            }
        }
    }




}