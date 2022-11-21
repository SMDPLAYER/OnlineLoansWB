package com.zavedapok.ysedo.loanseu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zavedapok.ysedo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_start)
        supportFragmentManager.beginTransaction().replace(
            R.id.mainHolder,
            MainFragment()
        ).commit()
    }
}
