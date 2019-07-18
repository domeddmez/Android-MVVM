/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dome.mvvm.page2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.promptnow.testkotlin.ApiService
import com.example.promptnow.testkotlin.DataModel
import okhttp3.internal.Internal.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by dome
 */
class NewsRepository {
    private val newsService: ApiService

    init  {
        val BASE_URL = "https://androidteachers.com"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsService = retrofit.create(ApiService::class.java!!)
    }


    fun loadAndroidData(): LiveData<DataModel> {
        val data = MutableLiveData<DataModel>()
        val call = newsService.getCategoryDetails()
        call.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                Log.d("dome", "Success")
                data.value = response.body()

            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.d("dome", "Fails")
                data.value = null

            }
        })
        return data
    }
//
//    companion object {
//        private var projectRepository: NewsRepository? = null
//
//        val instance: NewsRepository
//            @Synchronized get() {
//                if (projectRepository == null) {
//                    if (projectRepository == null) {
//                        projectRepository = NewsRepository()
//                    }
//                }
//                return projectRepository!!
//            }
//    }

}