package playground.ee.resources;

import playground.ee.entities.SimplePerson;
import playground.ee.scoped.DemoApplicationScoped;
import playground.ee.scoped.DemoRequest;
import playground.ee.services.ClassificationService;
import playground.ee.services.PersonValidationService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author jhirschbeck
 */
@Path("/playground/scopes")
@Consumes({"application/json"})
@Produces({"application/json"})
public class ScopeDemoResource {

    @Inject
    DemoRequest demoRequest;

    @Inject
    DemoApplicationScoped applicationScoped;

    @Inject
    PersonValidationService validationService;

    @Inject
    ClassificationService classificationService;

    @GET
    @Path("/request/count")
    public Response requestCount() {
        return Response.ok(applicationScoped.countRequest()).build();
    }

    @GET
    @Path("/request/participants")
    public Response requestParticipants(SimplePerson p) {
        final Integer requestNumber = applicationScoped.countRequest();
        System.out.println("request number: " + requestNumber   );
        if (p != null && validationService.isValid(p)) {
            classificationService.classify(p);
        }
        return Response.ok("Request No.:" + requestNumber + "\n"
            + demoRequest.summary()).build();
    }

}
