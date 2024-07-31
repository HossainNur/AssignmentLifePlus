package com.nurhossain.assignmentlifeplus.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nurhossain.assignmentlifeplus.databinding.ActivityLoginBinding
import com.nurhossain.assignmentlifeplus.ui.dashboard.DashboardActivity
import com.nurhossain.assignmentlifeplus.ui.registration.RegistrationActivity
import com.nurhossain.assignmentlifeplus.viemodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val username = binding.userName.text.toString()
            val password = binding.password.text.toString()

            loginUser(username,password)

        }
        binding.registration.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegistrationActivity::class.java))
        }
    }

    private fun loginUser(username: String, password: String) {
        userViewModel.getUser(username, password).observe(this, Observer { user ->
            if (user != null) {
                Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        })
    }
}