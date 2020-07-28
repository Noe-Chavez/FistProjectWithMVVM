package com.dissekcorportion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dissekcorportion.R
import com.dissekcorportion.utils.User
import com.dissekcorportion.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_user_view_model.*

class UserViewModelActivity : AppCompatActivity() {

    var userList: ArrayList<User> = ArrayList()
    // Vincular con el UserViewModel
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_view_model)
        setUpView()
    }

    // Cada vez que de click en el botón salvar, agregamos un usuario nuevo a la lista.
    fun setUpView() {
        // Intancia del objeto userViewModel
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        btSalvar.setOnClickListener {
            var user = User()
            user.edad = etEdad.text.toString()
            user.nombre = etNombre.text.toString()
            userList.add(user)
            userViewModel.addUser(user)
        }

        btVer.setOnClickListener {
            var texto = ""
            for (user in userList) {
                texto += user.nombre + " " + user.edad + " " + "\n"
            }
            tvUser.text = texto

            texto = ""
            for (user in userViewModel.userList) {
                texto += user.nombre + " " + user.edad + " " + "\n"
            }
            tvUserViewModel.text = texto
        }
    }
}