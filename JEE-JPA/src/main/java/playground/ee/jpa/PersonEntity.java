package playground.ee.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author jhirschbeck
 */
@Entity
@NamedQuery(name = "findByName", query = "select e from PersonEntity e where e.lastname like :lastname")
public class PersonEntity extends BaseEntity {

    @NotNull(message = "Give name please")
    @Size(min = 1, max = 10, message = "Size has to be between 1 and 10 characters")
    private String surname;

    private String lastname;

    public PersonEntity() {
    }

    public PersonEntity(String surname, String lastname) {
        this.surname = surname;
        this.lastname = lastname;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", orphanRemoval = true)
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
