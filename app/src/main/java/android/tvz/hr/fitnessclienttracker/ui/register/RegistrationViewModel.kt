package android.tvz.hr.fitnessclienttracker.ui.register

import android.tvz.hr.fitnessclienttracker.ui.register.presentation.RegistrationFormState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {

    var state by mutableStateOf(RegistrationFormState())



}