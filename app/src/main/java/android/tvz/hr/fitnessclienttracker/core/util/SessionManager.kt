package android.tvz.hr.fitnessclienttracker.core.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences

class SessionManager(val context: Context){

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(SESSION_MANAGER)

}

const val SESSION_MANAGER = "session_manager"