package playground.ee.resources;

import playground.ee.entities.DemoServiceCallObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author jhirschbeck
 */
@Path("/playground/jaxb")
public class JaxbDemoResource {

    @GET
    @Path("example")
    public Response exampleObject() {
        DemoServiceCallObject entity = new DemoServiceCallObject();
        return Response.ok(entity).build();
    }
}
