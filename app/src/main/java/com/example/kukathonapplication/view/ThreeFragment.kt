package com.example.kukathonapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kukathonapplication.R
import com.example.kukathonapplication.api.APIS
import com.example.kukathonapplication.api.RetrofitInstance
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentThreeBinding
import com.example.kukathonapplication.model.ResponseCommentList
import com.example.kukathonapplication.model.ResponseEnterpriseList
import com.example.kukathonapplication.model.comments
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThreeFragment : BaseFragment<FragmentThreeBinding>(R.layout.fragment_three) {
    private lateinit var API : APIS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)



    }


}