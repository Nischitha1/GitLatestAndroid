package com.nischitha.albumlist.di.component;

import android.content.Context;

import com.nischitha.albumlist.MyApplication;
import com.nischitha.albumlist.di.module.ContextModule;
import com.nischitha.albumlist.di.module.RetrofitModule;
import com.nischitha.albumlist.di.qualifier.ApplicationContext;
import com.nischitha.albumlist.di.scopes.ApplicationScope;
import com.nischitha.albumlist.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);
}
