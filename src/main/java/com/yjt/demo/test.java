package com.yjt.demo;


import com.yjt.demo.utils.DataFIleUtils;

import java.io.IOException;
import java.util.Set;

public class test {


    public static void main(String[] args) throws IOException {
        Set<String> allAppName = DataFIleUtils.getALlAppName2();
        System.out.println(allAppName.size());
//        for (String s:allAppName
//             ) {
//            System.out.print(s+",");
//        }

       // System.out.println(DataFIleUtils.findStringThrowAllFiles("Adobe Photoshop Lightroom 3.6"));
    }
}
