package com.wsu.ordermasterservice.repository;

import com.wsu.ordermasterservice.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ServerRepository extends JpaRepository<Server, Integer> {

}
