package com.example.kukathonapplication.api


import com.example.kukathonapplication.model.ResponseEnterpriseList
import com.example.kukathonapplication.model.enterpriseInfo
import com.example.kukathonapplication.Datamodel
import com.example.kukathonapplication.detail
import com.example.kukathonapplication.model.ResponseCommentList
import com.example.kukathonapplication.model.comments
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIS {
    @GET("/api/product?category=all")
    fun postAllData(): Call<Datamodel>

    @GET("/api/product?category=job")
    fun postJobData(): Call<Datamodel>

    @GET("/api/product?category=donation")
    fun postDonationData():Call<Datamodel>

    @GET("enterprise/list")
    fun getEnterpriseList(

    ) : Call<ResponseEnterpriseList>

    @GET("/api/product/{productId}")
    fun postDetailData(@Path("productId") id: Int): Call<detail>


    @GET("comment/list")
    fun getCommentList(

    ) : Call<ResponseCommentList>

}