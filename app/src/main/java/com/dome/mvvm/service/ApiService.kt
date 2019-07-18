package com.example.promptnow.testkotlin

import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.*


/**
 * Created by PromptNow on 1/9/2019.
 */
interface ApiService {

    @GET("?json=get_category_index")
    fun getCategoryDetails(): Call<DataModel>

    @POST("/posts")
    @FormUrlEncoded
    fun savePost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Long
    ): Call<DataModel>

    companion object Factory {
        private const val BASE_URL = "https://androidteachers.com"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}