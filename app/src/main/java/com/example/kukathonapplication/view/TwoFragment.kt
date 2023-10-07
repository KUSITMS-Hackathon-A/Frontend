package com.example.kukathonapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwoBinding

class TwoFragment : BaseFragment<FragmentTwoBinding>(R.layout.fragment_two) {

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


//        val webSettings: WebSettings = binding.web.settings
//        webSettings.javaScriptEnabled = true
//
//
//        binding.web.webViewClient = WebViewClient()
//
//        binding.web.loadUrl("https://www.youtube.com/shorts/r8zg091XPmI")

    }

}