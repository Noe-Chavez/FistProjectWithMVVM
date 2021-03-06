package com.dissekcorportion.bindingAdapter

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic // para especificar que será estático
    @BindingAdapter("visible")  // especificar el nombre
     /**
     *  @param View: tipo de vista a afetar, se utiliza una generica en este caso, pero se puede
      *  especificar en el caso que sepamos exactamente de que se trata, un botón, imageview, textview, etc.
      * @param visibility: valor de la propiedad que queremos modificar en la vista.
     */
    fun setVisibility(view: View, visibility: Boolean) {
        if (visibility) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic // para especificar que será estático
    @BindingAdapter("visibility", "size")  // variables
    fun setSizeAndVisibility(view: TextView, visibility: Boolean, size: Float) {
        if (visibility) {
            view.visibility = android.view.View.VISIBLE
        } else {
            view.visibility = android.view.View.GONE
        }
        view.textSize = size
    }
}