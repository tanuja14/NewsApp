package com.example.newsapp

import android.accounts.AuthenticatorDescription

data class News(
    val title:String,
    val description:String,
    val url:String,
    val imageUrl:String
)