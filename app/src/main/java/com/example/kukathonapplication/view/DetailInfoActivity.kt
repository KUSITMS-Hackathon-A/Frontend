package com.example.kukathonapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.kukathonapplication.Content
import com.example.kukathonapplication.R
import com.example.kukathonapplication.api.APIS
import com.example.kukathonapplication.api.RetrofitInstance
import com.example.kukathonapplication.base.BaseActivity
import com.example.kukathonapplication.databinding.ActivityDetailInfoBinding
import com.example.kukathonapplication.detail
import com.example.kukathonapplication.detailcontent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.toMutableList

class DetailInfoActivity : BaseActivity<ActivityDetailInfoBinding>(R.layout.activity_detail_info) {
    val service = RetrofitInstance.retrofitInstance().create(APIS::class.java)
    private var alldata = mutableListOf<detailcontent>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productId = intent.getIntExtra("productId",-1)
        if(productId != -1)
        {
            //api호출
            Log.e("api","${productId}")
            val id = productId
            fetchDetail(id)
        }
        binding.progressbar.setOnTouchListener{v,event->true}
        binding.complete.setOnClickListener{
            val dialog = DialogFragment()
            dialog.show(supportFragmentManager, "tag")
        }
    }

    fun fetchDetail(id:Int){
        service.postDetailData(id).enqueue(object : Callback<detail>{
            override fun onResponse(call: Call<detail>, response: Response<detail>) {
                if(response.isSuccessful){
                    response.body()?.data?.let{
                        alldata.add(it)
                        updateUI()
                    }
                }
                else{
                    Log.e("error", "api호출 에러")
                }
            }

            override fun onFailure(call: Call<detail>, t: Throwable) {
                Log.e("error", "기타 에러")
            }
        })
    }
    fun updateUI(){
        val mainImg = binding.mainImg
        if(alldata.isNotEmpty()){
            Glide.with(this)
                .load(alldata[0].imageUrl)
                .centerCrop()
                .into(mainImg)

            binding.companyName.text = alldata[0].enterprise
            var category = alldata[0].category
            if(category == "job"){
                binding.categoryName.text = "일자리 창출"
                binding.categoryImg.setImageResource(R.drawable.select3)
            }
            if(category == "donation"){
                binding.categoryName.text = "수익 기부"
                binding.categoryImg.setImageResource(R.drawable.select2)
            }

            binding.productName.text = alldata[0].name
            binding.productDetail.text = alldata[0].description
            binding.price.text = alldata[0].price
            binding.progressTitle.text = alldata[0].progressTitle

            binding.progressContent.text = alldata[0].progressDescription
            binding.progressbar.progress = alldata[0].progress

            val changevalue = 100-alldata[0].progress
            binding.resulttxt.text = "달성까지 ${changevalue}% 남았어요!"
            val spannable = SpannableStringBuilder(binding.resulttxt.text)
            val start = binding.resulttxt.text.indexOf(changevalue.toString())
            val end = start + changevalue.toString().length + 1
            val colorSpan = ForegroundColorSpan(ContextCompat.getColor(this, R.color.main2))
            spannable.setSpan(colorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            binding.resulttxt.text = spannable

            Glide.with(this)
                .load(alldata[0].imageUrl1)
                .centerCrop()
                .into(binding.descripImg1)
            Glide.with(this)
                .load(alldata[0].imageUrl2)
                .centerCrop()
                .into(binding.descripImg2)
            binding.describContent1.text = alldata[0].description1
            binding.describContent2.text = alldata[0].description2
        }
    }
}