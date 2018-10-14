package com.yjt.demo.service;

import com.yjt.demo.domain.NetUser;
import com.yjt.demo.domain.Time_add;
import com.yjt.demo.domain.Time_start;
import com.yjt.demo.repository.TimeAddRepository;
import com.yjt.demo.repository.TimeStartRepository;
import com.yjt.demo.repository.UserRepository;
import com.yjt.demo.utils.DataFIleUtils;
import com.yjt.demo.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.*;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TimeStartRepository timeStartRepository;
    @Autowired
    TimeAddRepository timeAddRepository;

    @PersistenceContext
    protected EntityManager em;

    @Transactional
    public void batchInsert(List list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                em.persist(list.get(i));
            }

            em.flush();
            em.clear();
            System.out.println("save to DB success,list is {}"+list.toString());
        } catch (Exception e) {
            System.out.println("batch insert data failuer.");
            e.printStackTrace();
        }
    }




    //获取一列中所有数据
    public List<String> getOneColumn(String colName){

        List<String> list=new ArrayList<>();

        switch (colName){
            case "gender":list = userRepository.getAllGender();break;
            case "birthday":list=userRepository.getAllDirthday();break;
            case "edu":list=userRepository.getAllEdu();break;
            case "job":list=userRepository.getAllJob();break;
            case "income":list=userRepository.getAllIncome();break;
            case "province":list=userRepository.getAllProvince();break;
            case "is_city":list=userRepository.getAllIsCity();break;
        }

        return list;
    }

    //按行读取所有数据,并插入数据库
    public void insertAllData(){
        String basePath = "C:\\Users\\Administrator\\Desktop\\data\\behavior";
        File file1=new File(basePath);
        File[] timeFiles = file1.listFiles();
        List<NetUser> netUsers=userRepository.findAll();//获取所有人的信息


        for(File f:timeFiles){//遍历所有日期
            //将插入开始时间和插入时间增量表分开,先插入开始时间
            //不能分开插入,因为第二次必须要先找到对应的time_start才能确保插入成功
            List<Time_add> time_adds=new ArrayList<>();


            List<Time_start> time_starts=new ArrayList<>();//每读完一个日期文件就提交一次
            File[] dataFiles = f.listFiles();//日期是固定的,可以考虑获取后重复使用
            int count=0;

            for(File f_data:dataFiles){//遍历某个日期所有用户的数据
                count++;

                System.out.println(count);
                //获取该用户对象

                int index_user=-1;
                for(int i=0;i<netUsers.size();i++)
                    if(netUsers.get(i).getId().equals(f_data.getName().substring(0,32))){
                        index_user=i;
                        break;
                    }
                //通过文件名获取一个time_start对象
                Time_start time_start = new Time_start();
                time_start.setUser(netUsers.get(index_user));
                time_start.setTime_start(f_data.getName().substring(33,52));
                time_starts.add(time_start);
                //从一个txt文件的每一条中获取一个time_add对象
                InputStreamReader reader = null;
                BufferedReader bufferedReader =null;
                try {
                    reader = new InputStreamReader(new FileInputStream(f_data));
                    bufferedReader =new BufferedReader(reader);
                    String line;
                    //跳过前两行
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    while ((line=bufferedReader.readLine())!=null){
                        List<String> list_line=RegexUtils.getAllDataOneLine(line);
                        Time_add time_add=new Time_add();
                        time_add.setTime_start(time_start);
                        time_add.setTime_add(list_line.get(0));
                        time_add.setProcess_name(list_line.get(1));
                        time_add.setUrl(list_line.get(2));
                        //time_add.setApp_name(list_line.get(3));
                        time_adds.add(time_add);
                    }
                    reader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            timeStartRepository.saveAll(time_starts);
            List<Time_add> list_time_add_bach=new ArrayList<>();
            int count2=0;
            for(Time_add td:time_adds){
                if (list_time_add_bach.size()==10000){
                    timeAddRepository.saveAll(list_time_add_bach);
                    list_time_add_bach.clear();
                    count++;
                    System.out.println(count2);
                }
                list_time_add_bach.add(td);
            }
            if(!list_time_add_bach.isEmpty()){
                timeAddRepository.saveAll(list_time_add_bach);
            }

            }

    }


    //获取一列中所有属性名(不重复)
    public Set<String> getOneColumnProperty(String colName){

        Set<String> set = new HashSet<>();
        List<String> list=getOneColumn(colName);
        for (String s:list
             ) {
            set.add(s);
        }
        return set;
    }

    //获取一列中某种属性的个数
    public Integer getNumOfProperty(String colName,String ProName){
        List<String> list = getOneColumn(colName);
        Integer sum = 0;
        for (String s:list
             ) {
            if (s.equals(ProName))sum++;
        }
        return sum;
    }

    public List<Map> getResult(String colName){
        List<Map> list=new ArrayList<>();
        //Set<String> property = getOneColumnProperty(colName);
        List<String> list1=getOneColumn(colName);
        Map<String,Integer> map=new HashMap<>();
        for (String s:list1
             ) {
            if(map.get(s)!=null)
            map.put(s,map.get(s)+1);
            else map.put(s,0);
        }
        for (String s:map.keySet()
             ) {
            Map map1=new HashMap();
            map1.put("name",s);
            map1.put("value",map.get(s));
            list.add(map1);
        }
    return list;

    }

}
