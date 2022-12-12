package android.tvz.hr.fitnessclienttracker.ui.register.use_case

import android.tvz.hr.fitnessclienttracker.R

class ValidateRepeatedPassword {

    fun execute(password: String, repeatedPassword: String) : ValidationResults{
        if(repeatedPassword.isBlank()){
            return ValidationResults(
                successful = false,
                errorMessage = R.string.register_user_blank_password.toString()
            )
        }
        if (password != repeatedPassword){
            return ValidationResults(
                successful = false,
                errorMessage = R.string.register_user_different_passwords.toString()
            )
        }
        return ValidationResults(
            successful = true
        )
    }
}