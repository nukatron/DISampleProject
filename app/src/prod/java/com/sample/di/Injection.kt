package com.sample.di

import com.sample.di.data.IRepository
import com.sample.di.data.Repositories
import com.sample.di.data.ServiceApiImpl

object Injection {

    fun provideRepository(): IRepository {
        return Repositories.getRepoInstance(ServiceApiImpl())
    }
}
