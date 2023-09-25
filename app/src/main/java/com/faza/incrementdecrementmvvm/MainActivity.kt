package com.faza.incrementdecrementmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.faza.incrementdecrementmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setOnClickListener()
        observeState()
    }

    private fun observeState() {
        viewModel.counter.observe(this){
            binding.tvCounter.text = it.toString()
        }
    }

    private fun setOnClickListener() {
        binding.btnDecrement.setOnClickListener {
            decrement() //setiap tombol di click
        }
        binding.btnIncrement.setOnClickListener {
            increment()
        }
    }
//escape
    private fun decrement() {
/*        if (counter <= 0) return
        counter -= 1
        binding.tvCounter.text = counter.toString()*/
        viewModel.decrement()
    }

    private fun increment() {
/*        counter += 1
        binding.tvCounter.text = counter.toString()*/
        viewModel.increment()
    }


}