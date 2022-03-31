package uy.com.sofka.retofinalserverside.mappers;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import uy.com.sofka.retofinalserverside.dto.ClienteDTO;
import uy.com.sofka.retofinalserverside.models.Cliente;

public class ClienteMapper {
  
  public Cliente fromDTO(ClienteDTO dto) {
    Cliente cliente = new Cliente();
    cliente.setDocumento(dto.getDocumento());
    cliente.setNombre(dto.getNombre());
    cliente.setCelular(dto.getCelular());
    return cliente;
  }

  //  ======= DTO -> ENTITY ======== //
  public Cliente fromDTO2Entity(ClienteDTO dto) {
    Cliente cliente = new Cliente();
    cliente.setDocumento(dto.getDocumento());
    cliente.setNombre(dto.getNombre());
    cliente.setCelular(dto.getCelular());
    return cliente;
  }

  public Cliente fromDTO2Entity(ClienteDTO dto, Cliente cliente) {
    cliente.setDocumento(dto.getDocumento());
    cliente.setNombre(dto.getNombre());
    cliente.setCelular(dto.getCelular());
    return cliente;
  }

  public Mono<Cliente> fromMonoDTO2MonoEntity(Mono<ClienteDTO> dto) {
    return dto.map(clienteDTO -> {
      Cliente cliente = new Cliente();
      cliente.setDocumento(clienteDTO.getDocumento());
      cliente.setNombre(clienteDTO.getNombre());
      cliente.setCelular(clienteDTO.getCelular());
      return cliente;
    });
  }

  public Mono<Cliente> fromMonoDTO2MonoEntity(Mono<ClienteDTO> dto, Cliente cliente) {
    return dto.map(clienteDTO -> {
      cliente.setDocumento(clienteDTO.getDocumento());
      cliente.setNombre(clienteDTO.getNombre());
      cliente.setCelular(clienteDTO.getCelular());
      return cliente;
    });
  }

  //  ======= ENTITY -> DTO ======== //
  public ClienteDTO fromEntity2DTO(Cliente entity) {
    ClienteDTO clienteDTO = new ClienteDTO();
    clienteDTO.setDocumento(entity.getDocumento());
    clienteDTO.setNombre(entity.getNombre());
    clienteDTO.setCelular(entity.getCelular());
    return clienteDTO;
  }

  public Mono<ClienteDTO> fromMonoEntity2MonoDTO(Mono<Cliente> entity) {
    return entity.map(cliente -> {
      ClienteDTO dto = new ClienteDTO();
      dto.setDocumento(cliente.getDocumento());
      dto.setNombre(cliente.getNombre());
      dto.setCelular(cliente.getCelular());
      return dto;
    });
  }

  public Flux<ClienteDTO> fromFluxEntity2FluxDTO(Flux<Cliente> entity) {   
    return entity.map(cliente -> {
      ClienteDTO dto = new ClienteDTO();
      dto.setDocumento(cliente.getDocumento());
      dto.setNombre(cliente.getNombre());
      dto.setCelular(cliente.getCelular());
      return dto;
    });
  }

}
