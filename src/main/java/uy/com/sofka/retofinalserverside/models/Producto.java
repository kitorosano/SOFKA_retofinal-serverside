package uy.com.sofka.retofinalserverside.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventario")
public class Producto {

  @Transient
  public static final String SEQUENCE_NAME = "inventario_sequence";
  
  @Id
  // @Indexed
  private final String id = UUID.randomUUID().toString().substring(0, 10);
  private final String nombre;
  private final String descripcion;
  private final Integer stock;
  private final Integer minStock;
  private final Integer maxStock;
  private final Double precio;
  private final String categoria;

  public Producto(String nombre, String descripcion, Integer stock, Integer minStock, Integer maxStock, Double precio, String categoria) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.stock = stock;
    this.minStock = minStock;
    this.maxStock = maxStock;
    this.precio = precio;
    this.categoria = categoria;
  }


  public String getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public Integer getStock() {
    return this.stock;
  }

  public Integer getMinStock() {
    return this.minStock;
  }

  public Integer getMaxStock() {
    return this.maxStock;
  }

  public Double getPrecio() {
    return this.precio;
  }

  public String getCategoria() {
    return this.categoria;
  }

  
}
