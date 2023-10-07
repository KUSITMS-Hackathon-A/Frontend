package com.example.kukathonapplication.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.kukathonapplication.R
import com.example.kukathonapplication.api.APIS
import com.example.kukathonapplication.api.RetrofitInstance
import com.example.kukathonapplication.base.BaseFragment
import com.example.kukathonapplication.databinding.FragmentTwoBinding
import com.example.kukathonapplication.model.ResponseEnterpriseList
import com.example.kukathonapplication.model.enterpriseInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TwoFragment : BaseFragment<FragmentTwoBinding>(R.layout.fragment_two) {

    private lateinit var API : APIS
    var name = ""
    var description = ""
    var shortsUrl = ""
    var articleUrl = ""

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


            API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

            try{
                API.getEnterpriseList().enqueue(
                    object : Callback<ResponseEnterpriseList> {

                        override fun onResponse(call: Call<ResponseEnterpriseList>, response: Response<ResponseEnterpriseList>) {
                            if (response.isSuccessful) {

                                name = response.body()!!.data.name
                                description = response.body()!!.data.description
                                shortsUrl = response.body()!!.data.shortsUrl
                                articleUrl = response.body()!!.data.articleUrl
                                Log.d("enterpriseInfo : " , " success , ${response.body().toString()}")

                                val bundle = bundleOf("articleUrl" to articleUrl,"shortsUrl" to shortsUrl)
                                val navController = findNavController()

                                navController.navigate(R.id.action_twoFragment_to_two2Fragment,bundle)
                            } else {

                                Log.d("enterpriseInfo Response : ", "fail 1 , ${response.body().toString()} , ${response.message()}, ${response.errorBody().toString()}")
                            }
                        }

                        override fun onFailure(call: Call<ResponseEnterpriseList>, t: Throwable) {
                            Log.d("enterpriseInfo Response : ", " fail 2 , ${t.message.toString()}")
                        }
                    })
            } catch (e:Exception) {
                Log.d("enterpriseInfo response : ", " fail 3 , ${e.message}")
            }


        }






    }

}