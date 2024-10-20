package com.curiozing.todo

import kotlinx.coroutines.CoroutineScope
expect open class BaseViewModel() {
    var scope: CoroutineScope
}

