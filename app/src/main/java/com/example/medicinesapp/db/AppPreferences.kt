package com.example.medicinesapp.db

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val NAME = "SpinKotlin"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    private val IS_FIRST_RUN_PREF = Pair("is_first_run", false)
    private val WM_COUNTER = Pair("counter",0)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var firstRun: Boolean
        get() = preferences.getBoolean(
            IS_FIRST_RUN_PREF.first, IS_FIRST_RUN_PREF.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_FIRST_RUN_PREF.first, value)
        }

    var counter: Int
        get() = preferences.getInt(
            WM_COUNTER.first, WM_COUNTER.second)
        set(value) = preferences.edit {
            it.putInt(WM_COUNTER.first, value)
        }
}