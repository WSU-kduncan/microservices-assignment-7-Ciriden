package com.wsu.ordermasterservice.service;

import com.example.servers.dto.ServerDTO;
import com.example.servers.model.Server;
import com.example.servers.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service layer for business logic and data manipulation
@Service
public class ServerService {

    private final ServerRepository serverRepository;

    // Retrieve all servers
    public List<ServerDTO> getAllServers() {
        // Convert entity to DTO
        return serverRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    // Retrieve a server by ID
    public ServerDTO getServerById(int id) {
        Server server = serverRepository.findById(id).orElseThrow(() -> new RuntimeException("Server not found"));
        return convertToDTO(server);
    }

    // Create a new server
    public ServerDTO createServer(ServerDTO serverDTO) {
        Server server = convertToEntity(serverDTO);
        server = serverRepository.save(server);
        return convertToDTO(server);
    }

    // Update an existing server
    public ServerDTO updateServer(int id, ServerDTO serverDTO) {
        Server server = serverRepository.findById(id).orElseThrow(() -> new RuntimeException("Server not found"));
        // Update fields as needed
        server.setFirstName(serverDTO.getFirstName());
        server.setLastName(serverDTO.getLastName());
        server.setAvailability(serverDTO.getAvailability());
        return convertToDTO(serverRepository.save(server));
    }

    // Delete a server
    public void deleteServer(int id) {
        if (!serverRepository.existsById(id)) {
            throw new RuntimeException("Server not found");
        }
        serverRepository.deleteById(id);
    }

    // Helper methods for conversion
    private ServerDTO convertToDTO(Server server) {
        // Convert Server entity to ServerDTO
    }

    private Server convertToEntity(ServerDTO serverDTO) {
        // Convert ServerDTO to Server entity
    }
}
