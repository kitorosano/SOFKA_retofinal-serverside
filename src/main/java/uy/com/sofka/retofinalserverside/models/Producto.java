package uy.com.sofka.retofinalserverside.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventario")
public class Producto {

  @Id
  private String id = UUID.randomUUID().toString().substring(0, 10);
  private String nombre;
  private String descripcion;
  private String categoria;
  private Integer stock;
  private Integer minStock;
  private Integer maxStock;
  private Double precio;
 
  public String getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public String getCategoria() {
    return this.categoria;
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
  
  public void setId(String id) {
    this.id = id;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
  public void setStock(Integer stock) {
    this.stock = stock;
  }
  public void setMinStock(Integer minStock) {
    this.minStock = minStock;
  }
  public void setMaxStock(Integer maxStock) {
    this.maxStock = maxStock;
  }
  public void setPrecio(Double precio) {
    this.precio = precio;
  }


  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", descripcion='" + getDescripcion() + "'" +
      ", categoria='" + getCategoria() + "'" +
      ", stock='" + getStock() + "'" +
      ", minStock='" + getMinStock() + "'" +
      ", maxStock='" + getMaxStock() + "'" +
      ", precio='" + getPrecio() + "'" +
      "}";
  }
  
}
