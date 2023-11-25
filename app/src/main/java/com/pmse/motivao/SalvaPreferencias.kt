package com.pmse.motivao

import android.content.Context
import android.content.SharedPreferences

class SalvaPreferencias(context: Context) {

    private val seguranca: SharedPreferences =
        context.getSharedPreferences("motivacao", Context.MODE_PRIVATE)

    fun storeNome(key: String, name: String){
        seguranca.edit().putString(key, name).apply()
    }

    fun recuperaNome(key: String): String {
        return seguranca.getString(key, "")  ?: ""
    }

    fun limpaNome(key: String){
        seguranca.edit().putString(key, "").apply()
    }
}