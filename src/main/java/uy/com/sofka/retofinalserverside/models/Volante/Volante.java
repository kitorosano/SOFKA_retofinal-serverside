package uy.com.sofka.retofinalserverside.models.Volante;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Volante {
  
  @Id 
  private final Long nroVoltante;
  private final String nombreProveedor;
  private final HashMap<Long, Integer> productosIngresar;
  private final LocalDateTime fecha;
  private final Long documentoProveedor;

  public Volante(Long nroVoltante, String nombreProveedor, HashMap<Long, Integer> productosIngresar, LocalDateTime fecha, Long documentoProveedor) {
    this.nroVoltante = nroVoltante;
    this.nombreProveedor = nombreProveedor;
    this.productosIngresar = productosIngresar;
    this.fecha = fecha;
    this.documentoProveedor = documentoProveedor;
  }

  public Long getNroVoltante() {
    return this.nroVoltante;
  }

  public String getNombreProveedor() {
    return this.nombreProveedor;
  }

  public HashMap<Long, Integer> getProductosIngresar() {
    return this.productosIngresar;
  }

  public LocalDateTime getFecha() {
    return this.fecha;
  }

  public Long getDocumentoProveedor() {
    return this.documentoProveedor;
  }

}
