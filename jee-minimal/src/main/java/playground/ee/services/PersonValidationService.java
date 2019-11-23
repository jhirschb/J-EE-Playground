package playground.ee.services;

import playground.ee.entities.SimplePerson;
import playground.ee.scoped.DemoRequest;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author jhirschbeck
 */
@Stateless
public class PersonValidationService {

    @Inject
    DemoRequest request;

    public boolean isValid(SimplePerson person) {
        request.register(this.getClass().getSimpleName());
        return person.getFirstName() != null
            && person.getLastName() != null
            && person.getBirthDate() != null;
    }
}
