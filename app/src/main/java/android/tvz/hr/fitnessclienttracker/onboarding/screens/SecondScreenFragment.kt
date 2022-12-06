package android.tvz.hr.fitnessclienttracker.onboarding.screens

import android.os.Bundle
import android.tvz.hr.fitnessclienttracker.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class SecondScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        return ComposeView(requireContext()).apply {
            setContent {
                OnBoardingPage(
                    viewPager = viewPager,
                    backgroundColor = R.color.light_blue,
                    fragmentPicture = R.drawable.second_fragment_picture,
                    title = "",
                    textContent = "Check your users quickly",
                    currentPage = 2
                )
            }
        }
    }
}