package com.yjt.demo.utils;

import java.io.*;
import java.util.*;


public class DataFIleUtils {
    public static String basePath = "C:\\Users\\Administrator\\Desktop\\data\\behavior";

    /**
     * 获取统计的所有日期
     * @return
     */
    public static String[] getAllTime() {
        //获取所有检查的日期
        File file1=new File(basePath);
        try {
            return listDirectory(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    static public List<String> getALlAppName(){
        final HashMap<String, HashMap<String, String>> allFilePath = DataFIleUtils.getAllFilePath();
        List<String> allAppName = new ArrayList<String>();
        for (HashMap<String, String> v1:allFilePath.values()
        ) {
            for (String s:v1.values()
            ) {
                List<String> appNameByRegex = RegexUtils.getAppNameByRegex(s);
                for (String appName:appNameByRegex
                     ) {
                    allAppName.add(appName);
                }
            }

        }
    return allAppName;
    }

    /**
     * 遍历所有txt文件,获取app的名字
     * @return
     */
    static public Set<String> getALlAppName2(){
        File file1=new File(basePath);
        File[] timeFiles = file1.listFiles();
        Set<String> allAppName = new HashSet<>();
        for(File f:timeFiles){
            File[] dataFiles = f.listFiles();//日期是固定的,可以考虑获取后重复使用
            for(File f_data:dataFiles){
                String s =readTxtToString(f_data);
                List<String> appNameByRegex = RegexUtils.getAppNameByRegex(s);
                for (String appName:appNameByRegex
                ) {
                    allAppName.add(appName);
                }
            }

        }
        return  allAppName;
    }
    public static HashMap<String, HashMap<String,String>> getAllFilePath(){
       File file1=new File(basePath);
       HashMap<String, HashMap<String,String>> allData = new HashMap<String, HashMap<String, String>>();
       File[] timeFiles = file1.listFiles();
       for(File f:timeFiles){
           File[] dataFiles = f.listFiles();
           HashMap<String,String> onePersonData = new HashMap<String, String>();
           for(File f_data:dataFiles){
                String s =readTxtToString(f_data);
               onePersonData.put(f_data.getName().substring(0,32),s);
           }
           allData.put(f.getName(),onePersonData);
       }
    return allData;
   }

    /**
     * 将读取的txt文件转化为string
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readTxtToString (String filePath) throws IOException {
        File file2 =new File(filePath);
        if(file2.exists()){
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file2));
            BufferedReader bufferedReader =new BufferedReader(reader);
            StringBuilder builder=new StringBuilder();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                builder.append(System.getProperty("line.separator")+line);
            }
            reader.close();
            bufferedReader.close();
            String s =String.valueOf(builder);
            return s;
        }

        return "文件地址不存在";

    }

    /**
     * 找到一段文字所属的文件
     * @param
     * @return
     */
    public static String findStringThrowAllFiles(String t_s){
        File file1=new File(basePath);

        File[] timeFiles = file1.listFiles();
        for(File f:timeFiles){
            File[] dataFiles = f.listFiles();
            for(File f_data:dataFiles){
                String s =readTxtToString(f_data);
                if(s.contains(t_s))return f_data.getAbsolutePath();

            }

        }
        return null;

    }

    /**
     * 传入文件对象将数据读取出来
     * @param file
     * @return
     */
    public static String readTxtToString (File file) {

        InputStreamReader reader = null;
        BufferedReader bufferedReader =null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            bufferedReader =new BufferedReader(reader);
            StringBuilder builder=new StringBuilder();
            String line;
            while ((line=bufferedReader.readLine())!=null){
                builder.append(line);
            }
            reader.close();
            bufferedReader.close();
            return String.valueOf(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String[] listDirectory(File dir) throws IOException {
        if(!dir.exists()){
            throw new IllegalArgumentException("目录:"+dir+"不存在");
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }
        String[] fileNames=dir.list();

        return fileNames;
    }

}

