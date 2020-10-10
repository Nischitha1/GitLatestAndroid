package com.nischitha.albumlist.di.module;


import com.nischitha.albumlist.adapter.RecyclerViewAdapter;
import com.nischitha.albumlist.di.scopes.ActivityScope;
import com.nischitha.albumlist.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getAlbumnList() {
        return new RecyclerViewAdapter();
    }
}
