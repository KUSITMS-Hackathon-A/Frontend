package com.example.kukathonapplication.api

import com.example.kukathonapplication.Datamodel
import retrofit2.Call
import retrofit2.http.GET

interface APIS {
    @GET("/api/product?category=all")
    fun postAllData(): Call<Datamodel>

    @GET("/api/product?category=job")
    fun postJobData(): Call<Datamodel>

    @GET("/api/product?category=donation")
    fun postDonationData():Call<Datamodel>

}