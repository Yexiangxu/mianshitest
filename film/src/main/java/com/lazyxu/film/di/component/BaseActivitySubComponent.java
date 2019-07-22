package com.lazyxu.film.di.component;

import com.lazyxu.film.HotFilmActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseActivitySubComponent extends AndroidInjector<HotFilmActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HotFilmActivity> {
    }

}
