package com.yjt.demo.utils;

import com.yjt.demo.domain.XYbean;

import java.util.List;
import java.util.UUID;

public class XYCluster  extends KMeansClustering<XYbean>{
    @Override
    public double similarScore(XYbean o1, XYbean o2) {
        double distance = Math.sqrt((o1.getX() - o2.getX()) * (o1.getX() - o2.getX()) + (o1.getY() - o2.getY()) * (o1.getY() - o2.getY()));
        return distance * -1;

    }

    @Override
    public boolean equals(XYbean o1, XYbean o2) {
        return o1.getX() == o2.getX() && o1.getY() == o2.getY();

    }


    @Override
    public XYbean getCenterT(List<XYbean> list) {
        int x = 0;
        int y = 0;
        try {
            for (XYbean xy : list) {
                x += xy.getX();
                y += xy.getY();
            }
            x = x / list.size();
            y = y / list.size();
        } catch(Exception e) {

        }
        return new XYbean(x, y);
    }

    public static void main(String[] args) {

        int width = 600;
        int height = 400;
        int K = 34;
        XYCluster xyCluster = new XYCluster();
        for (int i = 0; i < 200000; i++) {
            String id = UUID.randomUUID().toString().substring(24);
            int x = (int)(Math.random() * width) + 1;
            int y = (int)(Math.random() * height) + 1;
            xyCluster.addRecord(new XYbean(id,x, y));
        }
        xyCluster.setK(K);
        long a = System.currentTimeMillis();
        List<List<XYbean>> cresult = xyCluster.clustering();
        List<XYbean> center = xyCluster.getClusteringCenterT();
        for(int i=0;i<cresult.get(0).size();i++){
            System.out.println("id"+cresult.get(0).get(i).getId()+"x:"+cresult.get(0).get(i).getX()+"y:"+cresult.get(0).get(i).getY());
        }
        //System.out.println(JsonUtil.parseJson(center));
        long b = System.currentTimeMillis();
        System.out.println("耗时：" + (b - a) + "ms");
        //new ImgUtil().drawXYbeans(width, height, cresult, "d:/2.png", 0, 0);
    }
}
