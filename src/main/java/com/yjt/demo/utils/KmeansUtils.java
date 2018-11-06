package com.yjt.demo.utils;

public class KmeansUtils {
    public static int getJob(String job){
        switch (job){
            case "党政机关事业单位工作者":return 50;
            case "党政机关事业单位一般职员":return 50;
            case "专业技术人员":return 50;
            case "党政机关事业单位领导干部":return 50;
            case "企业/公司管理者":return 50;


            case "无业、下岗、失业":return 80;
            case "退休":return 80;


            case "农民":return 20;
            case "产业、服务业工人":return 20;
            case "农村外出务工人员":return 20;

            case "个体户/自由职业者":return 150;
            case "学生":return 150;
            case "企业/公司一般职员":return 150;

            case "其他":return 70;




            default: return 0;
        }

    }
    public static int getIncome(String income){
        switch (income){
            case "501～1000元":return 8;
            case "12000元以上":return 120;
            case "1001～1500元":return 13;
            case "3001～5000元":return 40;
            case "8001～12000元":return 100;
            case "500元及以下":return 5;
            case "无收入":return 0;
            case "1501～2000元":return 18;
            case "5001～8000元":return 65;
            case "2001～3000元":return 25;
            default:return 0;
        }

    }
    public static int getEdu(String edu){
        switch (edu){
            case "大专":return 350;
            case "初中":return 200;
            case "高中/中专/技校":return 300;
            case "大学本科":return 500;
            case "小学及以下":return 50;
            case "硕士及以上":return 550;
            default:return 0;
        }
    }

}
