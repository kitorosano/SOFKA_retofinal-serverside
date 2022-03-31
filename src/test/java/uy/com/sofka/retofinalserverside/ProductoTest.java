package uy.com.sofka.retofinalserverside;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.retofinalserverside.models.Producto.ProductoDTO;
import uy.com.sofka.retofinalserverside.services.IProductoService;

@SpringBootTest
public class ProductoTest {

  @Autowired
  private IProductoService service;
  
  // Test para crear un producto
	@Test
	void crearProducto() throws Exception {
    // Arrange
    ProductoDTO producto = new ProductoDTO();
    producto.setNombre("Producto 1");
    producto.setDescripcion("Descripcion del producto 1");
    producto.setCategoria("Categoria del producto 1");
    producto.setStock(5);
    producto.setMinStock(3);
    producto.setMaxStock(10);
    producto.setPrecio(100.0);
    
    // Act
    Mono<ProductoDTO> result = service.save(producto);

    // Assert
    Assertions.assertEquals("Producto 1", result.block().getNombre());
    Assertions.assertEquals("Descripcion del producto 1", result.block().getDescripcion());
    Assertions.assertEquals("Categoria del producto 1", result.block().getCategoria());
    Assertions.assertEquals(5, result.block().getStock());
    Assertions.assertEquals(3, result.block().getMinStock());
    Assertions.assertEquals(10, result.block().getMaxStock());
    Assertions.assertEquals(100.0, result.block().getPrecio());
	}

  // Test para listar los productos
  @Test
  void listarProductos() throws Exception {
    // Arrange
    Integer count = 3;
    
    // Act
    List<ProductoDTO> result = service.findAll().collectList().block();

    // Assert
    Assertions.assertEquals(count, result.size());
  }
	
  // Test para listar producto por su id
  @Test
  void listarProductoPorId() throws Exception {
    // Arrange
    String id = "xxxxxxx";
    
    // Act
    ProductoDTO result = service.findById(id).block();

    // Assert
    Assertions.assertEquals("Producto 1", result.getNombre());
    Assertions.assertEquals("Descripcion del producto 1", result.getDescripcion());
    Assertions.assertEquals("Categoria del producto 1", result.getCategoria());
    Assertions.assertEquals(5, result.getStock());
    Assertions.assertEquals(3, result.getMinStock());
    Assertions.assertEquals(10, result.getMaxStock());
    Assertions.assertEquals(100.0, result.getPrecio());
  }

  // Test para eliminar los productos
  @Test
  void eliminarProducto() throws Exception {
    // Act
    service.deleteAll().then(
      service.findAll().collectList().flatMap(lista -> {
        // Assert
        Assertions.assertEquals(0, lista.size());
        return Mono.empty();
      })
    );
  }

  // Test para eliminar un producto por su id
  @Test
  void crearUnProductoYEliminarloPorId() throws Exception {
    // Arrange
    ProductoDTO producto1 = new ProductoDTO();
    producto1.setNombre("Producto 1");
    producto1.setDescripcion("Descripcion del producto 1");
    producto1.setCategoria("Categoria del producto 1");
    producto1.setStock(5);
    producto1.setMinStock(3);
    producto1.setMaxStock(10);
    producto1.setPrecio(100.0);
    
    // Act
    service.save(producto1).flatMap(producto -> {
      return service.delete(producto.getId());
    }).then(
      service.findAll().collectList().flatMap(lista -> {
        // Assert
        Assertions.assertEquals(0, lista.size());
        return Mono.empty();
      })
    );
  }

  @Test
  void eliminarUnProductoPorId() throws Exception {
    // Arrange
    String id = "xxxxxxx";
    
    // Act
    service.delete(id)
      .then(
      service.findAll().collectList().flatMap(lista -> {
        // Assert
        Assertions.assertEquals(0, lista.size());
        return Mono.empty();
      })
    );
  }

  // Test para actualizar un producto por id
  @Test
  void crearProductoYActualizarloPorId() throws Exception {
    // Arrange
    ProductoDTO producto1 = new ProductoDTO();
    producto1.setNombre("Producto 1");
    producto1.setDescripcion("Descripcion del producto 1");
    producto1.setCategoria("Categoria del producto 1");
    producto1.setStock(5);
    producto1.setMinStock(3);
    producto1.setMaxStock(10);
    producto1.setPrecio(100.0);
    
    // Act
    service.save(producto1).flatMap(producto -> {
      producto.setNombre("Producto 1 modificado");
      producto.setDescripcion("Descripcion del producto 1 modificado");
      producto.setCategoria("Categoria del producto 1 modificado");
      producto.setStock(10);
      producto.setMinStock(5);
      producto.setMaxStock(15);
      producto.setPrecio(200.0);
      return service.update(producto.getId(), producto);
    }).doOnNext(onNext -> {
      service.findById(onNext.getId()).flatMap(producto -> {
        // Assert
        Assertions.assertEquals("Producto 1 modificado", producto.getNombre());
        Assertions.assertEquals("Descripcion del producto 1 modificado", producto.getDescripcion());
        Assertions.assertEquals("Categoria del producto 1 modificado", producto.getCategoria());
        Assertions.assertEquals(10, producto.getStock());
        Assertions.assertEquals(5, producto.getMinStock());
        Assertions.assertEquals(15, producto.getMaxStock());
        Assertions.assertEquals(200.0, producto.getPrecio());
        return Mono.empty();
      });
    });
  }

  @Test
  void actualizarUnProductoPorId() throws Exception {
    // Arrange
    String id = "xxxx";
    
    // Act
    service.findById(id).flatMap(producto -> {
      producto.setNombre("Producto 1 modificado");
      producto.setDescripcion("Descripcion del producto 1 modificado");
      producto.setCategoria("Categoria del producto 1 modificado");
      producto.setStock(10);
      producto.setMinStock(5);
      producto.setMaxStock(15);
      producto.setPrecio(200.0);
      return service.update(producto.getId(), producto);
    }).then(
      service.findById(id).flatMap(producto -> {
        // Assert
        Assertions.assertEquals("Producto 1 modificado", producto.getNombre());
        Assertions.assertEquals("Descripcion del producto 1 modificado", producto.getDescripcion());
        Assertions.assertEquals("Categoria del producto 1 modificado", producto.getCategoria());
        Assertions.assertEquals(10, producto.getStock());
        Assertions.assertEquals(5, producto.getMinStock());
        Assertions.assertEquals(15, producto.getMaxStock());
        Assertions.assertEquals(200.0, producto.getPrecio());
        return Mono.empty();
      })
    );
  }
}
