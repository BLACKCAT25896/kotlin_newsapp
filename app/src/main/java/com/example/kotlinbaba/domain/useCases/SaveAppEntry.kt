package com.example.kotlinbaba.domain.useCases

import com.example.kotlinbaba.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }

}