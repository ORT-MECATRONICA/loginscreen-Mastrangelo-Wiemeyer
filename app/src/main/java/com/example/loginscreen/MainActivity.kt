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

        var usersList : MutableList<User> = mutableListOf()

        lateinit var userValue : String
        lateinit var passValue : String

        usersList.add(User("admin","admin"))
        usersList.add(User("isabella","isalol"))
        usersList.add(User("sol","sollol"))

        confirmButton.setOnClickListener {
            val myUser: String = userWritten.text.toString()
            val myPassword: String = passWritten.text.toString()

            var userEncontrado : User? = usersList.find { u -> u.username == myUser }

            if(userEncontrado != null) {
                if(userEncontrado.password == myPassword)
                {
                    showSnackbar("Login successful")
                } else {
                    showSnackbar("Username or password incorrect")
                }
            } else {
                showSnackbar("Username and password does not exist")
            }

            if (myUser.isEmpty() && myPassword.isEmpty()) {
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