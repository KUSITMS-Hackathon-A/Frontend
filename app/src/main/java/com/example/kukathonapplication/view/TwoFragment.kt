package com.example.kukathonapplication.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TwoFragment : BaseFragment<FragmentTwoBinding>(R.layout.fragment_two) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityy = activity as MainActivity

        val bottomnav = activityy.findViewById<BottomNavigationView>(R.id.bottom_navi)

        bottomnav.visibility= View.VISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCard1.setOnClickListener {




            val bundle = bundleOf()
            val navController = findNavController()

            navController.navigate(R.id.action_twoFragment_to_two2Fragment,bundle)
        }






    }

}