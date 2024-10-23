package com.wsu.ordermasterservice.Repository;

import com.example.servers.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ServerRepository extends JpaRepository<Server, Integer> {

}
