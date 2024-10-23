package com.wsu.ordermasterservice.controller;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthController {
    @GetMapping
    public ResponseEntity<String> healthCheck () {
        return new ResponseEntity<String>("System UP: Health Response from my Order Master Application", HttpStatus.OK);
    }
}