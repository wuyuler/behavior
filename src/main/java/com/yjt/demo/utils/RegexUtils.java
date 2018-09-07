package com.yjt.demo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static List<String> getAppNameByRegex(String s){
        Pattern pattern = Pattern.compile("(N<=>)(.*?)(\\[=])");
        Matcher matcher = pattern.matcher(s);

        List<String>  a =new ArrayList<String>();

        while (matcher.find()) if (!matcher.group(2).equals("NULL") ) a.add(matcher.group(2).trim());
        return  a;
    }
}
