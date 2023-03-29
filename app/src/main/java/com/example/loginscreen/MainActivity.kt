package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userWritten: EditText = findViewById(R.id.editUser)
        val passWritten: EditText = findViewById(R.id.editPass)
        val confirmButton: Button = findViewById(R.id.loginButton)

        var userList : MutableList<String> = mutableListOf()
        var passList : MutableList<String> = mutableListOf()
        lateinit var userValue : String
        lateinit var passValue : String

        confirmButton.setOnClickListener {
            val username: String = userWritten.text.toString()
            val password: String = passWritten.text.toString()

            userList.add("admin")
            userList.add("isabella")
            userList.add("sol")

            passList.add("admin")
            passList.add("isalol")
            passList.add("sollol")


            userValue = userList.indexOf(username).toString()
            passValue = passList.indexOf(password).toString()


            if (userList.contains(username)) {

                if(userValue == passValue) {

                    showSnackbar("Login successful")
                }
                else{
                    showSnackbar("Username or password incorrect")
                }

            } else {
                showSnackbar("Username and password does not exist")
            }

            if (username.isEmpty() && password.isEmpty()) {
                showSnackbar("Please insert your Username and Password")
            }
        }
    }

    fun showSnackbar(message: String) {
        val snackbar = Snackbar.make(
            findViewById<View>(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        )
        snackbar.show()
    }
}