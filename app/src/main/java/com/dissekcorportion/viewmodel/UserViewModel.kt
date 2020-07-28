package com.dissekcorportion.viewmodel

import androidx.lifecycle.ViewModel
import com.dissekcorportion.utils.User

class UserViewModel : ViewModel {

    var userList: MutableList<User>
    constructor() {
        userList = ArrayList()
    }

    fun addUser(u: User) {
        userList.add(u)
    }

}