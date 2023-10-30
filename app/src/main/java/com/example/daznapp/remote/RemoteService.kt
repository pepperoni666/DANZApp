package com.example.daznapp.remote

import com.example.daznapp.data.SportEvent
import retrofit2.http.GET

interface RemoteServiceInterface {
    @GET("getSchedule")
    suspend fun getSchedule(): List<SportEvent>

    @GET("getEvents")
    suspend fun getEvents(): List<SportEvent>
}