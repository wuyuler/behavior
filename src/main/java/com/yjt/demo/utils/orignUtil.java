package com.yjt.demo.utils;



import com.yjt.demo.domain.orign;
import com.yjt.demo.repository.orignRepository;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class orignUtil {
    public static int n=1;
    public com.yjt.demo.repository.orignRepository orignRepository;
    public static List<String> readTxttoString(File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            List<String> list=new ArrayList<>();
            br.readLine();
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String getMatchTime(String s) {
        Pattern p = Pattern.compile("(T<=>)(.*?)(\\[=])");
        Matcher m = p.matcher(s);
        String a=null;
        while (m.find())
            a=m.group(2).trim();
        return a;
    }
    private static String getMatchTime1(String s) {
        Pattern p = Pattern.compile("(P<=>)(.*?)(\\[=])");
        Matcher m = p.matcher(s);
        String a=null;
        while (m.find())
            a=m.group(2).trim();
        return  a;
    }
    private static String getMatchTime2(String s) {//匹配url
        Pattern p = Pattern.compile("(U<=>)(.*?)(\\[=])");
        Matcher m = p.matcher(s);
        String a=null;
        while (m.find())
            a=m.group(2).trim();
        return  a;
    }

    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
    public static java.sql.Time strToTime(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Time time = new java.sql.Time(d.getTime());
        return time;
    }
    public static List<orign> alldata()//读取所有数据
    {
        int num = 1;
        String basePath = DataFIleUtils.basePath;
        File file1 = new File(basePath);
        List<orign> O = new ArrayList<>();
        File[] timeFiles = file1.listFiles();
        for (File f : timeFiles) {
            File[] dataFiles = f.listFiles();
            for (File f_data : dataFiles) {
                List<String> list = readTxttoString(f_data);
                String a = f_data.getName().substring(0, 32);
                String b = f_data.getName().substring(33, 43);
                String c = f_data.getName().substring(44, 52);
                java.sql.Date b1 = strToDate(b);
                java.sql.Time c1 = strToTime(c);
                for (String ss : list) {
                    System.out.println(num);
                    String s1 = getMatchTime(ss);
                    String s2 = getMatchTime1(ss);
                    String s3 = getMatchTime2(ss);
                    if (s1 == null)
                        continue;
                    orign o = new orign();
                    //o.setId(num++);
                    o.setDate(b1);
                    o.setStarttime(c1);
                    o.setUserid(a);
                    o.setTime(Integer.parseInt(s1));
                    o.setProgress(s2);
                    o.setUrl(s3);
                    O.add(o);
                }
            }
        }
        return O;
    }


}

