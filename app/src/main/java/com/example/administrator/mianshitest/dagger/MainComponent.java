package com.example.administrator.mianshitest.dagger;

import dagger.Component;

@AppScope
@Component(modules = ModuleTest.class)
public interface MainComponent {
    //这里inject表示注入的意思(这个方法名可以随意更改，建议用inject)
    void inject(DaggerActivity activity);
}