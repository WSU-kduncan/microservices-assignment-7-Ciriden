package com.wsu.ordermasterservice.controller;

import com.wsu.ordermasterservice.dto.ServerDTO;
import com.wsu.ordermasterservice.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
@RequiredArgsConstructor
public class ServerController {

    private ServerService serverService;

    @GetMapping
    public ResponseEntity<List<ServerDTO>> getAllServers() {
        return ResponseEntity.ok(serverService.getAllServers());
    }

    @GetMapping("/{serverId}")
    public ResponseEntity<ServerDTO> getServerById(@PathVariable Integer serverId) {
        return ResponseEntity.ok(serverService.getServerById(serverId));
    }

    @PostMapping
    public ResponseEntity<ServerDTO> createServer(@RequestBody ServerDTO serverDTO) {
        return ResponseEntity.ok(serverService.createServer(serverDTO));
    }

    @PutMapping("/{serverId}")
    public ResponseEntity<ServerDTO> updateServer(@PathVariable Integer serverId, @RequestBody ServerDTO serverDTO) {
        return ResponseEntity.ok(serverService.updateServer(serverId, serverDTO));
    }

    @DeleteMapping("/{serverId}")
    public ResponseEntity<Void> deleteServer(@PathVariable Integer serverId) {
        serverService.deleteServer(serverId);
        return ResponseEntity.noContent().build();
    }
}
