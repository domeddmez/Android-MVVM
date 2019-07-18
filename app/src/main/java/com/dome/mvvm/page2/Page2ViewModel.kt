/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dome.mvvm.page2


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.promptnow.testkotlin.ApiService
import com.example.promptnow.testkotlin.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Page2ViewModel(application: Application) : AndroidViewModel(application) {
    val dataModel: LiveData<DataModel> = loadAndroidData()

    private fun loadAndroidData(): MutableLiveData<DataModel> {
        val data = MutableLiveData<DataModel>()

        val apiService = ApiService.create()
        val call = apiService.getCategoryDetails()
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
}

