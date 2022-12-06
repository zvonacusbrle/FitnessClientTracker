package android.tvz.hr.fitnessclienttracker.onboarding.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FinishButton() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Button(
            onClick = {  },
            modifier = Modifier
                .height(48.dp)
                .width(100.dp)
                .align(Alignment.Center),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color(0xFFdfe3f6)
            )
        ){
            Text(text = "Finish", color = Color.Black)
        }
    }
}