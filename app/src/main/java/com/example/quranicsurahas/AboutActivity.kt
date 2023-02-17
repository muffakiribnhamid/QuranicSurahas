package com.example.quranicsurahas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.example.quranicsurahas.api.RetrofitInstance
import com.example.quranicsurahas.databinding.ActivityAboutBinding
import com.example.quranicsurahas.databinding.ActivityLayoutBinding
import com.example.quranicsurahas.models.AboutModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        getInfo()
        
        val id = intent.getStringExtra("id")
    }
    private fun getInfo() {
        val id = intent.getStringExtra("id")
        RetrofitInstance.apiinterface.getInfo("${id}").enqueue(object : Callback<AboutModel>{
            override fun onResponse(call: Call<AboutModel>, response: Response<AboutModel>) {
                if (response.isSuccessful) {
                    binding.tvAbout.text = response.body()!!.chapter_info.short_text
                    binding.tvSource.text = response.body()!!.chapter_info.source
                    binding.tvDescription.text = Html.fromHtml(response.body()!!.chapter_info.text)
                }
                else {
                    Toast.makeText(this@AboutActivity, "Error fetching Data", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<AboutModel>, t: Throwable) {
                Toast.makeText(this@AboutActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}