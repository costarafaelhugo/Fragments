package com.hugorafaelcosta.fragments

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var buttonHome: Button
    private lateinit var buttonConsoles: Button
    private lateinit var buttonGames: Button

    private lateinit var homeFragment: HomeFragment
    private lateinit var gamesFragment: GamesFragment
    private lateinit var consoleFragment: ConsoleFragment

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonHome = findViewById(R.id.button_home)
        buttonHome.setOnClickListener(this)

        buttonGames = findViewById(R.id.button_games)
        buttonGames.setOnClickListener(this)

        buttonConsoles = findViewById(R.id.button_consoles)
        buttonConsoles.setOnClickListener(this)

        homeFragment = HomeFragment()
        consoleFragment = ConsoleFragment()
        gamesFragment = GamesFragment()

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(homeFragment)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_fragment, fragment)
        fragmentTransition.commit()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_home -> {
                setFragment(homeFragment)
            }
            R.id.button_games -> {
                setFragment(gamesFragment)
            }
            R.id.button_consoles -> {
                setFragment(consoleFragment)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_games -> {
                setFragment(gamesFragment)
            }
            R.id.consoles -> {
                setFragment(consoleFragment)
            }
        }

        return true
    }
}