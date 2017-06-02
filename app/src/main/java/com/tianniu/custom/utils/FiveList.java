package com.tianniu.custom.utils;

import com.tianniu.custom.model.HostoryLocation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class FiveList {
    private List<HostoryLocation> list = new ArrayList<HostoryLocation>();


    public void add(HostoryLocation key) {
        Iterator<HostoryLocation> it = list.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            HostoryLocation k = it.next();
            if ((k.getmStartLocationName()+k.getmDestLocationName()).equals((key.getmStartLocationName()+key.getmDestLocationName()))) {
                it.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            list.add(0, key);
        } else {
            if (list.size() >= 5) {
                list.remove(4);

            }
            list.add(0, key);
        }
    }



    public List<HostoryLocation> getList() {
        return list;
    }

    public void setList(List<HostoryLocation> list) {
        this.list = list;
    }

    public void removeAll() {
        list.clear();
    }

    public void addAll(List<HostoryLocation> hostory) {
        list.clear();
        list.addAll(hostory);
    }

}

