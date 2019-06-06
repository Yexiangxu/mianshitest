package com.example.administrator.mianshitest.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by codeest on 16/8/7.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface AppScope { }


