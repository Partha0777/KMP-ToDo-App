package com.curiozing.todo.Articles

import com.curiozing.todo.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {

    private var articles: MutableStateFlow<String> = MutableStateFlow("Hey")
    val _articles: StateFlow<String> get() = articles

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(1500)
            articles.emit("Hello Droid")
        }
    }
}