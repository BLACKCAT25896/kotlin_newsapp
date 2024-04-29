package com.example.kotlinbaba.domain.useCases

import com.example.kotlinbaba.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.getAppEntry()
    }
}