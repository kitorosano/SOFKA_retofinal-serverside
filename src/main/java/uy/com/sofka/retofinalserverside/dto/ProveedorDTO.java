package uy.com.sofka.retofinalserverside.dto;

public class ProveedorDTO {
  private String documento;
  private String nombre;
  private String celular;

  public ProveedorDTO() {}

  public String getDocumento() {
    return this.documento;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getCelular() {
    return this.celular;
  }

  // ====== SETTERS VALIDADOS ====== //

  public void setDocumento(String documento) {
    // verificar que no sea null o vacio
    if (documento == null || documento.isEmpty())
      throw new IllegalArgumentException("El documento no puede ser vacio o nulo");
    this.documento = documento;
  }

  public void setNombre(String nombre) {
    // verificar que no sea null o vacio
    if (nombre == null || nombre.isEmpty())
      throw new IllegalArgumentException("El nombre no puede ser vacio o nulo");
    this.nombre = nombre;
  }

  public void setCelular(String celular) {
    // verificar que no sea null o vacio
    if (celular == null || celular.isEmpty())
      throw new IllegalArgumentException("El celular no puede ser vacio o nulo");
    this.celular = celular;
  }

}
