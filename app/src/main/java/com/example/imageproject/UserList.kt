package com.example.imageproject

import android.app.Application

public class UserList : Application() {
    companion object {
        private var nameList = mutableListOf<String>()
        private var emailList = mutableListOf<String>()
        private var passwordList = mutableListOf<String>()


        fun getNames() = nameList
        fun getEmails() = emailList
        fun getPasswords() = passwordList
        fun checkUser(inputEmail: String, inputPassword: String): Boolean {
            return inputEmail in this.emailList && inputPassword == this.passwordList[emailList.indexOf(
                inputEmail
            )]

        }

        fun addUser(name: String, email: String, password: String) {
            this.nameList.add(name)
            this.emailList.add(email)
            this.passwordList.add(password)
        }
    }



}
