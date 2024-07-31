package com.nurhossain.assignmentlifeplus.ui.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nurhossain.assignmentlifeplus.api.models.User
import com.nurhossain.assignmentlifeplus.databinding.ActivityRegistrationBinding
import com.nurhossain.assignmentlifeplus.ui.dashboard.DashboardActivity
import com.nurhossain.assignmentlifeplus.viemodel.UserViewModel

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var userViewModel: UserViewModel
    //val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        /*userViewModel.getUser().observe(this , Observer {  user->
            // set the layout manager and the adapter for the recycler view
            Toast.makeText(this, ""+user.last().name, Toast.LENGTH_SHORT).show()
        })*/

        userViewModel.saveStatus.observe(this, Observer { isSaved ->
            if (isSaved) {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Failed to save", Toast.LENGTH_SHORT).show()
            }
        })

        binding.registration.setOnClickListener {
            val name = binding.name.text.toString()
            val username = binding.userName.text.toString()
            val password = binding.password.text.toString()


            val data = User(name = name , username = username, password = password)

            userViewModel.addUser(data)

            // display a Toast message to confirm the save
            //Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,DashboardActivity::class.java))
        }


    }
}