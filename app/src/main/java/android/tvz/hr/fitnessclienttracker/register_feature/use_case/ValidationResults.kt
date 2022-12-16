package android.tvz.hr.fitnessclienttracker.register_feature.use_case

data class ValidationResults(
    val successful: Boolean,
    val errorMessage: String? = null
)
