package playground.ee.entities;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

/**
 * @author jhirschbeck
 * @since
 */
@XmlRootElement
public class SimplePerson {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
