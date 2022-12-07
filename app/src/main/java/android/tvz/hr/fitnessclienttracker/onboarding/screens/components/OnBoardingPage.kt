package android.tvz.hr.fitnessclienttracker.onboarding.screens

import android.annotation.SuppressLint
import android.tvz.hr.fitnessclienttracker.R
import android.tvz.hr.fitnessclienttracker.onboarding.screens.components.FinishButton
import android.view.LayoutInflater
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.viewpager2.widget.ViewPager2

@SuppressLint("InflateParams")
@Composable
fun OnBoardingPage(
    viewPager: ViewPager2?,
    backgroundColor: Int,
    fragmentPicture: Int,
    title: String?,
    textContent: String,
    currentPage: Int,
    isDialogOpen: MutableState<Boolean>? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .padding(60.dp)
                .fillMaxSize()
                .aspectRatio(1f)
                .background(
                    colorResource(id = backgroundColor), shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = fragmentPicture),
                contentDescription = "fragment picture",
                modifier = Modifier
                    .height(225.dp)
                    .width(225.dp)
            )
        }
        if (title != null) {
            Text(text = title, fontSize = 28.sp)
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = textContent)
        Spacer(modifier = Modifier.height(60.dp))
        AndroidView(factory = { context ->
            val view = LayoutInflater.from(context)
                .inflate(R.layout.fragment_view_pager, null, false)
            view
        })
        if (currentPage == 3) {
            FinishButton(isDialogOpen)
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                IconButton(
                    onClick = { viewPager?.currentItem = currentPage },
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp)
                        .align(Alignment.TopEnd)
                        .background(
                            colorResource(id = backgroundColor), shape = CircleShape
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                        contentDescription = "icon_arrow_right",
                    )
                }
            }
        }

    }
}




