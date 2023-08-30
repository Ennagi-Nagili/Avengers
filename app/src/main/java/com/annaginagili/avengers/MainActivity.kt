package com.annaginagili.avengers

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: RecyclerAdapter
    var nameList = ArrayList<String>()
    var realNameList = ArrayList<String>()
    var teamList = ArrayList<String>()
    var firstList = ArrayList<String>()
    var createdList = ArrayList<String>()
    var publisherList = ArrayList<String>()
    var imageList = ArrayList<Uri>()
    var bioList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler)

        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = manager
        getSuperHeroes()
    }

    private fun getSuperHeroes() {
        val call = RetrofitClient.getInstance().getApi().getHeroes()
        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                val heroList: ArrayList<Hero> = response.body() as ArrayList<Hero>
                for (i in heroList) {
                    nameList.add(i.getName())
                    realNameList.add(i.getRealName())
                    teamList.add(i.getTeam())
                    firstList.add(i.getFirstAppearance())
                    createdList.add(i.getCreatedBy())
                    publisherList.add(i.getPublisher())
                    bioList.add(i.getBio())
                    imageList.add(Uri.parse(i.getImageUrl()))
                }
                val adapterItem = AdapterItem()
                adapter = RecyclerAdapter(this@MainActivity, adapterItem.getData(nameList, realNameList, teamList, firstList,
                createdList, publisherList, imageList, bioList))
                recycler.adapter = adapter
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show();
            }
        })
    }
}