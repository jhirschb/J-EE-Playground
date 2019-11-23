package playground.ee.resources;

import playground.ee.entities.SimplePerson;
import playground.ee.services.ClassificationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

/**
 * @author jhirschbeck
 */
@Path("/playground")
@Consumes({"application/json"})
@Produces({"application/json"})
public class HelloWorldResource {

    @Inject
    private ClassificationService classificationService;

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok("Hello").build();
    }

    @GET
    @Path("/echo/{message}")
    public Response echo(@PathParam(value = "message") String message) {
        return Response.ok(message).build();
    }

    @POST
    @Path("/echo")
    @Consumes("text/plain")
    public Response echoPost(String text) {
        return Response.ok(text).build();
    }

    @POST
    @Path("/echo/person")
    public Response postObject(SimplePerson person) {
        return Response.ok(person.getLastName()).build();
    }

    @GET
    @Path("/person/classification")
    public Response getPersonClassification(SimplePerson person) {
        return Response.ok(classificationService.classify(person)).build();
    }

    @GET
    @Path("/person/example")
    public Response getExamplePerson() {
        SimplePerson person = new SimplePerson();
        person.setFirstName("Max");
        person.setLastName("Muster");
        person.setBirthDate(LocalDate.of(2000, 11, 11));
        return Response.ok(person).build();
    }

    @GET
    @Path("/error500")
    public Response createErrorResponse() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @GET
    @Path("/exception/{trigger}")
    public Response uncheckedException(@PathParam("trigger") Integer trigger) {
        switch (trigger) {
            case 1:
                throw new RuntimeException("Bang - Runtime");
            default:
                throw new WebApplicationException("Bang - WebApplication", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
