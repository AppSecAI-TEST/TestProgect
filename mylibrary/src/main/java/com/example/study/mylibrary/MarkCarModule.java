package com.example.study.mylibrary;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/4/11 0011.
 */
@Module
public class MarkCarModule {
    public MarkCarModule() {
    }

//    @QualifierA
//    @Provides
//    Engine provideEngineA(){
//        return new Engine("gearA");
//    }
//
//    @QualifierB
//    @Provides
//    Engine provideEngineB(){
//        return new Engine("gearB");
//    }

    @Provides
    @Car.CarScope
    Engine provideEngine(){
        return new Engine("gearScope");
    }
}
