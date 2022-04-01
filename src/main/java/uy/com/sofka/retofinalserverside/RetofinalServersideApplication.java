package uy.com.sofka.retofinalserverside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class RetofinalServersideApplication { 

	public static void main(String[] args) {
		SpringApplication.run(RetofinalServersideApplication.class, args);
	}
  
  @Bean
  public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info().title("Ferreteria Raul API")
              .description("API para ferreteria Raul. CRUD de Productos, Clientes, Proveedores, Facturas y Volantes.")
              .version("v1.0"))
              .externalDocs(new ExternalDocumentation()
              .description("Documentation")
              .url("https://sofka-ferreteria-don-raul.firebaseapp.com"));
  }

}
