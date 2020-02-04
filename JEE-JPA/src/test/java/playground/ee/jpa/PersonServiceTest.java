package playground.ee.jpa;

import org.hamcrest.CoreMatchers;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * Sample test to showcase simple jpa for a single entity.
 * Your Wildfly needs to be up and running in standalone mode, no special config required.
 */
@RunWith(Arquillian.class)
public class PersonServiceTest {

    @Inject
    PersonService personService;

    @Deployment
    public static Archive<WebArchive> getArchive() {

        WebArchive war = ShrinkWrap.create(WebArchive.class);
        war.addPackage("playground.ee.jpa");
        war.addAsResource("jpa-persistence.xml", "META-INF/persistence.xml");
        war.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        return war;
    }


    @Test
    public void find_all_returns_withour_error() {
        final List<PersonEntity> all = personService.findAll();

        System.out.println("Fetched " + all.size() + " persons");
    }

    @Test
    public void can_create_a_new_person_and_find_it() {
        List<PersonEntity> all = personService.findAll();
        int startsize = all.size();
        final PersonEntity babyMax = personService.createPerson("Max", "Muster");
        all = personService.findAll();
        int endsize = all.size();
        System.out.println("Fetched " + all.size() + " persons");
        UnsupportedOperationException c;
        assertThat(endsize - startsize, CoreMatchers.is(1));
    }

    @Test
    public void create_person_with_shoes() {
        PersonEntity pe = new PersonEntity("Bill", "Bourne");
        pe.setShoes(Arrays.asList(new ShoeEntity()));
        personService.persist(pe);

        assertThat(pe.getId(), CoreMatchers.notNullValue(String.class));
    }

}
