package com.dissekcorportion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dissekcorportion.utils.User

class DBLDViewModel : ViewModel() {

    var user: MutableLiveData<User> = MutableLiveData() // Observer
    var visible: MutableLiveData<Boolean> = MutableLiveData(true)// se pasa valor del parametro que puede iniciar.
    var size: MutableLiveData<Float> = MutableLiveData(14f)

    fun setUser(user: User) {
        this.user.value = user
    }

    fun updateUser() {
        val user = User("Laura", "26")
        this.user.value = user
    }

    fun setVisible(visible: Boolean) {
        this.visible.value = visible
    }

    fun changeVisibility() {
        if (visible.value == true) {
            visible.value = false
        } else {
            visible.value = true
        }
        size.value = size.value!!.toFloat() + 5f // convierte en a float.
    }

}