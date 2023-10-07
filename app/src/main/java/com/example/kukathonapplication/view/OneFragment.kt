package com.example.kukathonapplication.view

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.kukathonapplication.R
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentOneBinding
import com.example.kukathonapplication.viewmodel.OneViewModel

class OneFragment : BaseFragment<FragmentOneBinding>(R.layout.fragment_one) {
    private val viewModel by viewModels<OneViewModel>()
    private lateinit var homeAdapter: HomeAdapter

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
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val recyclerView = binding.recycler

        homeAdapter = HomeAdapter(mutableListOf())
        recyclerView.adapter = homeAdapter

        viewModel.alldata.observe(viewLifecycleOwner){ data->
            homeAdapter = HomeAdapter(data)
            recyclerView.adapter = homeAdapter
        }
        binding.selectA.setOnClickListener{
            viewModel.fetchAllResult()
        }

        binding.selectB.setOnClickListener{
            viewModel.fetchDonationResult()
        }
        binding.selectC.setOnClickListener{
            viewModel.fetchJobResult()
        }
        viewModel.fetchAllResult()

        var fullText = binding.title.text
        val spannable = SpannableString(fullText)
        val start = fullText.indexOf("사회적 연결")
        val end = start+"사회적 연결".length

        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.main1)), // 색상을 변경할 Span 객체
            start, // 변경할 텍스트의 시작 인덱스
            end, // 변경할 텍스트의 끝 인덱스
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.title.text = spannable

    }

}