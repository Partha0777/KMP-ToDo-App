package com.curiozing.kmptodoapp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope:CoroutineScope
}