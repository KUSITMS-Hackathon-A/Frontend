package com.example.kukathonapplication.view

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
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

class OneFragment : BaseFragment<FragmentOneBinding>(R.layout.fragment_one),HomeAdapter.onDetailItemClickListener {
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

        homeAdapter.onDetailClickListener = this

        viewModel.alldata.observe(viewLifecycleOwner){ data->
            homeAdapter = HomeAdapter(data)
            homeAdapter.onDetailClickListener = this
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

    override fun onDetailItemClicked(productId: Int) {
        //화면전환
        Log.e("intent","전")
        val intent= Intent(activity,DetailInfoActivity::class.java)
        intent.putExtra("productId", productId)
        Log.e("intent","후")
        startActivity(intent)
    }

}