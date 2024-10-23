package com.wsu.ordermasterservice.Model;

import javax.persistence.*;

// Entity class for Server
@Entity
@Table(name = "servers")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serverId;

    private String firstName;
    private String lastName;
    private String availability;

    // Getters and setters
}