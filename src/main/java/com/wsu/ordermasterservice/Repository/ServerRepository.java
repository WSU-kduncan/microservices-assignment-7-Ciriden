package com.wsu.ordermasterservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wsu.ordermasterservice.Model.Server;

public interface ServerRepository extends JpaRepository<Server, Integer> {

}
