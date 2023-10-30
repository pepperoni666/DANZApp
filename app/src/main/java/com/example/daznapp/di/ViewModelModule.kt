package com.example.daznapp.di

import com.example.daznapp.ui.schedule.ScheduleViewModel
import com.example.daznapp.ui.events.EventsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ScheduleViewModel(get())
    }

    viewModel {
        EventsViewModel(get())
    }
}