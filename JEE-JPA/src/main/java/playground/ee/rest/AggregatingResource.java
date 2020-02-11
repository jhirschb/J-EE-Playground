package playground.ee.rest;

import playground.ee.dto.DemoCheckedException;
import playground.ee.dto.ShopEntryDto;
import playground.ee.dto.TxSteeringDto;
import playground.ee.jpa.PersonEntity;
import playground.ee.jpa.PersonService;
import playground.ee.jpa.ShopEntity;
import playground.ee.jpa.ShopService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author jhirschbeck
 */
@Path("shopper")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional(value = Transactional.TxType.REQUIRED,
    dontRollbackOn = {RuntimeException.class},
    rollbackOn = {DemoCheckedException.class})
public class AggregatingResource {

    @Inject
    private PersonService personService;

    @Inject
    private ShopService shopService;


    @POST
    @Path("create")
    public Response callServices(TxSteeringDto steeringDto) {

        PersonEntity person = new PersonEntity();
        try {
            person = personService.createPerson("John", "Doe", steeringDto);
        } catch (DemoCheckedException e) {
            System.out.println("Checked Exception in Person Service");
        }
        ShopEntity shop = new ShopEntity();
        try {
            shop = shopService.createShop("Supershoes", "Hamburg", steeringDto);
        } catch (DemoCheckedException e) {
            System.out.println("Checked Exception in Shop Service");
        }

        return Response.ok(new ShopEntryDto(person, shop)).build();
    }

}
