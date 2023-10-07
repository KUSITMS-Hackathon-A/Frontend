package com.example.kukathonapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kukathonapplication.Content
import com.example.kukathonapplication.Datamodel
import com.example.kukathonapplication.api.APIS
import com.example.kukathonapplication.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneViewModel : ViewModel() {
    val service = RetrofitInstance.retrofitInstance().create(APIS::class.java)

    private val _alldata = MutableLiveData<List<Content>>()
    val alldata:LiveData<List<Content>> = _alldata

    init {
        fetchAllResult()
    }

    fun fetchAllResult(){
        service.postAllData().enqueue(object: Callback<Datamodel>{
            override fun onResponse(call: Call<Datamodel>, response: Response<Datamodel>) {
                if(response.isSuccessful)
                {
                    _alldata.value = response.body()?.data
                    Log.e("good", "성공")
                }
                else{
                    Log.e("error", "api호출 에러")
                }
            }

            override fun onFailure(call: Call<Datamodel>, t: Throwable) {
               Log.e("error", "기타 에러")
            }

        })
    }
    fun fetchJobResult(){
        service.postJobData().enqueue(object: Callback<Datamodel>{
            override fun onResponse(call: Call<Datamodel>, response: Response<Datamodel>) {
                if(response.isSuccessful)
                {
                    _alldata.value = response.body()?.data
                    Log.e("good", "성공")
                }
                else{
                    Log.e("error", "api호출 에러")
                }
            }

            override fun onFailure(call: Call<Datamodel>, t: Throwable) {
                Log.e("error", "기타 에러")
            }

        })
    }
    fun fetchDonationResult(){
        service.postDonationData().enqueue(object: Callback<Datamodel>{
            override fun onResponse(call: Call<Datamodel>, response: Response<Datamodel>) {
                if(response.isSuccessful)
                {
                    _alldata.value = response.body()?.data
                    Log.e("good", "성공")
                }
                else{
                    Log.e("error", "api호출 에러")
                }
            }

            override fun onFailure(call: Call<Datamodel>, t: Throwable) {
                Log.e("error", "기타 에러")
            }

        })
    }

}