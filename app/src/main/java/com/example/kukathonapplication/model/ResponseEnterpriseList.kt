package com.example.kukathonapplication.model

data class ResponseEnterpriseList(

    var isSuccess : String,
    var code : Int,
    var message : String,
    var httpStatus : String,
    var data : enterpriseInfo

)

data class enterpriseInfo(
    var name : String,
    var description : String,
    var shortsUrl : String,
    var articleUrl : String
)
