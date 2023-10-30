package com.example.daznapp.ui

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateHelper {
    fun isoToTimestamp(isoDate: String): Long {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        return dateFormat.parse(isoDate)!!.time
    }

    fun isTomorrow(isoDate: String): Boolean {
        val shouldBeTomorrow = Calendar.getInstance().apply { timeInMillis = isoToTimestamp(isoDate) }
        val now = Calendar.getInstance()
        return (shouldBeTomorrow.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR)) == 1 &&
                shouldBeTomorrow.get(Calendar.YEAR) == now.get(Calendar.YEAR)
    }
}