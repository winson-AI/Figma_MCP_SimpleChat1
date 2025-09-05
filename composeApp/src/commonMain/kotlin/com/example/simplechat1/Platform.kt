package com.example.simplechat1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform