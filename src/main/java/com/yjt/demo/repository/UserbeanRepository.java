package com.yjt.demo.repository;

import com.yjt.demo.domain.Userbean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserbeanRepository extends JpaRepository<Userbean,String> {
}
