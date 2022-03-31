package uy.com.sofka.retofinalserverside.models.Cliente;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {
  
  @Id
  @Indexed
  private String documento;
  private String nombre;
  private String celular;

  public String getDocumento() {
    return this.documento;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCelular() {
    return this.celular;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setCelular(String celular) {
    this.celular = celular;
  }

  @Override
  public String toString() {
    return "{" +
      " documento='" + getDocumento() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", celular='" + getCelular() + "'" +
      "}";
  }

}
