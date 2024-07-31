package com.nurhossain.assignmentlifeplus.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nurhossain.assignmentlifeplus.R
import com.nurhossain.assignmentlifeplus.databinding.ActivityDetailsviewBinding

class DetailsviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}