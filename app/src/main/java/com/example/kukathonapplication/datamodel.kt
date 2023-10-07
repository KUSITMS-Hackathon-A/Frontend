package com.example.kukathonapplication

data class Datamodel(
    val code: Int,
    val data: List<Content>,
    val httpStatus: String,
    val isSuccess: Boolean,
    val message: String
)
data class Content(
    val description: String,
    val enterprise: String,
    val imageUrl: String,
    val name: String,
    val price: String,
    val productId: Int,
    val progress: Int
)

data class detail(
    val code: Int,
    val data: detailcontent,
    val httpStatus: String,
    val isSuccess: Boolean,
    val message: String
)
data class detailcontent(
    val category: String,
    val description: String,
    val progressTitle:String,
    val progressDescription:String,
    val progress : Int,
    val description1: String,
    val description2: String,
    val enterprise: String,
    val imageUrl: String,
    val imageUrl1: String,
    val imageUrl2: String,
    val name: String,
    val price: String
)