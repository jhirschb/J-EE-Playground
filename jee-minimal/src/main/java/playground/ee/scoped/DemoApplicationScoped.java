package playground.ee.scoped;

import javax.inject.Named;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jhirschbeck
 */
@Named(value = "xy")
public class DemoApplicationScoped {


    private AtomicInteger requestCount = new AtomicInteger(0);

    public Integer countRequest() {
        final LocalTime start = LocalTime.now();
        final int newCount = requestCount.incrementAndGet();
        if (newCount % 100 == 0) {

            System.out.println(this + " : 100 Requests performed");
        }
        return newCount;
    }

}
