package uy.com.sofka.retofinalserverside.dto;

import java.time.LocalDateTime;
import java.util.HashMap;

public class VolanteDTO {
  private Long nroVolante;
  private String nombreProveedor;
  private HashMap<Long, Integer> productosIngresar;
  private LocalDateTime fecha;
  private String documentoProveedor;

  public VolanteDTO() {}


  public Long getNroVolante() {
    return this.nroVolante;
  }

  public String getNombreProveedor() {
    return this.nombreProveedor;
  }

  public HashMap<Long,Integer> getProductosIngresar() {
    return this.productosIngresar;
  }

  public LocalDateTime getFecha() {
    return this.fecha;
  }

  public String getDocumentoProveedor() {
    return this.documentoProveedor;
  }

  // ====== SETTERS VALIDADOS ====== //

  public void setNroVolante(Long nroVolante) {
    // si es nulo, es porque se esta creando. Ponerle 0 cosa de que luego se genere automaticamente
    if(nroVolante == null)
      this.nroVolante = 0L;
    else
      this.nroVolante = nroVolante;
  }

  public void setNombreProveedor(String nombreProveedor) {
    // verificar que no sea null o vacio
    if(nombreProveedor == null || nombreProveedor.isEmpty())
      throw new IllegalArgumentException("El nombre del proveedor no puede ser nulo o vacio");
    this.nombreProveedor = nombreProveedor;
  }
  
  public void setProductosIngresar(HashMap<Long,Integer> productosIngresar) {
    // Verificar que no sea un mapa vacio
    if(productosIngresar == null || productosIngresar.isEmpty())
      throw new IllegalArgumentException("El mapa de productos no puede ser nulo o vacio");
    this.productosIngresar = productosIngresar;
  }

  public void setFecha(LocalDateTime fecha) {
    // validar que no sea null
    if(fecha == null)
      throw new IllegalArgumentException("La fecha no puede ser nula");
    this.fecha = fecha;
  }

  public void setDocumentoProveedor(String documentoProveedor) {
    // verificar que no sea null o vacio
    if(documentoProveedor == null || documentoProveedor.isEmpty())
      throw new IllegalArgumentException("El documento del proveedor no puede ser nulo o vacio");
    this.documentoProveedor = documentoProveedor;
  }


  @Override
  public String toString() {
    return "{" +
      " nroVolante='" + getNroVolante() + "'" +
      ", nombreProveedor='" + getNombreProveedor() + "'" +
      ", productosIngresar='" + getProductosIngresar() + "'" +
      ", fecha='" + getFecha() + "'" +
      ", documentoProveedor='" + getDocumentoProveedor() + "'" +
      "}";
  }

}
