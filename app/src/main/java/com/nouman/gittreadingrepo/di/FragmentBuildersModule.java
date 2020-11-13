package com.nouman.gittreadingrepo.di;

import com.nouman.gittreadingrepo.ui.BlankFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Wellington Costa on 25/12/2017.
 */
@Module
public interface FragmentBuildersModule {

    @ContributesAndroidInjector
    BlankFragment contributeBlankFragment();

}