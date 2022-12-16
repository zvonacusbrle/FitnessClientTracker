package android.tvz.hr.fitnessclienttracker.register_feature.use_case

import android.app.Application
import android.tvz.hr.fitnessclienttracker.R

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ValidatePassword @Inject constructor() {

    fun execute(password: String, applicationContext: Application): ValidationResults {
        if (password.isBlank()) {
            return ValidationResults(
                successful = false,
                errorMessage = applicationContext.getString(R.string.register_user_password_lenght)

            )
        }
        if (password.length < 3 || password.length > 8)
            return ValidationResults(
                successful = true,
                errorMessage = applicationContext.getString(R.string.register_user_password_lenght)

            )
        return ValidationResults(
            successful = true
        )
    }
}