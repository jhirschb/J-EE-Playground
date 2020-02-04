package playground.ee.entities;

import playground.ee.jaxbadapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * @author jhirschbeck
 */
@XmlRootElement
public class DemoServiceCallObject {

    private String header = "random value";

    private LocalDate targetDate = LocalDate.now();

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @XmlElement(name = "target-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
