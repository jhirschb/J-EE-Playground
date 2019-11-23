package playground.ee.jpa;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author jhirschbeck
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    private UUID id;

    public BaseEntity() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
