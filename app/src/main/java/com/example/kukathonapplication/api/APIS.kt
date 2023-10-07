package com.example.kukathonapplication.api

import com.example.kukathonapplication.Datamodel
import com.example.kukathonapplication.detail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIS {
    @GET("/api/product?category=all")
    fun postAllData(): Call<Datamodel>

    @GET("/api/product?category=job")
    fun postJobData(): Call<Datamodel>

    @GET("/api/product?category=donation")
    fun postDonationData():Call<Datamodel>

    @GET("/api/product/{productId}")
    fun postDetailData(
        @Path("productId") productId:Int
    ):Call<detail>


}