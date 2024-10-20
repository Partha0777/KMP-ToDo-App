package com.curiozing.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class BaseViewModel{
    actual var scope:CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear(){
        scope.cancel()
    }
}