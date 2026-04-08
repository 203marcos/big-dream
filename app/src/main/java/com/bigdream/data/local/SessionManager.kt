package com.bigdream.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bigdream.domain.model.AuthToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val tokenKey = stringPreferencesKey("access_token")
    private val userIdKey = longPreferencesKey("user_id")

    suspend fun saveToken(token: AuthToken) {
        context.dataStore.edit { prefs ->
            prefs[tokenKey] = token.accessToken
            prefs[userIdKey] = token.userId
        }
    }

    suspend fun getToken(): AuthToken? {
        return context.dataStore.data.map { prefs ->
            val accessToken = prefs[tokenKey] ?: return@map null
            val userId = prefs[userIdKey] ?: return@map null
            AuthToken(accessToken, userId)
        }.firstOrNull()
    }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }
}
