package playground.ee.services;

import playground.ee.entities.SimplePerson;
import playground.ee.scoped.DemoRequest;

import javax.inject.Inject;

/**
 * @author jhirschbeck
 */
public class PersonValidationService {

    @Inject
    DemoRequest request;

    public PersonValidationService() {
        System.out.println("PersonValidationService created");
    }

    public boolean isValid(SimplePerson person) {
        request.register(this.getClass().getSimpleName());
        return person.getFirstName() != null
            && person.getLastName() != null
            && person.getBirthDate() != null;
    }
}
