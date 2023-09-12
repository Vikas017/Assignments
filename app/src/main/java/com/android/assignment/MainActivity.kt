package com.android.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.assignment.adapter.CallLogListAdapter
import com.android.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val callLogListAdapter = CallLogListAdapter(onClickPerform = { onClickPerformer() })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializer()
    }

    private fun initializer() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = callLogListAdapter
            imageViewReferesh.setOnClickListener { onClickPerformer() }
            imageViewSetting.setOnClickListener { onClickPerformer() }
        }
    }

    private fun onClickPerformer(): Unit {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }
}