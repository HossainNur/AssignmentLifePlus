package com.nurhossain.assignmentlifeplus.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nurhossain.assignmentlifeplus.R
import com.nurhossain.assignmentlifeplus.databinding.ActivityProfileBinding
import com.nurhossain.assignmentlifeplus.viemodel.UserViewModel

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel : UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getUser().observe(this){user ->
            val name = user.last().name
            val userName = user.last().username
            val phoneNumber = user.last().password
            Toast.makeText(this,name,Toast.LENGTH_SHORT).show()

            if (name.isNotEmpty()) binding.tvNameValue.text = name
            if (userName.isNotEmpty()) binding.tvUsernameValue.text = userName
        }
    }
}