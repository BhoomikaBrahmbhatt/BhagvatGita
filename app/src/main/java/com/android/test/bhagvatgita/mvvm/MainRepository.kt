package com.android.test.bhagvatgita.mvvm

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllChapters(api_key: String) = retrofitService.getAllGitaChapters(api_key)
}