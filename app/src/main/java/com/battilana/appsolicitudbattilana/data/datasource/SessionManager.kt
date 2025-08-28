package com.battilana.appsolicitudbattilana.data.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.battilana.appsolicitudbattilana.data.model.UserSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_session")

class SessionManager(private val context: Context) {

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val NAME_KEY = stringPreferencesKey("name")
        private val SUBNAME_KEY = stringPreferencesKey("subname")
        private val ID_KEY = longPreferencesKey("idUsuario")
        private val STATUS_KEY = stringPreferencesKey("status")
    }

    suspend fun saveSession(userSession: UserSession) {
        context.dataStore.edit { prefs ->
            prefs[ID_KEY] = userSession.idUsuario
            prefs[NAME_KEY] = userSession.name
            prefs[SUBNAME_KEY] = userSession.subname
            prefs[TOKEN_KEY] = userSession.token
            prefs[STATUS_KEY] = userSession.status
        }
    }

    fun getSession(): Flow<UserSession?>{
        return context.dataStore.data.map { prefs ->
            val token = prefs[TOKEN_KEY] ?: return@map null
            UserSession(
                idUsuario = prefs[ID_KEY] ?: 0L,
                name = prefs[NAME_KEY] ?: "",
                subname = prefs[SUBNAME_KEY] ?: "",
                token = token,
                status = prefs[STATUS_KEY] ?: ""
            )
        }
    }

    //Cerrar sesion (Limpiar todo)
    suspend fun clearSession() {
        context.dataStore.edit { prefs ->
            prefs.clear()
        }
    }
}