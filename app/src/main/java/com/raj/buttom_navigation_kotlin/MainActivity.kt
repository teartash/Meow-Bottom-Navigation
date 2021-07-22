package com.raj.buttom_navigation_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import kotlinx.android.synthetic.main.activity_main.*


    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         addFragment(homeFragment.newInstance())
         bottomNavigation.show(1)
         bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_info))
         bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
         bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_account))

         bottomNavigation.setOnClickMenuListener {
            when (it.id){
                0->{
                   addFragment(infoFragment.newInstance())
                }
                1->{
                    addFragment(homeFragment.newInstance())
                }
                2->{
                    addFragment(accountFragment.newInstance())
                }
            }
        }
    }
     private fun addFragment(fragment:Fragment){
        val fragmentTransition=supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.frame_Layout,fragment).addToBackStack(Fragment::class.java.simpleName).commit()

    }
   }
