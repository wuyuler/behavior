package com.yjt.demo.controller;

import com.yjt.demo.domain.Kmeans;
import com.yjt.demo.domain.NetUser;
import com.yjt.demo.repository.KmeansRepository;
import com.yjt.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class KmeansController {

    @Autowired
    KmeansRepository kmeansRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "kmeans/getfri")
    public ArrayList<NetUser> getfri(@RequestParam( "userid") String userid){
        ArrayList<NetUser> res=new ArrayList<>();
        Kmeans user=kmeansRepository.findById(userid).orElse(null);

        if(user!=null){
            List<Kmeans> kmeansArrayList = kmeansRepository.findAll();
            //Collections.shuffle(kmeansArrayList);
            ArrayList<String> userids=new ArrayList<>();
            for(Kmeans k:kmeansArrayList){
                if(user.getUserinfo().equals(k.getUserinfo())&&(user.getTimeinfo().equals(k.getTimeinfo()))&&(user.getNetinfo().equals(k.getNetinfo()))){
                    userids.add(k.getUserid());
                    if(userids.size()==5)break;
                }
            }
         for(Kmeans k:kmeansArrayList)
                if(user.getUserinfo().equals(k.getUserinfo())&&(user.getTimeinfo().equals(k.getTimeinfo()))&&(!user.getNetinfo().equals(k.getNetinfo()))){
                    if(userids.size()==5)break;
                    userids.add(k.getUserid());
                }
        for(Kmeans k:kmeansArrayList)
                if(user.getUserinfo().equals(k.getUserinfo())&&(!user.getTimeinfo().equals(k.getTimeinfo()))&&(user.getNetinfo().equals(k.getNetinfo()))){
                    if(userids.size()==5)break;
                    userids.add(k.getUserid());
                }
        for(Kmeans k:kmeansArrayList)
                if(!user.getUserinfo().equals(k.getUserinfo())&&(user.getTimeinfo().equals(k.getTimeinfo()))&&(!user.getNetinfo().equals(k.getNetinfo()))){
                    if(userids.size()==5)break;
                    userids.add(k.getUserid());
                }
        for(Kmeans k:kmeansArrayList)
        if(user.getUserinfo().equals(k.getUserinfo())&&(!user.getTimeinfo().equals(k.getTimeinfo()))&&(!user.getNetinfo().equals(k.getNetinfo()))){
            if(userids.size()==5)break;
            userids.add(k.getUserid());
        }
        for(String id :userids)
            res.add(userRepository.findById(id).orElse(null));
        }

       return res;
    }

}
