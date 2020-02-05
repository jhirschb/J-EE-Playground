package playground.ee.ws;

import playground.ee.entities.DemoServiceCallObject;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDate;

/**
 * @author jhirschbeck
 */
@WebService(wsdlLocation = "")
public class DemoJaxWsService {

    @WebMethod
    public DemoServiceCallObject enrichObject(DemoServiceCallObject o) {
        o.setHeader("Some Text");
        o.setTargetDate(LocalDate.now());
        return o;
    }

}
