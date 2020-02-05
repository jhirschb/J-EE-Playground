package playground.ee.jaxbadapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author jhirschbeck
 */
public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public BigDecimal unmarshal(String v) throws Exception {
        if (v != null) {
            return new BigDecimal(v);
        } else {
            return null;
        }
    }

    @Override
    public String marshal(BigDecimal v) throws Exception {
        return v.setScale(2, RoundingMode.HALF_UP).toString();
    }
}
