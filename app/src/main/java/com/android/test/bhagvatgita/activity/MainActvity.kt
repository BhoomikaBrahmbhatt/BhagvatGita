package com.android.test.bhagvatgita.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.test.bhagvatgita.R
import com.android.test.bhagvatgita.adapter.ChaptersAdapter
import com.android.test.bhagvatgita.databinding.ActivityMainBinding
import com.android.test.bhagvatgita.mvvm.MainRepository
import com.android.test.bhagvatgita.mvvm.MainViewModel
import com.android.test.bhagvatgita.mvvm.MyViewModelFactory
import com.android.test.bhagvatgita.mvvm.RetrofitService
import com.android.test.bhagvatgita.unit.Units

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = ChaptersAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.chaptersList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllChapters(Units.mapi_key)
    }
}