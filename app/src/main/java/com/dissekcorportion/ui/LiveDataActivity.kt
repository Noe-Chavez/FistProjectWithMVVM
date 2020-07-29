package com.dissekcorportion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dissekcorportion.R
import com.dissekcorportion.utils.User
import com.dissekcorportion.viewmodel.LiveDataViewModel
import kotlinx.android.synthetic.main.activity_lave_data.*

class LiveDataActivity : AppCompatActivity() {

    var numero: Int = 0
    lateinit var viewModel: LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lave_data)
        setUpView()
    }

    fun setUpView() {
        // instancia de objeto ViewModel
        viewModel = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)

        btSave.setOnClickListener {
            if (numero == 0) {
                var user = User()
                user.nombre =  "Alberto"
                user.edad = "23"
                viewModel.addUser(user)
            }

            if (numero == 1) {
                var user = User()
                user.nombre =  "Alberta"
                user.edad = "33"
                viewModel.addUser(user)
            }

            if (numero == 2) {
                var user = User()
                user.nombre =  "Olmos"
                user.edad = "35"
                viewModel.addUser(user)
            }
            numero++
        }

        // Crear observable
        val listObserver = Observer<List<User>> {
            userList ->
            var texto = ""
            for (user in userList) {
                texto += user.nombre + " " + user.edad + "\n"
                tvLiveData.text = texto
            }
        }

        // Subscribir el observer (listObserver) al observable (el que tiene el MutableLiveData[userListLiveData], clase LivedataViewModel)
        // y que cada vez que el observable cambia de valor de manera reactiva se ejecuta el codigo btSave.setOnClickListener y por último
        // Nos actualice el tvLiveData (textview de nuestro activity)
        viewModel.getUserList().observe(this@LiveDataActivity, listObserver)
    }
}