package com.example.smoketimer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.smoketimer.database.SmokeEntity

class SmokeViewModel: ViewModel() {

    private val myAppRepository = MyAppRepository.get()

    fun addItem(item: SmokeEntity) {
        myAppRepository.addItem(item)
    }

    fun updateItem(item: SmokeEntity) {
        myAppRepository.updateItem(item)
    }

    fun deleteItem(item: SmokeEntity) {
        myAppRepository.deleteItem(item)
    }

    fun getItemById(id: String) : LiveData<SmokeEntity?> {
        return myAppRepository.getItemById(id)
    }

    val listItemsLiveData = myAppRepository.getItems()

}