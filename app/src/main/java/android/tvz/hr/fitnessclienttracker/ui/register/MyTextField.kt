package android.tvz.hr.fitnessclienttracker.ui.register

import android.tvz.hr.fitnessclienttracker.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyTextField(
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val (text, setText) = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = setText,
        label = { Text(text = label, color = Color.Black) },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            errorCursorColor = Red,
            focusedBorderColor = colorResource(id = R.color.light_green),
            unfocusedBorderColor = colorResource(id = R.color.light_blue)
        )
    )
}

@Composable
@Preview
fun TextField(){
    MyTextField(label = "Username")
}