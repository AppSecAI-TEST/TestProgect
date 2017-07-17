package com.tianniu.vehiclemaster;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Administrator on 2017/6/30 0030.
 */

public class TestClass {

    public  static void main(String arg[]){
        String 徐水自治区 = StringFilter("徐水自治区州旗");
        System.out.println(徐水自治区);
    }

    public   static   String StringFilter(String   str)   throws PatternSyntaxException {
        String regEx="[区县市自治区州旗]";
        Pattern pattern   =   Pattern.compile(regEx);
        Matcher matcher   =   pattern.matcher(str);
        return   matcher.replaceAll("").trim();
    }
}
