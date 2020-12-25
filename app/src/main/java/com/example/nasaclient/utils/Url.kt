package com.example.nasaclient.utils

fun convertUrl(date: String?, image: String?): String {
    val formatDate = formatDate(date!!)

    val url = String.format(
        "https://epic.gsfc.nasa.gov/archive/natural/%s/png/%s.png",
        formatDate,
        image,
    )

    return url
}
