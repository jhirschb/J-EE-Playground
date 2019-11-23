package playground.ee.scoped;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author jhirschbeck
 */
@RequestScoped
public class DemoRequest {

    private UUID requestId;
    private List<String> participants = new ArrayList<>();

    public DemoRequest() {
        requestId = UUID.randomUUID();
    }

    public void register(String participant) {
        participants.add(participant);
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public String summary() {
        return "Request-id: " + requestId.toString()
            + "\nParticipants: " + participants.stream().collect(Collectors.joining("\n"));
    }
}
