package com.andraganoid.myweather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myweather.R
import com.andraganoid.myweather.databinding.WeatherFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    // @Inject
    // lateinit var viewModel: WeatherViewModel
    //  private val viewModel: WeatherViewModel by  viewModels()
    private val viewModel: WeatherViewModel by activityViewModels<WeatherViewModel>()


    private lateinit var binding: WeatherFragmentBinding

    private lateinit var tabTitle: List<String>
    //   private lateinit var tabsLay: ViewGroup


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        setup()
        return binding.root
    }

    private fun setup() {
        tabTitle = arrayListOf(
            getString(R.string.now).toUpperCase(Locale.getDefault()),
            getString(R.string.forecast).toUpperCase(Locale.getDefault()),
            getString(R.string.search).toUpperCase(Locale.getDefault())
        )
        binding.viewPager.apply {
            adapter = WeatherAdapter(this@WeatherFragment)
            offscreenPageLimit = tabTitle.size
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    super.onPageSelected(position)
//                  //  tabsLay.getChildAt(position).setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.orange_dark))
//                }
//            })
        }

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
        //   tabsLay = binding.tabs.getChildAt(0) as ViewGroup
    }

}