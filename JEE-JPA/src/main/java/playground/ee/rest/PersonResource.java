package playground.ee.rest;

import playground.ee.jpa.PersonEntity;
import playground.ee.jpa.PersonService;
import playground.ee.jpa.ShoeEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @author jhirschbeck
 */
@Path("/persons")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @GET
    @Path("/person/{id}")
    public Response findById(@PathParam("id") String personId) {

        final PersonEntity personEntity = personService.findById(personId);
        return Response.ok(personEntity).build();
    }

    @POST
    @Path("/person")
    public Response createPerson(PersonEntity person) {
        final PersonEntity personEntity = personService.createPerson(person);
        return Response.ok(personEntity.getId()).build();
    }

    @PUT
    @Path("/person")
    public Response updatePerson(PersonEntity person) {
        final PersonEntity personEntity = personService.updatePerson(person);
        return Response.ok(personEntity.getId()).build();
    }

    @DELETE
    @Path("/person/{id}")
    public Response deletePerson(@PathParam("id") String id) {
        personService.deletePerson(id);
        return Response.noContent().build();
    }


    @GET
    @Path("/person/example")
    public Response personExample() {
        PersonEntity pe = new PersonEntity();
        pe.setSurname("Mike");
        pe.setLastname("Mueller");
        pe.setShoes(Arrays.asList(new ShoeEntity(19), new ShoeEntity(33)));

        return Response.ok(pe.getId()).build();
    }

}
