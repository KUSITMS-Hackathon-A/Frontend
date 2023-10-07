package com.example.kukathonapplication.view

import android.net.Uri
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kukathonapplication.Content
import com.example.kukathonapplication.R
import org.w3c.dom.Text

class HomeAdapter(private var items:List<Content>):RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //val image:
        val company:TextView = itemView.findViewById(R.id.company_name)
        val productName:TextView = itemView.findViewById(R.id.product_name)
        val detail:TextView = itemView.findViewById(R.id.detail)
        val price : TextView = itemView.findViewById(R.id.price)
        val progress : SeekBar = itemView.findViewById(R.id.progressbar)
        val image:ImageView = itemView.findViewById(R.id.image)
        val percentage:TextView= itemView.findViewById(R.id.resulttxt)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val list = items[position]
        val changevalue = 100-list.progress
        holder.progress.setOnTouchListener{v,event->true}
        holder.company.text = list.enterprise
        holder.productName.text = list.name
        holder.detail.text = list.description
        holder.price.text = list.price
        holder.progress.progress = list.progress
        holder.percentage.text = "달성까지 ${changevalue}% 남았어요!"
        val spannable = SpannableStringBuilder(holder.percentage.text)

        // 숫자와 % 부분의 인덱스를 찾습니다.
        val start = holder.percentage.text.indexOf(changevalue.toString())
        val end = start + changevalue.toString().length + 1


        val colorSpan = ForegroundColorSpan(ContextCompat.getColor(holder.itemView.context, R.color.main2))
        spannable.setSpan(colorSpan, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        holder.percentage.text = spannable
        Glide.with(holder.itemView.context)
            .load(list.imageUrl)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateList(newData:List<Content>){
        this.items = newData
        notifyDataSetChanged()
    }
}