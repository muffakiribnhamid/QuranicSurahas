package com.example.quranicsurahas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranicsurahas.adpaters.MainActivityAdapter
import com.example.quranicsurahas.api.RetrofitInstance
import com.example.quranicsurahas.databinding.ActivityMainBinding
import com.example.quranicsurahas.models.Chapter
import com.example.quranicsurahas.models.SurahModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var RecyclerView : MainActivityAdapter
    private var chapters: ArrayList<Chapter> = arrayListOf<Chapter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

         getData()






    }

    private fun getData() {
        RetrofitInstance.apiinterface.getData().enqueue(object : Callback<SurahModel>{
            override fun onResponse(call: Call<SurahModel>, response: Response<SurahModel>) {
                if (response.isSuccessful) {
                    chapters.addAll(response.body()?.chapters as ArrayList<Chapter>)
                    RecyclerView = MainActivityAdapter(chapters,this@MainActivity)
                    binding.rcmain.adapter = RecyclerView
                    binding.rcmain.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                    binding.progressBar.visibility = View.GONE
                }
                else {

                        Toast.makeText(this@MainActivity, "Error fetching Data", Toast.LENGTH_SHORT).show()
                    }




            }

            override fun onFailure(call: Call<SurahModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,"ERROR CHECK YOUR CONNECTION",Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE

            }
        })
    }

}

