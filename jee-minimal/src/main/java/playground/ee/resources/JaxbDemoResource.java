package playground.ee.resources;

import playground.ee.entities.DemoServiceCallObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author jhirschbeck
 */
@Path("/playground/jaxb")
public class JaxbDemoResource {

    @GET
    @Path("example")
    public Response exampleObject() {
        DemoServiceCallObject entity = new DemoServiceCallObject();
        entity.getPricelist().setPrices(Arrays.asList(new BigDecimal(1.12), new BigDecimal(1000.120988)));
        return Response.ok(entity).build();
    }
}
