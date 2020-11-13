package com.nouman.gittreadingrepo.di.activitydi

import com.nouman.gittreadingrepo.di.FragmentBuildersModule
import com.nouman.gittreadingrepo.di.viewmodeldi.ViewModelModule
import com.nouman.gittreadingrepo.ui.MainActivity
import com.nouman.gittreadingrepo.ui.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
 */
@Module
interface ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            FragmentBuildersModule::class,
            ViewModelModule::class,
        ]
    )
    fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            FragmentBuildersModule::class,
            ViewModelModule::class,
        ]
    )

    fun contributeSecondActivity(): SecondActivity


}