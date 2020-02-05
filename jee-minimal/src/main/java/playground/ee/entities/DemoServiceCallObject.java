package playground.ee.entities;

import playground.ee.jaxbadapter.LocalDateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * @author jhirschbeck
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"targetDate", "header", "pricelist"})
public class DemoServiceCallObject {

    @XmlElement(required = true)
    private String header = "random value";

    @XmlElement(name = "target-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate targetDate = LocalDate.now();

    private Pricelist pricelist = new Pricelist();

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }
}
