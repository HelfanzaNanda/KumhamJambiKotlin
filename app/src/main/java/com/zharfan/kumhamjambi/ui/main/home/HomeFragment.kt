package com.zharfan.kumhamjambi.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.zharfan.kumhamjambi.R
import com.zharfan.kumhamjambi.ui.main.home.tab1.Tab1Fragment
import com.zharfan.kumhamjambi.ui.main.home.tab2.Tab2Fragment
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(Tab1Fragment(), "Tab 1")
        adapter.addFragment(Tab2Fragment(), "Tab 2")
        requireView().view_pager.adapter = adapter
        requireView().tab_layout.setupWithViewPager(requireView().view_pager)
    }

    class ViewPagerAdapter(manager: FragmentManager) :
        FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragments: MutableList<Fragment> = ArrayList()
        private val titles: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment = fragments[position]
        override fun getCount(): Int = fragments.size
        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]
    }

}