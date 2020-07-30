package com.dissekcorportion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dissekcorportion.R
import com.dissekcorportion.databinding.ActivityDataBindingBinding
import com.dissekcorportion.utils.User

class DataBindingActivity : AppCompatActivity() {

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_data_binding) // se sustituye (lineas 25 a 28).
        /**
         * cuando se usa DataBinding, android nos provee de una nueva lcase para asociar nuestro
         * xml (vista) a nuestra lógica.
         * ActivityDataBindingBinding la crea Android de manera dinamíca y se compone de la palabra
         * Activity seguido del nombre de la clase (ésta calse, sin el Activity) es decir, coloca
         * DataBinding seguido de la palabra Binding, es por eso que se forma
         * Activity(siempre lo pone Andorid por default)-DataBinding(Nombre de esta clase sin el Activity)-Binding(siempre lo pone Andorid por default)
         */
        val binding: ActivityDataBindingBinding = DataBindingUtil.setContentView(
            this@DataBindingActivity,
            R.layout.activity_data_binding
        )

        user = User("Noe Chavez", "27")

        // Vincular variable user (línea 12), con variable User del XML.
        binding.user = user
    }
}