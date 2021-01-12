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

        storage.appendUsers(User(null, "John Doe", 30, 'O', "Sundhara"))
        storage.appendUsers(User(null, "Foo Bar", 20, 'F', "BAZ"))
        storage.appendUsers(User(null, "Albert Maharjan", 27, 'M', "Bhotebahal"))
    }

    private fun makeFragment(f: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply{
            this.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
            replace(R.id.llFragment, f)
            commit()
        }
        return true
    }
}