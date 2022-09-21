package com.aorhan.gezirehberi_aorhan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gezilecekler = Gezilecekler()
        val gezdiklerim = Gezdiklerim()
        val yerBilgisi = YerBilgisi()

        makeCurrentFragment(gezilecekler)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.gezilecekler -> makeCurrentFragment(gezilecekler)
                R.id.gezdiklerim -> makeCurrentFragment(gezdiklerim)
                R.id.btnEkle -> makeCurrentFragment(yerBilgisi)
            }

            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }
}