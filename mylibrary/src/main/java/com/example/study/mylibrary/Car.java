package com.example.study.mylibrary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Scope;

/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class Car   {

//    @QualifierA
    @Inject
    Engine engineA;

//    @QualifierB
    @Inject
    Engine engineB;

    public Car() {
        DaggerCarComponent.builder().markCarModule(new MarkCarModule()).build().inject(this);
    }

    public Engine getEngineA() {
        return this.engineA;
    }
    public Engine getEngineB() {
        return this.engineB;
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CarScope{

    }
}


