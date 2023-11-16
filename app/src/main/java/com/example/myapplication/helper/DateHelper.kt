package com.example.myapplication.helper

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DateHelper {

    companion object{

       private val DATE_PATTTERN = "MM/DD/yyyy HH:MM:SS a"

        fun isOpenDateGreaterThanCurrentDateTime(openDateTime: String): Boolean {
            val dateTimeFormat = SimpleDateFormat(DATE_PATTTERN,Locale.getDefault())
            val currentDateTime = Calendar.getInstance().time

            // Parse the open date and time string to a Date object
            val openDateTimeObject: Date = try {
                dateTimeFormat.parse(openDateTime) ?: return false
            } catch (e: Exception) {
                return false
            }

            // Check if the open date and time is greater than the current date and time
            return openDateTimeObject.after(currentDateTime)
        }
        fun isOpenDateTomorrow(openDateTime: String): Boolean {
            val dateTimeFormat = SimpleDateFormat(DATE_PATTTERN,Locale.getDefault())
            val currentDateTime = Calendar.getInstance().time

            // Parse the open date and time string to a Date object
            val openDateTimeObject: Date = try {
                dateTimeFormat.parse(openDateTime) ?: return false
            } catch (e: Exception) {
                return false
            }

            // Calculate tomorrow's date and time
            val tomorrow = Calendar.getInstance()
            tomorrow.add(Calendar.DAY_OF_YEAR, 1)
            val tomorrowDateTime = tomorrow.time

            // Check if the open date and time is tomorrow
            return openDateTimeObject.after(currentDateTime) &&
                    openDateTimeObject.before(tomorrowDateTime)
        }

}}