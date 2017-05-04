package com.tianniu.custom;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class OpApplication extends Application {

    private ExecutorService feelThreadPool;

    public OpApplication() {
        feelThreadPool = Executors.newCachedThreadPool();
    }

    public void doInFreeThread(Runnable task) {
        feelThreadPool.submit(task);
    }

    public static List<Object> windowShowList=new ArrayList<Object>(0);

    public static void addWindowShow(Object o){
        if(!windowShowList.contains(o)) {
            windowShowList.add(o);
        }

    }
    public static void removeWindowShow(Object o){


        windowShowList.remove(o);

    }
    public static boolean hasWindowShowed(){
        if(windowShowList.size()>0){
            return true;
        }
        return false;
    }
}
