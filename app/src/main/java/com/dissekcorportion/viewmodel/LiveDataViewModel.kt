package com.dissekcorportion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dissekcorportion.utils.User

class LiveDataViewModel : ViewModel() {

    // Mutable indica que puede cambiar cambainte (agregar o eliminar elementos)
    var userListLiveData: MutableLiveData<List<User>> = MutableLiveData() // observable
    var userList: MutableList<User> = ArrayList()

    // Una laveData asecas no se puede agregar elementos.
    fun getUserList(): LiveData<List<User>> {
        return userListLiveData
    }

    fun addUser(user: User) {
        userList.add(user)
        // value se utiliza cuando el observable está en el hilo principal
        // postValue se utiliza cuando el observable se encuentra un hilo de backgraund
        userListLiveData.value = userList
    }

}