package com.example.study.mylibrary;

import dagger.Component;

/**
 * Created by Administrator on 2017/4/11 0011.
 */
@Car.CarScope
@Component(modules = {MarkCarModule.class})
public interface CarComponent {
    void inject(Car car);
}
