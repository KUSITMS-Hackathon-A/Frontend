package com.example.kukathonapplication.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwo3Binding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Two3Fragment : BaseFragment<FragmentTwo3Binding>(R.layout.fragment_two3) {


    var showvideo = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityy = activity as MainActivity

        val bottomnav = activityy.findViewById<BottomNavigationView>(R.id.bottom_navi)

        bottomnav.visibility= View.GONE

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        showvideo = arguments?.getString("videoURL").toString()

        Log.d("showvideo", showvideo)
        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true


        binding.web.webViewClient = WebViewClient()

        binding.web.loadUrl(showvideo)

        //뒤로가기

        binding.imageView3.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_two3Fragment_to_two2Fragment)
        }
    }


}