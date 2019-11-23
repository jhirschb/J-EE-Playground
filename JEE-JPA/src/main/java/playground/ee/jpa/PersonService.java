package playground.ee.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author jhirschbeck
 */
@Stateless
@Transactional
public class PersonService {

    @PersistenceContext
    private EntityManager em;


    public List<PersonEntity> findAll() {
        final Query query = em.createQuery("select e from PersonEntity e");
        return query.getResultList();
    }

    public PersonEntity createPerson(String surname, String lastname) {

        PersonEntity pe = new PersonEntity(surname, lastname);
        em.persist(pe);

        return pe;
    }

    public void persist(PersonEntity person) {
        em.persist(person);
    }

}
