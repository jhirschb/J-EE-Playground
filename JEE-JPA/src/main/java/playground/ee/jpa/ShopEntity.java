package playground.ee.jpa;

import javax.persistence.Entity;

/**
 * @author jhirschbeck
 */
@Entity
public class ShopEntity extends BaseEntity {

    private String name;
    private String city;

    public ShopEntity() {
    }

    public ShopEntity(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
