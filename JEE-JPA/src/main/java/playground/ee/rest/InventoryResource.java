package playground.ee.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author jhirschbeck
 */
@Path("inventory")
@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
public class InventoryResource {

    @GET
    @Path("example")
    public Response exampleXml() {
        Inventory i = new Inventory();
        i.setIdentifier("new-identifier");
        final List<IsbnNumber> numbers = Arrays.asList(new IsbnNumber("ABCD-EF-9999"),
            new IsbnNumber("XXXX-YY-0001"));
        i.setIsbnNumbers(new IsbnNumberList(numbers));

        return Response.ok(i).build();
    }

    @GET
    @Path("example-direct")
    public Inventory exampleXmlDirect() {
        Inventory i = new Inventory();
        i.setIdentifier("new-identifier");
        final List<IsbnNumber> numbers = Arrays.asList(new IsbnNumber("ABCD-EF-9999"),
            new IsbnNumber("XXXX-YY-0001"));
        i.setIsbnNumbers(new IsbnNumberList(numbers));

        return i;
    }


    @POST
    @Path("example")
    public Response receivePersonXml(Inventory i) {
        System.out.println("received Inventory id: " + i.getIdentifier());
        return Response.ok(i).build();
    }

    @POST
    @Path("example-string")
    public Response receivePersonXml(String inventory) {
        System.out.println("received Inventory : " + inventory);
        try {
            JAXBContext jc = JAXBContext.newInstance(Inventory.class);
            final Inventory inv = (Inventory) jc.createUnmarshaller().unmarshal(new StringReader(inventory));
            return Response.ok(inv).build();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
