package com.example.study.mylibrary;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class Engine {

    private String gear;

    public Engine(String gear) {
        this.gear=gear;
    }

    public void run(){
        System.out.println("NAME"+gear+"  engine start");
    }
}
