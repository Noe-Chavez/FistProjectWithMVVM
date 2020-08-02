package com.dissekcorportion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dissekcorportion.R
import com.dissekcorportion.databinding.ActivityDbldBinding
import com.dissekcorportion.utils.User
import com.dissekcorportion.viewmodel.DBLDViewModel

class DBLDActivity : AppCompatActivity() {

    lateinit var viewModel: DBLDViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDbldBinding = DataBindingUtil.setContentView(this@DBLDActivity, R.layout.activity_dbld)

        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(DBLDViewModel::class.java)

        binding.viewModelVariableXml = viewModel

        var user = User("Alberto", "32")
        viewModel.setUser(user)

    }
}