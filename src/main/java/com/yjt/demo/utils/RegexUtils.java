package com.yjt.demo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static List<String> getAppNameByRegex(String s) {
        Pattern pattern = Pattern.compile("(N<=>)(.*?)(\\[=])");
        Matcher matcher = pattern.matcher(s);
        List<String> a = new ArrayList<String>();
        while (matcher.find()) if (!matcher.group(2).equals("NULL")) a.add(matcher.group(2).trim());
        return a;
    }


    public static List<String> getAllDataOneLine(String line) {
        Pattern pattern = Pattern.compile("T<=>([0-9]+)\\[=]P<=>(.*?)\\[=]");//获取T和P时间增量
        Pattern pattern2 = Pattern.compile("U<=>(.*?)\\[=]");//获取url
//        Pattern pattern3 = Pattern.compile("N<=>(.*?)\\[=]");
        Matcher matcher = pattern.matcher(line);
        Matcher matcher2 = pattern2.matcher(line);
//        Matcher matcher3 = pattern3.matcher(line);
        List<String> a = new ArrayList<String>();//分别为T,P,U,N

        if (matcher.find()) {
            a.add(matcher.group(1).trim());
            a.add(matcher.group(2).trim());
        }else {
            a.add("NULL");
            a.add("NULL");
        }
        if (matcher2.find()) {
            a.add(matcher2.group(1).trim());
        } else a.add("NULL");

//        if (matcher3.find()) {
//            a.add(matcher3.group(1).trim());
//        } else a.add("NULL");

        return a;

    }

    public static List<String> getPrecessName(String line){//查找一行中P以及对应的N的内容
        Pattern pattern = Pattern.compile("P<=>(.*?)\\[=].*?N<=>(.*?)\\[=]");
        Matcher matcher = pattern.matcher(line);
        List<String> a = new ArrayList<String>();
        if (matcher.find()) {
            a.add(matcher.group(1).trim());
            a.add(matcher.group(2).trim());
        }else {
            a.add("NULL");
            a.add("NULL");
        }
        return a;
    }

    public static void main(String[] args) {
        getAllDataOneLine("T<=>8933[=]P<=>360chrome.exe[=]I<=>1224[=]U<=>item.taobao.com/item.htm[=]A<=>205e0[=]B<=>203b2[=]V<=>5.3.0.922");
        getAllDataOneLine("T<=>8986[=]P<=>iSeeQView.exe[=]I<=>8436[=]W<=>20d36[=]V<=>1.2[=]N<=>看图精灵[=]C<=>北京远图科技");
    }
}
