package com.example.study.mylibrary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Administrator on 2017/4/11 0011.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface QualifierB {
}
