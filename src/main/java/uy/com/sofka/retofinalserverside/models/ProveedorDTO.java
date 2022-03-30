package uy.com.sofka.retofinalserverside.models;

public class ProveedorDTO {
  private String codigo;
  private String nombre;
  private String celular;

  public ProveedorDTO() {}

  public String getCodigo() {
    return this.codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCelular() {
    return this.celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

}
