package com.example.kotlinbaba.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.kotlinbaba.domain.manager.LocalUserManager
import com.example.kotlinbaba.utill.AppConstants
import com.example.kotlinbaba.utill.AppConstants.userSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.internal.userAgent

class LocalUserManagerImp(private val context: Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings->
            settings[PreferencesKeys.isAppEntry] = true
        }
    }

    override fun getAppEntry(): Flow<Boolean> {
        return  context.dataStore.data.map { pref ->
            pref[PreferencesKeys.isAppEntry]?: false
        }
    }
}

private  val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = userSettings)

private  object PreferencesKeys{
    val isAppEntry = booleanPreferencesKey(name = AppConstants.isAppEntry)
}