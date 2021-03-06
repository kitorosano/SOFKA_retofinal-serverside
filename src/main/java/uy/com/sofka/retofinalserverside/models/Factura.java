package uy.com.sofka.retofinalserverside.models;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Factura {

  @Transient
  public static final String SEQUENCE_NAME = "database_sequences";
  
  @Id 
  private Long consecutivo;
  private LocalDateTime fecha;
  private String nombreCliente;
  private String atendedor;
  private Map<Long, Integer> productosComprados;
  private Double total;
  
  public Long getConsecutivo() {
    return this.consecutivo;
  }

  public LocalDateTime getFecha() {
    return this.fecha;
  }

  public String getNombreCliente() {
    return this.nombreCliente;
  }

  public String getAtendedor() {
    return this.atendedor;
  }

  public Map<Long, Integer> getProductosComprados() {
    return this.productosComprados;
  }

  public Double getTotal() {
    return this.total;
  }

  public void setConsecutivo(Long consecutivo) {
    this.consecutivo = consecutivo;
  }

  public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }
  
  public void setAtendedor(String atendedor) {
    this.atendedor = atendedor;
  }

  public void setProductosComprados(Map<Long, Integer> productosComprados) {
    this.productosComprados = productosComprados;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

}
