package com.albert.esoftwarica

import com.albert.esoftwarica.models.User
var users = mutableMapOf<Int, User>()
var loaded = false
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

    public fun loadDefault(){
        if(!loaded){
            this.appendUsers(User(null, "John Doe", 30, 'O', "Sundhara"))
            this.appendUsers(User(null, "Foo Bar", 20, 'F', "BAZ"))
            this.appendUsers(User(null, "Albert Maharjan", 27, 'M', "Bhotebahal", "https://i1.sndcdn.com/avatars-000282623297-brs4gs-t500x500.jpg"))
        }
        loaded = true
    }
}