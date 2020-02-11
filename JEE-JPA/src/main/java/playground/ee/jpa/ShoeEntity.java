package playground.ee.jpa;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author jhirschbeck
 */
@Entity
public class ShoeEntity extends BaseEntity {

    private Integer size;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    PersonEntity owner;

    public ShoeEntity() {
    }

    public ShoeEntity(int size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonbTransient
    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity owner) {
        this.owner = owner;
    }
}
