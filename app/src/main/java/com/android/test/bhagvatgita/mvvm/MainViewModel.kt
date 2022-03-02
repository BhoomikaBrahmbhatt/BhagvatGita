package com.android.test.bhagvatgita.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val chaptersList = MutableLiveData<List<Chapters>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllChapters(api_key:String) {
        val response = repository.getAllChapters(api_key)
        response.enqueue(object : Callback<List<Chapters>> {
            override fun onResponse(call: Call<List<Chapters>>, response: Response<List<Chapters>>) {
                chaptersList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Chapters>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}