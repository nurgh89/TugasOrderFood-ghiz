//package com.android.tugasbesarkotlin_orderfoodapp
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentStatePagerAdapter
//import androidx.viewpager.widget.ViewPager
//import com.android.tugasbesarkotlin_orderfoodapp.Fragment.RootTab1Fragment
//import com.android.tugasbesarkotlin_orderfoodapp.Fragment.RootTab2Fragment
//import com.android.tugasbesarkotlin_orderfoodapp.Fragment.RootTab3Fragment
//import com.google.android.material.tabs.TabLayout
//
//class Bar_Menu : AppCompatActivity() {
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bar__menu)
//
//        lateinit var viewPager: ViewPager
//        lateinit var tabLayout: TabLayout
//
//            initView()
//            setStatePageAdapter()
//
//            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//
//                override fun onTabSelected(tab: TabLayout.Tab) {
//                    viewPager.currentItem = tab.position
//                    val fm = supportFragmentManager
//                    val ft = fm.beginTransaction()
//                    val count = fm.backStackEntryCount
//                    if (count >= 1) {
//                        supportFragmentManager.popBackStack()
//                    }
//                    ft.commit()
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab) {
//                    // setAdapter();
//
//
//                }
//
//                override fun OnTabReselected(tab: TabLayout.Tab){
//
//                    //viewPager.notifAll();
//                }
//            })
//
//
//        }
//
//    private fun setStatePageAdapter() {
//
//        val myViewPageStateAdapter:MyViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
//        myViewPageStateAdapter.addFragment(RootTab1Fragment(),"Registration")
//        myViewPageStateAdapter.addFragment(RootTab2Fragment(),"MVVMRetroList")
//
//        myViewPageStateAdapter.addFragment(RootTab3Fragment(),"MVVMList")
//        viewPager.adapter = myViewPageStateAdapter
//        tabLayout.setupWithViewPager(viewPager,true)
//    }
//
//    private fun initView() {
//        viewPager = findViewById(R.id.pager)
//        tabLayout = findViewById(R.id.tabs)
//    }
//    class MyViewPageStateAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){
//        val fragmentList:MutableList<Fragment> = ArrayList<Fragment>()
//        val fragmentTitleList:MutableList<String> = ArrayList<String>()
//
//        override fun getItem(position: Int): Fragment {
//            return fragmentList.get(position)
//        }
//
//        override fun getCount(): Int {
//            return fragmentList.size
//        }
//
//        override fun getPageTitle(position: Int): CharSequence? {
//            return fragmentTitleList.get(position)
//        }
//
//        fun addFragment(fragment: Fragment, title:String){
//            fragmentList.add(fragment)
//            fragmentTitleList.add(title)
//
//        }
//    }
//
//}
//
