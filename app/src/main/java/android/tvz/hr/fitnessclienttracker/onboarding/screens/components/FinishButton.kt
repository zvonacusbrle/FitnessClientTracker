package android.tvz.hr.fitnessclienttracker.onboarding.screens.components

import android.tvz.hr.fitnessclienttracker.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun FinishButton(isDialogOpen: MutableState<Boolean>?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Button(
            onClick = { isDialogOpen?.value = true },
            modifier = Modifier
                .height(48.dp)
                .width(100.dp)
                .align(Alignment.Center),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = R.color.light_purple)
            )
        ) {
            Text(text = "Finish", color = Color.Black)
        }
    }
}