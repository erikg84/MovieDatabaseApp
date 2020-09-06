package com.example.moviedatabaseapp.util

import android.content.SharedPreferences
import com.google.android.material.textfield.TextInputEditText

var TextInputEditText.value
    get() = this.text.toString()
    set(value) { this.setText(value) }

fun SharedPreferences.Editor.put(pair: Pair<String, Any>) {
    val key = pair.first
    val value = pair.second
    when(value) {
        is String -> putString(key, value).commit()
        is Int -> putInt(key, value).commit()
        is Boolean -> putBoolean(key, value).commit()
        is Long -> putLong(key, value).commit()
        is Float -> putFloat(key, value).commit()
        else -> error("Only primitiva data types can be stored in SharedPreferences")
    }
}