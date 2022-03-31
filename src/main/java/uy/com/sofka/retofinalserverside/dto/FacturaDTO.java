package uy.com.sofka.retofinalserverside.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class FacturaDTO {
  private Long consecutivo;
  private LocalDateTime fecha;
  private String nombreCliente;
  private String atendedor;
  private Map<Long, Integer> productosComprados;
  private Double total;

  public FacturaDTO(){}

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

  // ====== SETTERS VALIDADOS ====== //

  public void setConsecutivo(Long consecutivo) {
    // si es nulo, es porque se esta creando. Ponerle 0 cosa de que luego se genere automaticamente
    if(consecutivo == null)
      this.consecutivo = 0L;
    else
      this.consecutivo = consecutivo;
  }

  public void setFecha(LocalDateTime fecha) {
    // validar que no sea null
    if(fecha == null)
      throw new IllegalArgumentException("La fecha no puede ser nula");
    this.fecha = fecha;
  }

  public void setNombreCliente(String nombreCliente) {
    // verificar que no sea null o vacio
    if(nombreCliente == null || nombreCliente.isEmpty())
      throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacio");
    this.nombreCliente = nombreCliente;
  }

  public void setAtendedor(String atendedor) {
    // verificar que no sea null o vacio
    if(atendedor == null || atendedor.isEmpty())
      throw new IllegalArgumentException("El atendedor no puede ser nulo o vacio");
    this.atendedor = atendedor;
  }

  public void setProductosComprados(Map<Long, Integer> productosComprados) {
    // Verificar que no sea un mapa vacio
    if(productosComprados == null || productosComprados.isEmpty())
      throw new IllegalArgumentException("No puede existir una facura sin productos");
    this.productosComprados = productosComprados;
  }

  public void setTotal(Double total) {
    // verificar que no sea nullo o negativo
    if(total == null || total < 0)
      throw new IllegalArgumentException("El total no puede ser nulo o negativo");
    else
      this.total = total;
  }

  @Override
  public String toString() {
    return "{" +
      " \n\tconsecutivo='" + getConsecutivo() + "'" +
      ", \n\tfecha='" + getFecha() + "'" +
      ", \n\tnombreCliente='" + getNombreCliente() + "'" +
      ", \n\tatendedor='" + getAtendedor() + "'" +
      ", \n\tproductosComprados='" + getProductosComprados() + "'" +
      ", \n\ttotal='" + getTotal() + "'" +
      "\n}";
  }

}
