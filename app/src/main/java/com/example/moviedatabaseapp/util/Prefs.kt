package com.example.moviedatabaseapp.util

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {

    companion object {
        const val STRING = "string"
        const val INTEGER = "integer"
        const val FLOAT = "float"
        const val BOOLEAN = "boolean"
        const val PREFS_FILENAME = "com.example.moviedatabaseapp.util.prefsmanager"
    }

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var string: String?
        get() = prefs.getString(STRING, "")
        set(value) = prefs.edit().put(STRING to value.toString())

    var integer: Int
        get() = prefs.getInt(INTEGER, 0)
        set(value) = prefs.edit().put(INTEGER to value)

    var float: Float
        get() = prefs.getFloat(FLOAT, 0F)
        set(value) = prefs.edit().put(FLOAT to value)

    var boolean: Boolean
        get() = prefs.getBoolean(BOOLEAN, false)
        set(value) = prefs.edit().put(STRING to value)

}