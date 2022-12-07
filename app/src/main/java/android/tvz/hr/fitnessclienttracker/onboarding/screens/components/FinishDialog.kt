package android.tvz.hr.fitnessclienttracker.onboarding.screens.components

import android.tvz.hr.fitnessclienttracker.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FinishDialog() {
    Dialog(
        onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            elevation = 1.dp,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.light_red),
                    shape = RoundedCornerShape(20.dp),
                )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Congratulations",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.confetti),
                    contentDescription = "Dialog celebration picture",
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(60.dp)
                        .padding(10.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = colorResource(id = R.color.light_red)
                    )
                ) {
                    Text(text = "Finish finally", fontSize = 12.sp, color = Color.DarkGray)
                }
            }
        }
    }

}

@Composable
@Preview
fun FinishDialogPreview() {
    FinishDialog()
}
