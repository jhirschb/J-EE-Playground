package playground.ee.rest;

import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jhirschbeck
 */
@ApplicationPath("/api")
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8080/jee-jpa")})
public class RestApplication extends Application {

    public static final Logger LOG = LoggerFactory.getLogger(RestApplication.class);

    public RestApplication(@Context ServletConfig servletConfig) {
        OpenAPI oas = new OpenAPI();
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
            .openAPI(oas)
            .prettyPrint(true)
            .resourcePackages(Stream.of("playground.ee.rest").collect(Collectors.toSet()));

        try {
            LOG.info("initializing openapi");
            new JaxrsOpenApiContextBuilder()
                .servletConfig(servletConfig)
                .application(this)
                .openApiConfiguration(oasConfig)
                .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}
