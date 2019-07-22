package com.example.administrator.mianshitest.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ModuleTest.class)
public interface MainComponent {
    void inject(DaggerActivity activity);
}