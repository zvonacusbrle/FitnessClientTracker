package android.tvz.hr.fitnessclienttracker.ui.register.use_case

import android.tvz.hr.fitnessclienttracker.R
import androidx.compose.ui.res.stringResource

class ValidatePassword {

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