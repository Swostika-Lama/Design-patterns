package mediator_chatApp;

import java.util.HashMap;
import java.util.Map;

public class ConcreteChatMediator implements ChatMediator {

    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        ChatClient target = clients.get(recipient);
        if (target != null) {
            target.receiveMessage(sender, message);
        }
    }
}
