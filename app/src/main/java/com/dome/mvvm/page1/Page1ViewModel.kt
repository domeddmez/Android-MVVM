package com.dome.mvvm.page1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Page1ViewModel : ViewModel() {

    var items1: LiveData<List<String>>? = null


    fun getItems() {
        items1 = MutableLiveData<List<String>>().apply { value = ItemsRepository().getItemsPage() }
    }
}

