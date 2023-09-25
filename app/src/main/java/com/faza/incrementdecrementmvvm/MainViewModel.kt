package com.faza.incrementdecrementmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.currentCoroutineContext

class MainViewModel : ViewModel() {
    // vm menjaga data agar tidak restart data ke nol
    //observable
    //tidak boleh melakukan perubahandata secara klangsung, makanyabuat backiing properties
    //membuat variabel, diawali underscore, private, mutab di view model
   // private var _counter : MutableLiveData<Int> = MutableLiveData()
   //ownew pemegang data
    //provider pengelola

    private val _counter : MutableLiveData<Int> = MutableLiveData<Int>().apply {
        postValue(0)
    }

    val counter : LiveData<Int>
        get() = _counter

    fun increment(){
        val curentValue= _counter.value ?:0
        val value = curentValue +1
        _counter.postValue(value)
    }
    fun decrement(){
        val curentValue= _counter.value ?:0
        if(curentValue <= 0) return
        val value = curentValue -1
        _counter.postValue(value)
    }

    //isolated var
    //backing properties
    //mutable live dta bisa ambil datanya
//    val counter : LiveData<Int>
//        get() = _counter

    //buat method increment
    //

}