package com.wsu.ordermasterservice.controller;

import com.wsu.ordermasterservice.DTO;
import com.wsu.ordermasterservice.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller for handling Server-related requests
@RestController
@RequestMapping("/api/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    // GET: Retrieve all servers
    @GetMapping
    public ResponseEntity<List<ServerDTO>> getAllServers() {
        return ResponseEntity.ok(serverService.getAllServers());
    }

    // GET: Retrieve a server by ID
    @GetMapping("/{id}")
    public ResponseEntity<ServerDTO> getServerById(@PathVariable int id) {
        return ResponseEntity.ok(serverService.getServerById(id));
    }

    // POST: Create a new server
    @PostMapping
    public ResponseEntity<ServerDTO> createServer(@RequestBody ServerDTO serverDTO) {
        return ResponseEntity.ok(serverService.createServer(serverDTO));
    }

    // PUT: Update an existing server
    @PutMapping("/{id}")
    public ResponseEntity<ServerDTO> updateServer(@PathVariable int id, @RequestBody ServerDTO serverDTO) {
        return ResponseEntity.ok(serverService.updateServer(id, serverDTO));
    }

    // DELETE: Delete a server by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable int id) {
        serverService.deleteServer(id);
        return ResponseEntity.noContent().build();
    }
}