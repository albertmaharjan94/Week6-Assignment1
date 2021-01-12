package com.albert.esoftwarica

import com.albert.esoftwarica.models.User
var users = mutableMapOf<Int, User>( 0 to User(0, "Kiran Rana", 30, 'M', "Lalitpur"))
class Storage {
    public fun appendUsers(user: User){
        val id = users.size + 1
        user.id = id.toInt()
        user.id?.let { users.put(it, user) }
    }
    public fun getUsers(): MutableMap<Int, User> {
        return users
    }

    public fun deleteUser(user: User){
        users.remove(user.id)
    }
}