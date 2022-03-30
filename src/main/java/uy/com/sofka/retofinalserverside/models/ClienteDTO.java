package uy.com.sofka.retofinalserverside.models;

public class ClienteDTO {
  private String documento;
  private String nombre;
  private String celular;

  public ClienteDTO() {}

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
}
