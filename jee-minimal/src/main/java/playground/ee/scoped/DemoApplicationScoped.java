package playground.ee.scoped;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jhirschbeck
 */
@ApplicationScoped
public class DemoApplicationScoped {

    private AtomicInteger requestCount = new AtomicInteger(0);

    public Integer countRequest() {
        return requestCount.incrementAndGet();
    }

}
