package playground.ee.jpa;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.UUID;

/**
 * @author jhirschbeck
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    private String id;

    @Version
    private Long version;

    public BaseEntity() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
