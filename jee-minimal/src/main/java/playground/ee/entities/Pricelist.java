package playground.ee.entities;

import playground.ee.jaxbadapter.BigDecimalAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jhirschbeck
 */
@XmlType(name = "pricelist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pricelist {

    @XmlElement(name = "price")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private List<BigDecimal> prices = new ArrayList<>();

    @XmlAttribute
    private String flag = "good-friends";

    public List<BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(List<BigDecimal> prices) {
        this.prices = prices;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
