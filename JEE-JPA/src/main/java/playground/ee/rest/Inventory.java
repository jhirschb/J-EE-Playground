package playground.ee.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jhirschbeck
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventory {

    @XmlElement(name = "ID")
    private String identifier;

    @XmlElement(name = "ISBN-LIST")
    private IsbnNumberList isbnNumbers;


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public IsbnNumberList getIsbnNumbers() {
        return isbnNumbers;
    }

    public void setIsbnNumbers(IsbnNumberList isbnNumbers) {
        this.isbnNumbers = isbnNumbers;
    }
}
