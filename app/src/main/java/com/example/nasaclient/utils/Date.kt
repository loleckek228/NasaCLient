package com.example.nasaclient.utils

import java.text.SimpleDateFormat
import java.util.*

private fun getYesterday(): Date {
    val calendar = GregorianCalendar.getInstance()

    calendar.add(Calendar.DATE, -1);

    return calendar.time
}

fun getYestardayDateString(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")

    return dateFormat.format(getYesterday())
}

fun formatDate(date: String): String {
    val dateSplit = date.split(" ")

    return dateSplit[0].replace("-", "/")
}