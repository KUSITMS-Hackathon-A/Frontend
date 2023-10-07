package com.example.kukathonapplication.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwo2Binding


class Two2Fragment : BaseFragment<FragmentTwo2Binding>(R.layout.fragment_two2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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


        //비디오 클릭 이벤트


        //뉴스 쿨릭 이벤트

        binding.btnNews.setOnClickListener {

            val news = "https://www.rebud.co.kr/News/?q=YToxOntzOjEyOiJrZXl3b3JkX3R5cGUiO3M6MzoiYWxsIjt9&bmode=view&idx=7075162&t=board"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news))
            startActivity(intent)


        }
    }


}