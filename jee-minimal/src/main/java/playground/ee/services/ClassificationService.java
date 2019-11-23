package playground.ee.services;

import playground.ee.entities.CustomerType;
import playground.ee.entities.SimplePerson;
import playground.ee.scoped.DemoRequest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author jhirschbeck
 * @since
 */
@Stateless
public class ClassificationService {

    @Inject
    DemoRequest request;

    public CustomerType classify(SimplePerson person) {
        request.register(this.getClass().getSimpleName());

        final Duration age = Duration.between(LocalDateTime.now(), LocalDateTime.of(person.getBirthDate(), LocalTime.MIDNIGHT));

        if (TimeUnit.SECONDS.toDays(age.getSeconds()) / 365 > 60) {
            return CustomerType.LEAVE;
        } else if (TimeUnit.SECONDS.toDays(age.getSeconds()) / 365 > 30) {
            return CustomerType.HOLD;
        } else if (TimeUnit.SECONDS.toDays(age.getSeconds()) / 365 > 12) {
            return CustomerType.AQUIRE;
        } else {
            return CustomerType.POSTPONE;
        }
    }

}
