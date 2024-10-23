package com.wsu.ordermasterservice.DTO;

import javax.validation.constraints.NotBlank;

// Data Transfer Object for Server
public class ServerDTO {

    private int serverId;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String availability;

    // Getters and setters
}