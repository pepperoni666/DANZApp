package com.example.daznapp.data

import com.example.daznapp.remote.RemoteServiceInterface
import retrofit2.Retrofit

class EventsRepository(retrofit: Retrofit) {
    private val client = retrofit.create(RemoteServiceInterface::class.java)

    suspend fun getEvents(): List<SportEvent> {
        return client.getEvents()
    }
}