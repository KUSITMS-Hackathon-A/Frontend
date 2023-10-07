package com.example.kukathonapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.kukathonapplication.R
import com.example.kukathonapplication.databinding.FragmentDialogBinding

class DialogFragment : DialogFragment() {
    lateinit var binding : FragmentDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
//binding = DataBindingUtil.inflate(inflater,layoutRes,container,false)
//
//        val view = binding.root
//        return view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dialog,container,false)
        val view = binding.root
    binding.close.setOnClickListener{
        dismiss()
    }
        return view

    }

}