package com.example.daznapp.data

import com.example.daznapp.remote.RemoteServiceInterface
import retrofit2.Retrofit

class ScheduleRepository(retrofit: Retrofit) {
    private val client = retrofit.create(RemoteServiceInterface::class.java)

    suspend fun getSchedule(): List<SportEvent> {
        return client.getSchedule()
    }
}