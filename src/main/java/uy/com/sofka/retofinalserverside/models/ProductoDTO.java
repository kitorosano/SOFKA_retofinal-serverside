package uy.com.sofka.retofinalserverside.models;

public class ProductoDTO {
  private String id;
  private String nombre;
  private String descripcion;
  private String categoria;
  private Integer stock;
  private Integer minStock;
  private Integer maxStock;
  private Double precio;

  public ProductoDTO() {}


  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getCategoria() {
    return this.categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public Integer getStock() {
    return this.stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Integer getMinStock() {
    return this.minStock;
  }

  public void setMinStock(Integer minStock) {
    this.minStock = minStock;
  }

  public Integer getMaxStock() {
    return this.maxStock;
  }

  public void setMaxStock(Integer maxStock) {
    this.maxStock = maxStock;
  }

  public Double getPrecio() {
    return this.precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

}
