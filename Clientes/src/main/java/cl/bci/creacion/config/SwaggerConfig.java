package cl.bci.creacion.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private String title = Constantes.titulo;
	private String version = Constantes.version;
	private String description = Constantes.descripcion;
	private String basePackage = Constantes.packageBase;
	private String contactName = Constantes.nombre;
	private String contactEmail = Constantes.email;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage(basePackage))
			.paths(PathSelectors.any())
			.build()
			.directModelSubstitute(LocalDate.class, java.sql.Date.class)
			.directModelSubstitute(LocalDateTime.class, java.util.Date.class)
			.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title(title)
			.description(description)
			.version(version)
			.contact(new Contact(contactName, null, contactEmail))
		.build();
	}
	
}