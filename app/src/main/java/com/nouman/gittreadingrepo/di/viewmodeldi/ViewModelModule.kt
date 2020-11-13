package com.nouman.gittreadingrepo.di.viewmodeldi

import androidx.lifecycle.ViewModel
import com.nouman.gittreadingrepo.viewmodel.MainViewModel
import com.nouman.gittreadingrepo.viewmodel.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by nomanghaffar on 12/11/2020
 */
@Module
interface ViewModelModule{
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel
}