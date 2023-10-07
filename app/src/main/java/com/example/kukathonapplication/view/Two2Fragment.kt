package com.example.kukathonapplication.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwo2Binding
import com.example.kukathonapplication.model.enterpriseInfo
import com.google.android.material.bottomnavigation.BottomNavigationView


class Two2Fragment : BaseFragment<FragmentTwo2Binding>(R.layout.fragment_two2) {

    var enterpriseInfo  = ArrayList<enterpriseInfo>()

    var newsURL = ""
    var videoURL = ""
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

        videoURL = arguments?.getString("shortsUrl").toString()
        newsURL = arguments?.getString("articleUrl").toString()
        Log.d("newsURL", newsURL)
        Log.d("videoURL", videoURL)

        //비디오 클릭 이벤트

        binding.btnVideo.setOnClickListener {

            val bundle = bundleOf("videoURL" to videoURL)

            val navController = findNavController()
            navController.navigate(R.id.action_two2Fragment_to_two3Fragment,bundle)
        }

        //뉴스 클릭 이벤트

        binding.btnNews.setOnClickListener {

            //val news = "https://www.rebud.co.kr/News/?q=YToxOntzOjEyOiJrZXl3b3JkX3R5cGUiO3M6MzoiYWxsIjt9&bmode=view&idx=7075162&t=board"
            val news = newsURL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news))
            startActivity(intent)


        }

        //뒤로가기
        binding.imageView2.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_two2Fragment_to_twoFragment)
        }
    }


}