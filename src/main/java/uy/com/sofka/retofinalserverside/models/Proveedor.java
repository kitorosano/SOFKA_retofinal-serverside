package uy.com.sofka.retofinalserverside.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Proveedor {

  @Id
  // @Indexed
  private final String codigo;
  private final String nombre;
  private final String celular;

  public Proveedor(String codigo, String nombre, String celular) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.celular = celular;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCelular() {
    return this.celular;
  }
}
