package com.curiozing.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform