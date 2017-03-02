package com.sample.di

import com.sample.di.data.IRepository
import com.sample.di.data.MockServiceApiImpl
import com.sample.di.data.Repositories

object Injection {

    fun provideRepository(): IRepository {
        return Repositories.getRepoInstance(MockServiceApiImpl())
    }
}
