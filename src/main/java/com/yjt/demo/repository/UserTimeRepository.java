package com.yjt.demo.repository;

import com.yjt.demo.domain.UserTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

import java.util.List;

public interface UserTimeRepository extends JpaRepository<UserTime,Integer> {
     List<UserTime> findAllByStartDate(Date date);
}
