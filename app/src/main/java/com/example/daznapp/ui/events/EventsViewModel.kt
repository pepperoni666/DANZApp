package com.example.daznapp.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daznapp.data.EventsRepository
import com.example.daznapp.data.SportEvent
import com.example.daznapp.ui.DateHelper.isoToTimestamp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsRepository: EventsRepository) : ViewModel() {

    private val _events = MutableLiveData<List<SportEvent>>()
    val events: LiveData<List<SportEvent>> = _events

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val events = eventsRepository.getEvents()
                    .sortedBy { isoToTimestamp(it.date) }
                _events.postValue(events)
            } catch (e: Throwable) {
                _error.postValue("Something went wrong!")
            }
        }
    }
}