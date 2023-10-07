package com.example.kukathonapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwo3Binding


class Two3Fragment : BaseFragment<FragmentTwo3Binding>(R.layout.fragment_two3) {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val webSettings: WebSettings = binding.web.settings
        webSettings.javaScriptEnabled = true


        binding.web.webViewClient = WebViewClient()

        binding.web.loadUrl("https://www.youtube.com/shorts/r8zg091XPmI")

    }


}