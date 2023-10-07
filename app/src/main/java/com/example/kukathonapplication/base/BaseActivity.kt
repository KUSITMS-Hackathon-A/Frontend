package com.example.kukathonapplication.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.kukathonapplication.R

class BaseActivity<T : ViewDataBinding> ( @LayoutRes val layoutRes: Int) : AppCompatActivity() {

    protected lateinit var binding : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)

        binding.lifecycleOwner = this@BaseActivity
    }
}