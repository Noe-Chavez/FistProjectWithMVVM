package com.dissekcorportion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dissekcorportion.ui.UserViewModelActivity
import com.dissekcorportion.ui.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
    }

    fun setUpView() {
        btViewModel.setOnClickListener({
            startActivity(Intent(applicationContext, ViewModelActivity::class.java))
        })

        btUserViewModel.setOnClickListener {
            startActivity(Intent(this, UserViewModelActivity::class.java))
        }
    }
}