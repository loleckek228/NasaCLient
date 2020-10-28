package com.example.nasaclient.utils

fun convertUrl(date: String?, image: String?): String {
    //https://epic.gsfc.nasa.gov/archive/natural/2020/10/27/png/epic_1b_20201027041236.png
    val formatDate = formatDate(date!!)
    val url = String.format(
        "https://epic.gsfc.nasa.gov/archive/natural/%s/png/%s.png",
        formatDate,
        image,
    )

    return url
}
