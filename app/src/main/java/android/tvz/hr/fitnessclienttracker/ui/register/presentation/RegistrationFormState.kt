package android.tvz.hr.fitnessclienttracker.ui.register.presentation

class RegistrationFormState(
    val username: String = "",
    val usernameError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: String? = null
) {
}