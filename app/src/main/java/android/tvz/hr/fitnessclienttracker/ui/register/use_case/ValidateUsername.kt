package android.tvz.hr.fitnessclienttracker.ui.register.use_case

import android.tvz.hr.fitnessclienttracker.R
import androidx.compose.ui.res.stringResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ValidateUsername @Inject constructor() {

    fun execute (username: String) : ValidationResults{
        if(username.isBlank()){
            return ValidationResults(
                successful = false,
                errorMessage = R.string.register_user_empty_user_field.toString()
            )
        }
        if(username.length < 3){
            return ValidationResults(
                successful = false,
                errorMessage = R.string.register_user_username_field_to_short.toString()
            )
        }
        return ValidationResults(
            successful = true,
        )
    }
}