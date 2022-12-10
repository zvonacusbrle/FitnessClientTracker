package android.tvz.hr.fitnessclienttracker.ui.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.tvz.hr.fitnessclienttracker.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class RegisterUser : Fragment() {
    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen() {


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()



    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            modifier = Modifier
                .align(Alignment.Start)
                .width(40.dp)
                .height(30.dp),
            contentDescription = stringResource(id = R.string.register_user_button_back)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.register_user_create_account),
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(id = R.string.register_user_input_fields_bellow),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        MyTextField(label = stringResource(id = R.string.register_user_username))
        Spacer(modifier = Modifier.height(5.dp))
        MyTextField(
            label = stringResource(id = R.string.register_user_password),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(5.dp))
        MyTextField(
            label = stringResource(id = R.string.register_user_password_again),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, color = colorResource(id = R.color.orange)),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colorResource(id = R.color.orange)
            )
        ){
            Text( text = stringResource(id = R.string.register_user_register_button) )
        }



    }
}


@Composable
@Preview
fun RegisterScreenPreview() {
    RegisterScreen()
}