package playground.ee.dto;

import playground.ee.jpa.PersonEntity;
import playground.ee.jpa.ShopEntity;

/**
 * @author jhirschbeck
 */
public class ShopEntryDto {

    private PersonEntity person;
    private ShopEntity shop;

    public ShopEntryDto(PersonEntity person, ShopEntity shop) {
        this.person = person;
        this.shop = shop;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }
}
