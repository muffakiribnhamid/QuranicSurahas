package com.example.quranicsurahas.adpaters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quranicsurahas.AboutActivity
import com.example.quranicsurahas.models.Chapter
import com.example.quranicsurahas.R
import com.example.quranicsurahas.databinding.ActivityLayoutBinding

class MainActivityAdapter(
    var surahList : List<Chapter>,
    var context : Context

) : RecyclerView.Adapter<MainActivityAdapter.MainActivityAdapter>(){


    inner class MainActivityAdapter(private var LayoutActivityBinding: ActivityLayoutBinding):
        RecyclerView.ViewHolder(LayoutActivityBinding.root) {
            var SurahName : TextView? = null
            var TranslatedName : TextView? = null
            var id : TextView? = null
            var arabic : TextView? = null

        init {
            SurahName = itemView.findViewById(R.id.surahname)
            TranslatedName = itemView.findViewById(R.id.translatedname)
            id = itemView.findViewById(R.id.tv_sno)
            arabic = itemView.findViewById(R.id.arabicname)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityAdapter {
        val layoutBinding : ActivityLayoutBinding = ActivityLayoutBinding.inflate(
            LayoutInflater.from(context),parent,false)
        return MainActivityAdapter(layoutBinding)
    }

    override fun getItemCount(): Int {
        return surahList.size
    }

    override fun onBindViewHolder(holder: MainActivityAdapter, position: Int) {
        val userModel = surahList[position]
        holder.TranslatedName!!.text = userModel.translated_name.name
        holder.SurahName!!.text = userModel.name_simple
        holder.id!!.text = userModel.id.toString()
        holder.arabic!!.text = userModel.name_arabic

        holder.itemView.setOnClickListener {
            val intent = Intent(context,AboutActivity::class.java)
            intent.putExtra("id",holder.id!!.text)
            context.startActivity(intent)
        }
    }
}