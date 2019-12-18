package playground.ee.rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author jhirschbeck
 */

public class IsbnNumberList {

    @XmlElement(name = "isbn-number")
    private List<IsbnNumber> numbers;

    public IsbnNumberList() {
    }

    public IsbnNumberList(List<IsbnNumber> numbers) {
        this.numbers = numbers;
    }
}
