package com.yjt.demo.repository;

import com.yjt.demo.domain.Kmeans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KmeansRepository extends JpaRepository<Kmeans,String> {

}
