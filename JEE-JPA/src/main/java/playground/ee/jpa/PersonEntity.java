package playground.ee.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author jhirschbeck
 */
@Entity
public class PersonEntity extends BaseEntity {

    private String surname;

    private String lastname;

    public PersonEntity() {
    }

    public PersonEntity(String surname, String lastname) {
        this.surname = surname;
        this.lastname = lastname;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShoeEntity> shoes;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<ShoeEntity> getShoes() {
        return shoes;
    }

    public void setShoes(List<ShoeEntity> shoes) {
        this.shoes = shoes;
    }
}
