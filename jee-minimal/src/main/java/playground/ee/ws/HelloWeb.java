package playground.ee.ws;

import javax.jws.WebService;

/**
 * @author jhirschbeck
 */
@WebService
public class HelloWeb {

    public String sayHello(String name) {
        return "hallo " + name.toUpperCase();
    }
}
