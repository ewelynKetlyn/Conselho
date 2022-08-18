package com.example.conselho.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conselho.R
import com.example.conselho.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: AdviceViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdviceObserver()

        binding.btnNewadvice.setOnClickListener{
                getAdvicebtn()
        }
    }

    fun setupAdviceObserver(){
        viewModel.advice.observe(this){
            binding.txtConselhoAqui.text = it.slip.advice
        }
    }
    fun getAdvicebtn(){
        viewModel.getAdvice()
    }
}