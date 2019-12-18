package playground.ee.rest;

import javax.xml.bind.annotation.XmlValue;

/**
 * @author jhirschbeck
 */
public class IsbnNumber {

    @XmlValue
    private String isbnNumber;

    public IsbnNumber() {
    }

    public IsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
}
