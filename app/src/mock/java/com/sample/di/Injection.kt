package com.sample.di.data

object Injection {

    fun provideRepository(): IRepository {
        return Repositories.getRepoInstance(MockServiceApiImpl())
    }
}
