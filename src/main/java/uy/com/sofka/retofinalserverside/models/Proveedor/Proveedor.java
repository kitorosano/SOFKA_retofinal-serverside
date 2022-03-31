package uy.com.sofka.retofinalserverside.models.Proveedor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Proveedor {

  @Id
  private String codigo;
  private String nombre;
  private String celular;

  public String getCodigo() {
    return this.codigo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCelular() {
    return this.celular;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setCelular(String celular) {
    this.celular = celular;
  }


}
