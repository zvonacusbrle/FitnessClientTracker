package android.tvz.hr.fitnessclienttracker.onboarding.screens

import android.content.Context
import android.os.Bundle
import android.tvz.hr.fitnessclienttracker.R
import android.tvz.hr.fitnessclienttracker.onboarding.ViewPagerFragment
import android.tvz.hr.fitnessclienttracker.onboarding.screens.components.FINISHED
import android.tvz.hr.fitnessclienttracker.onboarding.screens.components.FinishDialog
import android.tvz.hr.fitnessclienttracker.onboarding.screens.components.ONBOARDING
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class ThirdScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        return ComposeView(requireContext()).apply {
            setContent {
                val isDialogOpen = remember {
                    mutableStateOf(false)
                }
                OnBoardingPage(
                    viewPager = viewPager,
                    backgroundColor = R.color.light_purple,
                    fragmentPicture = R.drawable.third__fragment_onboarding_picture,
                    title = "",
                    textContent = getString(R.string.third_fragment_content),
                    currentPage = 3,
                    isDialogOpen = isDialogOpen
                )
                if (isDialogOpen.value) {
                    FinishDialog(this@ThirdScreenFragment)
                }
            }
        }
    }

    fun boardingFinished() {
        val sharedPref = requireActivity()
            .getSharedPreferences(ONBOARDING, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(FINISHED, true)
        editor.apply()
    }

}