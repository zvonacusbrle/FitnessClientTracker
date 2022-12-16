package android.tvz.hr.fitnessclienttracker.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.tvz.hr.fitnessclienttracker.R
import android.tvz.hr.fitnessclienttracker.onboarding.screens.components.FINISHED
import android.tvz.hr.fitnessclienttracker.onboarding.screens.components.ONBOARDING
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    SplashScreenAnimation()
                }
            }
        }
    }

    @Composable
    fun SplashScreenAnimation() {
        val scale = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(
                    durationMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    }
                )
            )
            if(checkOnBoardingFinished()){
                Handler(Looper.getMainLooper()).postDelayed({
                    findNavController().navigate(R.id.action_splashFragment_to_logIn)
                }, 800)
            } else {
                Handler(Looper.getMainLooper()).postDelayed({
                    findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
                }, 800)
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.fitness_client_tracker),
                contentDescription = "Logo",
                modifier = Modifier.scale(scale.value)
            )
        }
    }

    private fun checkOnBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences(ONBOARDING, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(FINISHED, false)
    }


}