package uy.com.sofka.retofinalserverside.dto;

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
  
  // ====== SETTERS VALIDADOS ====== //

  public void setId(String id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    // verificar que no sea null o vacio
    if (nombre == null || nombre.isEmpty())
      throw new IllegalArgumentException("El nombre no puede ser vacio o nulo");
    this.nombre = nombre;
  }
  public void setDescripcion(String descripcion) {
    // verificar que no sea null o vacio
    if (descripcion == null || descripcion.isEmpty())
      throw new IllegalArgumentException("La descripcion no puede ser vacia o nula");
    this.descripcion = descripcion;
  }
  public void setCategoria(String categoria) {
    // verificar que no sea null o vacio
    if (categoria == null || categoria.isEmpty())
      throw new IllegalArgumentException("La categoria no puede ser vacia o nula");
    this.categoria = categoria;
  }
  public void setStock(Integer stock) {
    // verificar que no sea menor a minStock o mayor a maxStock
    if (stock < this.minStock)
      throw new IllegalArgumentException("El stock esta superando el minimo permitido");
    if (stock > this.maxStock)
      throw new IllegalArgumentException("El stock esta superando el maximo permitido");
    this.stock = stock;
  }
  public void setMinStock(Integer minStock) {
    // verificar que si es nulo o negativo que sea 0
    if (minStock == null || minStock < 0)
      this.minStock = 0;
    this.minStock = minStock;
  }
  public void setMaxStock(Integer maxStock) {
    // verificiar que si es nulo o menor que minStock que sea igual a minStock sea infinito
    if (maxStock == null || maxStock < this.minStock)
      this.maxStock = Integer.MAX_VALUE;
    this.maxStock = maxStock;
  }
  public void setPrecio(Double precio) {
    // verificar que no sea nullo o negativo
    if (precio == null || precio < 0.0)
      throw new IllegalArgumentException("El precio no puede ser nulo o negativo");
    this.precio = precio;
  }


}
