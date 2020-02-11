package playground.ee.dto;

/**
 * @author jhirschbeck
 */
public class TxSteeringDto {

    private String exceptionTypePerson;
    private String exceptionTypeShop;


    public String getExceptionTypePerson() {
        return exceptionTypePerson;
    }

    public void setExceptionTypePerson(String exceptionTypePerson) {
        this.exceptionTypePerson = exceptionTypePerson;
    }

    public String getExceptionTypeShop() {
        return exceptionTypeShop;
    }

    public void setExceptionTypeShop(String exceptionTypeShop) {
        this.exceptionTypeShop = exceptionTypeShop;
    }
}
