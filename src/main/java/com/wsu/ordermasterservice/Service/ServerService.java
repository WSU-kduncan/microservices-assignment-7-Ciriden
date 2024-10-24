package com.wsu.ordermasterservice.Service;

import org.springframework.stereotype.Service;

import com.wsu.ordermasterservice.DTO.ServerDTO;
import com.wsu.ordermasterservice.Model.Server;
import com.wsu.ordermasterservice.Repository.ServerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//import static com.wsu.ordermasterservice.utilities.CommonUtils.sort;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;

    public List<ServerDTO> getAllServers() {
        return serverRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    public ServerDTO getServerById(Integer serverId) {
        Server server = serverRepository.findById(serverId).orElseThrow(() -> new RuntimeException("Server not found"));
        return convertToDTO(server);
    }

    public ServerDTO createServer(ServerDTO serverDTO) {
        Server server = convertToEntity(serverDTO);
        server = serverRepository.save(server);
        return convertToDTO(server);
    }

    public ServerDTO updateServer(Integer serverId, ServerDTO serverDTO) {
        Server server = serverRepository.findById(serverId).orElseThrow(() -> new RuntimeException("Server not found"));
        server.setFirstName(serverDTO.getFirstName());
        server.setLastName(serverDTO.getLastName());
        server.setAvailability(serverDTO.getAvailability());
        return convertToDTO(serverRepository.save(server));
    }

    public void deleteServer(Integer serverId) {
        if (!serverRepository.existsById(serverId)) {
            throw new RuntimeException("Server not found");
        }
        serverRepository.deleteById(serverId);
    }

    private ServerDTO convertToDTO(Server server) {
        return new ServerDTO(
                server.getServerId(),
                server.getFirstName(),
                server.getLastName(),
                server.getAvailability()
        );
    }
    private Server convertToEntity(ServerDTO serverDTO) {
        return new Server(
                serverDTO.getServerId(),
                serverDTO.getFirstName(),
                serverDTO.getLastName(),
                serverDTO.getAvailability()
        );
    }
}
