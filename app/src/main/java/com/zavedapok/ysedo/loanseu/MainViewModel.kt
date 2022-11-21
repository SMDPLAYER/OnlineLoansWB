package com.zavedapok.ysedo.loanseu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val liveData = MutableLiveData<String>()
    // TODO: Implement the ViewModel
    init {
        liveData.value = ""

        fun hello() {
            liveData.value = ""
        }
    }
}
