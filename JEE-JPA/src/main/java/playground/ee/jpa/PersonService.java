package playground.ee.jpa;

import playground.ee.dto.DemoCheckedException;
import playground.ee.dto.TxSteeringDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * @author jhirschbeck
 */
@ApplicationScoped
@Transactional(value = Transactional.TxType.REQUIRES_NEW,
    dontRollbackOn = {RuntimeException.class},
    rollbackOn = {DemoCheckedException.class})
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;


    public List<PersonEntity> findAll() {
        final TypedQuery<PersonEntity> query = em.createQuery("select e from PersonEntity e", PersonEntity.class);
        return query.getResultList();
    }

    public PersonEntity findById(String id) {
        final PersonEntity entity = em.find(PersonEntity.class, id);
        entity.getShoes().size();
        return entity;
    }

    public PersonEntity createPerson(String surname, String lastname, TxSteeringDto steeringDto) throws DemoCheckedException {
        System.out.println(utx);
        if (steeringDto.getExceptionTypePerson() != null) {
            if ("RT".equals(steeringDto.getExceptionTypePerson())) {
                throw new RuntimeException();
            } else {
                throw new DemoCheckedException();
            }
        }
        PersonEntity pe = new PersonEntity(surname, lastname);
        em.persist(pe);

        return pe;
    }

    public PersonEntity updatePerson(String id, String surname, String lastname) {

        final PersonEntity entity = em.find(PersonEntity.class, id);
        entity.setSurname(surname);
        entity.setLastname(lastname);

        return entity;
    }

    public void persist(PersonEntity person) {
        em.persist(person);
    }

    public PersonEntity createPerson(PersonEntity person) {
        person.getShoes().forEach(s -> s.setOwner(person));
        em.persist(person);
        return person;
    }

    public PersonEntity updatePerson(PersonEntity person) {
        person.getShoes().forEach(s -> s.setOwner(person));
        em.merge(person);
        return person;
    }

    public void deletePerson(String person) {
        final PersonEntity personEntity = em.find(PersonEntity.class, person);
        em.remove(personEntity);
    }

}
