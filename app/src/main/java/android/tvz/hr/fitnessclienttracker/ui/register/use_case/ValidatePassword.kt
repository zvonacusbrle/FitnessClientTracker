package android.tvz.hr.fitnessclienttracker.ui.register.use_case

import android.tvz.hr.fitnessclienttracker.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ValidatePassword @Inject constructor() {

    fun execute(password: String) : ValidationResults{
        if(password.isBlank()){
            return ValidationResults(
                successful = false,
                errorMessage = R.string.register_user_blank_password.toString()
            )
        }
        if(password.length < 3  || password.length > 8 )
        return ValidationResults(
            successful = true,
            errorMessage = R.string.register_user_password_lenght.toString()
        )
        return ValidationResults(
            successful = true
        )
    }
}