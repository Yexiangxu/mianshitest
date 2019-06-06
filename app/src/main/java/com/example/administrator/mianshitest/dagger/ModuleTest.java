package com.example.administrator.mianshitest.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleTest {
    @AppScope
    @Provides
    public ClassBNew providerB() {
        return new ClassBNew();
    }
    @AppScope
    @Provides
    public ClassANew providerA(ClassBNew classb) {
        return new ClassANew(classb);
    }
}
