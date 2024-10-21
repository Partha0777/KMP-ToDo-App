package com.curiozing.kmptodoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform