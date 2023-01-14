package vk.cup.dzen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vk.cup.dzen.data.DataRepositoryImpl
import vk.cup.dzen.domain.DataRepository

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class HiltModule {

    @Binds
    abstract fun bindDataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepository
}
