package playground.ee.entities;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jhirschbeck
 */
public class SimplePerson {

    private String firstName;
    private String lastName;
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate birthDate;

    List<String> friends = new ArrayList<>();

    Map<String, String> mappedFriends = new HashMap<>();

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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

}
