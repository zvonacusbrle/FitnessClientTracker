package android.tvz.hr.fitnessclienttracker.onboarding.screens

import android.os.Bundle
import android.tvz.hr.fitnessclienttracker.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class FirstScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .background(color = Color.White)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(50.dp)
                            .fillMaxSize()
                            .aspectRatio(1f)
                            .background(
                                colorResource(id = R.color.bg_color), shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.first_fragment_picture),
                            contentDescription = "",
                            modifier = Modifier
                                .height(225.dp)
                                .width(225.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = " Fitness Client Tracker", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Welcome")
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .height(90.dp)
                                .width(90.dp)
                                .align(Alignment.TopEnd)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                                contentDescription = "",
                            )
                        }
                    }
                }

            }

        }
    }
}