package com.tianniu.custom.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tianniu.custom.model.HostoryLocation;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class JsonUtils {
    private JsonUtils() {
    }

    /**
     * 对象转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String listToJson(Object obj) {
        Gson gson =new GsonBuilder().excludeFieldsWithModifiers(Modifier.PUBLIC).create();
        return gson.toJson(obj);
    }

    public static List<HostoryLocation> stringToList(String str) {
        Type type = new TypeToken<List<HostoryLocation>>() {
        }.getType();

        List<HostoryLocation> fromJson = (List<HostoryLocation>) fromJson(str, type);
        return fromJson;
    }




    public static HostoryLocation getHostory(String str) {
        Type type = new TypeToken<HostoryLocation>() {
        }.getType();

        HostoryLocation fromJson = (HostoryLocation)fromJson(str, type);
        return fromJson;
    }

    /**
     * json字符串转成对象
     *
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     *
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * 保存json到sp
     */
    public static void saveJsonToSp(SharedPreferences.Editor edit, String key, String value) {
        edit.putString(key, value).commit();
    }

    /**
     * 获取sp value
     */
    public static String getJsonToSp(SharedPreferences sp, String key, String defValues) {
        return sp.getString(key, defValues);
    }





}

