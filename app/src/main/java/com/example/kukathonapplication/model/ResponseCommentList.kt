package com.example.kukathonapplication.model

data class ResponseCommentList(
    var isSuccess : String,
    var code : Int,
    var message : String,
    var httpStatus : String,
    var data : ArrayList<comments>
)

data class comments(
    var enterpriseName : String,
    var content : String
)
