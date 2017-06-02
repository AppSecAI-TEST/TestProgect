package com.tianniu.custom.model;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class PhoneNumber {
    private static final long serialVersionUID = 1L;
    public boolean canDelete = true;
    public int id;
    public String tel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
