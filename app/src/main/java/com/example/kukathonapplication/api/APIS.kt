package com.example.kukathonapplication.api

import com.example.kukathonapplication.model.ResponseEnterpriseList
import com.example.kukathonapplication.model.enterpriseInfo
import retrofit2.Call
import retrofit2.http.GET

interface APIS {

    @GET("enterprise/list")
    fun getEnterpriseList(

    ) : Call<ResponseEnterpriseList>

}