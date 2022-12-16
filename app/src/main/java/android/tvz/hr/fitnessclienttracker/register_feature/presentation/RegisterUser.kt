package android.tvz.hr.fitnessclienttracker.register_feature.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.tvz.hr.fitnessclienttracker.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterUser : Fragment() {
    private val viewModel: RegistrationViewModel by viewModels()


    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                RegisterScreen(viewModel)
                RegisterScreenPreview()
            }
        }
    }
}

@Composable
fun RegisterScreen(viewModel: RegistrationViewModel) {
    val state = viewModel.state
    val myContext = LocalContext.current
    LaunchedEffect(key1 = myContext) {
        viewModel.validationEvent.collect { event ->
            when (event) {
                is ValidateEvent.Success -> {
                    Toast.makeText(
                        myContext,
                        myContext.getText(R.string.registration_user_success),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
    }
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

        OutlinedTextField(
            value = state.username,
            onValueChange =
            {
                viewModel.onEvent(RegistrationFormEvent.UsernameChanged(it))
            },
            label = { Text(text = stringResource(id = R.string.register_user_username), color = Color.Black) },
            visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                errorCursorColor = Color.Red,
                focusedBorderColor = colorResource(id = R.color.light_green),
                unfocusedBorderColor = colorResource(id = R.color.light_blue)
            ),
            isError = state.usernameError != null
        )
        if(state.usernameError != null){
            Text(
                text = state.usernameError,
                color = Color.Red
            )
        }



        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = state.password,
            onValueChange =
            {
                viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
            },
            label = { Text(text = stringResource(id = R.string.register_user_password), color = Color.Black) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                errorCursorColor = Color.Red,
                focusedBorderColor = colorResource(id = R.color.light_green),
                unfocusedBorderColor = colorResource(id = R.color.light_blue)
            ),
            isError = state.passwordError != null
        )

        if(state.passwordError != null){
            Text(
                text = state.passwordError,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = state.repeatedPassword,
            onValueChange =
            {
                viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(it))
            },
            label = { Text(text = stringResource(id = R.string.register_user_password_again), color = Color.Black) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                errorCursorColor = Color.Red,
                focusedBorderColor = colorResource(id = R.color.light_green),
                unfocusedBorderColor = colorResource(id = R.color.light_blue)
            ),
            isError = state.repeatedPasswordError != null
        )

        if(state.repeatedPasswordError != null){
            Text(
                text = state.repeatedPasswordError,
                color = Color.Red
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = {
                      viewModel.onEvent(RegistrationFormEvent.Submit)
            },
            border = BorderStroke(1.dp, color = colorResource(id = R.color.orange)),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colorResource(id = R.color.orange)
            )
        ) {
            Text(text = stringResource(id = R.string.register_user_register_button))
        }
    }
}


@Composable
@Preview
fun RegisterScreenPreview() {
    //
}