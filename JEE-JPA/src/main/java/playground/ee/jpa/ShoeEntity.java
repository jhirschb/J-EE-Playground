package playground.ee.jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author jhirschbeck
 */
@Entity
public class ShoeEntity extends BaseEntity {

    private Integer size;

    @ManyToOne
    PersonEntity owner;
}
