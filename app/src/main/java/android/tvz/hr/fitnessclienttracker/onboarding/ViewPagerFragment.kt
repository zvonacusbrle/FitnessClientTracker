package android.tvz.hr.fitnessclienttracker.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.tvz.hr.fitnessclienttracker.R
import android.tvz.hr.fitnessclienttracker.onboarding.screens.FirstScreenFragment
import android.tvz.hr.fitnessclienttracker.onboarding.screens.SecondScreenFragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.viewpager2.widget.ViewPager2


class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val fragmentList = arrayListOf(
                    FirstScreenFragment(),
                    SecondScreenFragment()
                )
                val adapter = ViewPagerAdapter(
                    fragmentList,
                    requireActivity().supportFragmentManager,
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