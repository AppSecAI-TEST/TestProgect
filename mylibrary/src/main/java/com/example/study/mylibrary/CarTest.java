package com.example.study.mylibrary;

/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class CarTest {

    public static void main(String[] args){
        Car car = new Car();
        System.out.println(car.engineA.hashCode());
        System.out.println(car.engineB.hashCode());
        car =null;
        assert car !=null:"变量car为null";
        System.out.println("assert");


    }
}
