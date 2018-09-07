package com.yjt.demo.repository;


import com.yjt.demo.domain.NetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<NetUser,String> {
    @Query(value ="select edu from net_user;",nativeQuery = true)
    List<String> getAllEdu();

    @Query(value ="select gender from net_user;",nativeQuery = true)
    List<String> getAllGender();

    @Query(value ="select birthday from net_user;",nativeQuery = true)
    List<String> getAllDirthday();

    @Query(value ="select job from net_user;",nativeQuery = true)
    List<String> getAllJob();

    @Query(value ="select income from net_user;",nativeQuery = true)
    List<String> getAllIncome();

    @Query(value ="select province from net_user;",nativeQuery = true)
    List<String> getAllProvince();

    @Query(value ="select is_city from net_user;",nativeQuery = true)
    List<String> getAllIsCity();

}
