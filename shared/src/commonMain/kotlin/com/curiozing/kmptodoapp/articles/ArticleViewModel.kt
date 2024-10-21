package com.curiozing.kmptodoapp.articles

// ArticleViewModel.kt
import com.curiozing.kmptodoapp.BaseViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

class ArticleViewModel : BaseViewModel() {
    private var _articles: MutableStateFlow<String> = MutableStateFlow("Hello")
    val articles: StateFlow<String> get() = _articles

    init {
        getArticles()
    }

    // Make this function public so it can be accessed in Swift
    fun getArticles() {
        scope.launch {
            delay(500)
            _articles.emit("Partha")
        }
    }

    // Expose a method to collect the flow from Swift
    fun observeArticles(onEachArticle: (String) -> Unit) {
        scope.launch {
            articles.onEach { article ->
                onEachArticle(article)
            }.collect()
        }
    }
}
