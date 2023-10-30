package com.example.daznapp.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daznapp.data.ScheduleRepository
import com.example.daznapp.data.SportEvent
import com.example.daznapp.ui.DateHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleViewModel(private val scheduleRepository: ScheduleRepository) : ViewModel() {

    private val _events = MutableLiveData<List<SportEvent>>()
    val events: LiveData<List<SportEvent>> = _events

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        viewModelScope.launch {
            while(isActive) {
                withContext(Dispatchers.IO) {
                    try {
                        val events = scheduleRepository.getSchedule()
                            .filter { DateHelper.isTomorrow(it.date) }
                            .sortedBy { DateHelper.isoToTimestamp(it.date) }
                        _events.postValue(events)
                    } catch (e: Throwable) {
                        _error.postValue("Something went wrong!")
                    }
                }
                delay(30 * 1000)
            }
        }
    }
}