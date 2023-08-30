package com.annaginagili.avengers

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("marvel")
    fun getHeroes(): Call<List<Hero>>
}