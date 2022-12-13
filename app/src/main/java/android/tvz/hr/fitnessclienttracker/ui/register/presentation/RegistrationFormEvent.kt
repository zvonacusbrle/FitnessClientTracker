package android.tvz.hr.fitnessclienttracker.ui.register.presentation

sealed class RegistrationFormEvent {
    data class UsernameChanged(val username: String) : RegistrationFormEvent()
    data class PasswordChanged(val password: String) : RegistrationFormEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : RegistrationFormEvent()

    object Submit: RegistrationFormEvent()

}