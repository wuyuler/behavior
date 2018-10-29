package com.yjt.demo.repository;

import com.yjt.demo.domain.Appcount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppcountRepository extends JpaRepository<Appcount,Integer> {
    List<Appcount> findAllByUseridOrderByCountDesc(String userid);
    List<Appcount> findAllByAppname(String appname);
}
