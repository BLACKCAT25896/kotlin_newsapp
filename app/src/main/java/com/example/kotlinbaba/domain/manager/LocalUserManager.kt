package com.example.kotlinbaba.domain.manager
import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppEntry()
     fun getAppEntry() : Flow<Boolean>
}