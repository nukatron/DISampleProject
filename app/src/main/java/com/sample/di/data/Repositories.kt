package com.sample.di.data

object Repositories {

    private var mRepository: IRepository? = null

    @Synchronized fun getRepoInstance(serviceApi: IServiceApi): IRepository {
        val repository = mRepository ?: RepositoryImpl(serviceApi)
        mRepository = repository
        return repository
    }
}
