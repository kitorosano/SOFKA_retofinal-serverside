package uy.com.sofka.retofinalserverside.models.Cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteMapper {
  
  public Cliente fromDTO(ClienteDTO dto) {
    Cliente cliente = new Cliente();
    cliente.setDocumento(dto.getDocumento());
    cliente.setNombre(dto.getNombre());
    cliente.setCelular(dto.getCelular());
    return cliente;
  }

  public ClienteDTO fromCollection(Cliente collection) {
      ClienteDTO clienteDTO = new ClienteDTO();
      clienteDTO.setDocumento(collection.getDocumento());
      clienteDTO.setNombre(collection.getNombre());
      clienteDTO.setCelular(collection.getCelular());
      return clienteDTO;
  }

  public List<ClienteDTO> fromCollectionList(List<Cliente> collection) {
      if (collection == null) return null;
      
      List<ClienteDTO> list = new ArrayList<ClienteDTO>(collection.size());
      Iterator<Cliente> listTracks = collection.iterator();

      while(listTracks.hasNext()) {
        Cliente cliente = (Cliente)listTracks.next();
        list.add(fromCollection(cliente));
      }

      return list;
  }
}
