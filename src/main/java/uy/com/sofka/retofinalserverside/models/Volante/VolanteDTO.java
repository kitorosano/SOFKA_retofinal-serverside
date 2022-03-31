package uy.com.sofka.retofinalserverside.models.Volante;

import java.time.LocalDateTime;
import java.util.HashMap;

public class VolanteDTO {
  private Long nroVolante;
  private String nombreProveedor;
  private HashMap<Long, Integer> productosIngresar;
  private LocalDateTime fecha;
  private Long documentoProveedor;

  public VolanteDTO() {}


  public Long getNroVolante() {
    return this.nroVolante;
  }

  public void setNroVolante(Long nroVolante) {
    this.nroVolante = nroVolante;
  }

  public String getNombreProveedor() {
    return this.nombreProveedor;
  }

  public void setNombreProveedor(String nombreProveedor) {
    this.nombreProveedor = nombreProveedor;
  }

  public HashMap<Long,Integer> getProductosIngresar() {
    return this.productosIngresar;
  }

  public void setProductosIngresar(HashMap<Long,Integer> productosIngresar) {
    this.productosIngresar = productosIngresar;
  }

  public LocalDateTime getFecha() {
    return this.fecha;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public Long getDocumentoProveedor() {
    return this.documentoProveedor;
  }

  public void setDocumentoProveedor(Long documentoProveedor) {
    this.documentoProveedor = documentoProveedor;
  }

}
