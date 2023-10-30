package com.example.daznapp.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val remoteModule = module {
    single {
        val builder = OkHttpClient.Builder()

        // Add the interceptor to OkHttpClient
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.networkInterceptors().add(httpLoggingInterceptor)
        val client = builder.build()

        Retrofit.Builder()
            .baseUrl("https://us-central1-dazn-sandbox.cloudfunctions.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}