package com.albert.esoftwarica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.albert.esoftwarica.fragments.AboutUsFragment
import com.albert.esoftwarica.fragments.AddStudentFragment
import com.albert.esoftwarica.fragments.HomeFragment
import com.albert.esoftwarica.models.User
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bnvNavigation: BottomNavigationView
    private lateinit var llFragment : LinearLayout
    private var storage = Storage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llFragment = findViewById(R.id.llFragment)
        bnvNavigation = findViewById(R.id.bnvNavigation)

        val aboutUsFragment = AboutUsFragment()
        val homeFragment = HomeFragment()
        val addStudentFragment = AddStudentFragment()

        loadDefaultUsers()

        makeFragment(homeFragment)
        bnvNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.iAboutUs -> makeFragment(aboutUsFragment)
                R.id.iHome -> makeFragment(homeFragment)
                R.id.iAddStudent ->makeFragment(addStudentFragment)
            }
            true
        }

    }

    private fun loadDefaultUsers() {
        storage.appendUsers(User(null, "Kiran Rana", 30, 'M', "Lalitpur"))
        storage.appendUsers(User(null, "Katrina Kaif", 35, 'F', "Mumbai"))
        storage.appendUsers(User(null, "Salman Khan", 55, 'M', "Mumbai"))
    }

    private fun makeFragment(f: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.llFragment, f)
            commit()
        }
        return true
    }
}