package uy.com.sofka.retofinalserverside.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {
  
  @Id
  // @Indexeds
  private final String documento;
  private final String nombre;
  private final String celular;

  public Cliente(String documento, String nombre, String celular) {
    this.documento = documento;
    this.nombre = nombre;
    this.celular = celular;
  }

  public String getDocumento() {
    return this.documento;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCelular() {
    return this.celular;
  }
}
