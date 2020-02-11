package playground.ee.jpa;

import playground.ee.dto.DemoCheckedException;
import playground.ee.dto.TxSteeringDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

/**
 * @author jhirschbeck
 */
@ApplicationScoped
@Transactional(value = Transactional.TxType.REQUIRED,
    dontRollbackOn = {RuntimeException.class},
    rollbackOn = {DemoCheckedException.class})
public class ShopService {

    @PersistenceContext
    EntityManager em;
    @Inject
    UserTransaction utx;

    public ShopEntity createShop(String name, String city, TxSteeringDto steeringDto) throws DemoCheckedException {
        System.out.println(utx);
        if (steeringDto.getExceptionTypeShop() != null) {
            if ("RT".equals(steeringDto.getExceptionTypeShop())) {
                throw new RuntimeException();
            } else {
                throw new DemoCheckedException();
            }
        }
        ShopEntity shop = new ShopEntity(name, city);
        em.persist(shop);
        return shop;
    }

    public ShopEntity updateShop(ShopEntity shop) {
        em.merge(shop);
        return shop;
    }

}
