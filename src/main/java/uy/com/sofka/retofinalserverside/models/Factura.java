package uy.com.sofka.retofinalserverside.models;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Factura {
  
  @Id
  private final Long consecutivo;
  private final LocalDateTime fecha;
  private final String nombreCliente;
  private final String atendedor;
  private final HashMap<Long, Integer> productosComprados;
  private final Double total;

  public Factura(Long consecutivo, LocalDateTime fecha, String nombreCliente, String atendedor, HashMap<Long, Integer> productosComprados, Double total) {
    this.consecutivo = consecutivo;
    this.fecha = fecha;
    this.nombreCliente = nombreCliente;
    this.atendedor = atendedor;
    this.productosComprados = productosComprados;
    this.total = total;
  }

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

  public HashMap<Long, Integer> getProductos() {
    return this.productosComprados;
  }

  public Double getTotal() {
    return this.total;
  }
}
