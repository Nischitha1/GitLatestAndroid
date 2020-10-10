package com.nischitha.albumlist.di.component;

import android.content.Context;


import com.nischitha.albumlist.di.module.AdapterModule;
import com.nischitha.albumlist.di.qualifier.ActivityContext;
import com.nischitha.albumlist.di.scopes.ActivityScope;
import com.nischitha.albumlist.ui.MainActivity;

import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(MainActivity mainActivity);
}
