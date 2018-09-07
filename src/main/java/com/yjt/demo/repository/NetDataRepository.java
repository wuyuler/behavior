package com.yjt.demo.repository;


import com.yjt.demo.domain.NetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface NetDataRepository extends JpaRepository<NetData,String> {

    @Query(value ="select app_name from net_data;",nativeQuery = true)
    List<String> getAllAppName();

}
