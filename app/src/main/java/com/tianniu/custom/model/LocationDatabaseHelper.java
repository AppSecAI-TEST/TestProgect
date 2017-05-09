package com.tianniu.custom.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class LocationDatabaseHelper extends OrmLiteSqliteOpenHelper {

    //    private static String filePath = "data/data/com.tianniu.up.testprogect/locationdb";
    private static String filePath ;
    public static final String DATABASE_NAME = "locationdb";
    private static final int DATABASE_VERSION = 1;
    private Context mContext;

    private final static int LOCATIONDATABASESVERSION = 2;

    public LocationDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        filePath = "data/data/" + mContext.getPackageName() + "/locationdb";
    }


    public void loadInitLocationDatabases(Context context) {
        SharedPreferences sp = context.getSharedPreferences(CommonDefine.LOCATION_DATABASES_VERSION, Context.MODE_PRIVATE);
        int version = sp.getInt(CommonDefine.LOCATION_DATABASES_VERSION, 0);
        File dbPath = new File(filePath);
        if (LOCATIONDATABASESVERSION != version || !dbPath.exists()) {
            InputStream input = null;
            try {
                input = context.getAssets().open(DATABASE_NAME);
                FileOutputStream fos = new FileOutputStream(dbPath);
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = input.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }

                //最后关闭就可以了
                fos.flush();
                fos.close();
                SharedPreferences.Editor ed = sp.edit();
                ed.putInt(CommonDefine.LOCATION_DATABASES_VERSION, LOCATIONDATABASESVERSION);
                ed.commit();
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    /**
     * 表名
     */
    private String province = "province";
    private String city = "city";
    private String area = "county";


    public List<LocationInfo> getAreaListFromDB(String key) {


        return getList(area, key);
    }

    public List<LocationInfo> getCityListFromDB(String key) {

        return getList(city, key);
    }


    public List<LocationInfo> getProvinceListFromDB() {

        return getList(province, null);
    }

    private List<LocationInfo> getList(String table, String key) {
        SQLiteDatabase databases = SQLiteDatabase.openOrCreateDatabase(filePath, null);
        List<LocationInfo> list = new ArrayList<LocationInfo>();
        if (databases != null) {
            String sql = "select * from " + table + " where key=?";
            String params[] = new String[]{key};
            if (key == null) {
                sql = "select * from " + table;
                params = null;
            }

            Cursor cursor = null;

            try {
                cursor = databases.rawQuery(sql, params);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    LocationInfo location = obtainLocationInfo(cursor);
                    list.add(location);
                    cursor.moveToNext();
                }
            } catch (Exception e) {

                e.printStackTrace();
            } finally {
                if (cursor != null) {
                    try {
                        cursor.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (databases != null) {
                    try {
                        databases.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }

    private LocationInfo obtainLocationInfo(Cursor cursor) {
        LocationInfo locationInfo = new LocationInfo();
        String name = cursor.getString(cursor.getColumnIndex("mName"));

        String mRF = cursor.getString(cursor.getColumnIndex("mRF"));
        String shortname = cursor.getString(cursor.getColumnIndex("shortname"));
        float mPx = cursor.getFloat(cursor.getColumnIndex("mPx"));
        float mPy = cursor.getFloat(cursor.getColumnIndex("mPy"));
        float mLongitude = cursor.getFloat(cursor.getColumnIndex("mLongitude"));
        float mLatidude = cursor.getFloat(cursor.getColumnIndex("mLatidude"));

        locationInfo.setmName(name);
        locationInfo.setmRF(mRF);
        locationInfo.setPx(mPx);
        locationInfo.setPy(mPy);
        locationInfo.setmLatidude(mLatidude);
        locationInfo.setmLongitude(mLongitude);
        return locationInfo;
    }
}
