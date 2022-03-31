package uy.com.sofka.retofinalserverside.models.Volante;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Volante {
  
  @Transient
  public static final String SEQUENCE_NAME = "users_sequence";


  @Id 
  private Long nroVolante;
  private String nombreProveedor;
  private HashMap<Long, Integer> productosIngresar;
  private LocalDateTime fecha;
  private Long documentoProveedor;

  public Long getNroVolante() {
    return this.nroVolante;
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

  public void setNroVolante(Long nroVolante) {
    this.nroVolante = nroVolante;
  }
  public void setNombreProveedor(String nombreProveedor) {
    this.nombreProveedor = nombreProveedor;
  }
  public void setProductosIngresar(HashMap<Long,Integer> productosIngresar) {
    this.productosIngresar = productosIngresar;
  }
  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }
  public void setDocumentoProveedor(Long documentoProveedor) {
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
