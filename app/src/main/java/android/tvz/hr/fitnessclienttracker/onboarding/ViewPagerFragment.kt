package android.tvz.hr.fitnessclienttracker.onboarding

import android.annotation.SuppressLint
import android.os.Bundle
import android.tvz.hr.fitnessclienttracker.R
import android.tvz.hr.fitnessclienttracker.onboarding.screens.FirstScreenFragment
import android.tvz.hr.fitnessclienttracker.onboarding.screens.SecondScreenFragment
import android.tvz.hr.fitnessclienttracker.onboarding.screens.ThirdScreenFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


class ViewPagerFragment : Fragment() {
    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )
        return ComposeView(requireContext()).apply {
            setContent {
                val adapter = ViewPagerAdapter(
                    fragmentList,
                    childFragmentManager,
                    lifecycle
                )
                AndroidView(factory = { context ->
                    val view = LayoutInflater.from(context)
                        .inflate(R.layout.fragment_view_pager, null, false)
                    val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
                    viewPager.adapter = adapter
                    view
                })
            }
        }
    }
}