package playground.ee.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 * @author jhirschbeck
 */
@Named
@RequestScoped
public class Hello {

    @Size(max = 10, message = "Nicht gut, mach weniger")
    private String name;

    public Hello() {
    }

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }
}

