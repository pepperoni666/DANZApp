package com.example.daznapp.di

import com.example.daznapp.data.EventsRepository
import com.example.daznapp.data.ScheduleRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { EventsRepository(get()) }
    factory { ScheduleRepository(get()) }
}