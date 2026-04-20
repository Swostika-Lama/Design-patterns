package mediator_chatApp;

public interface ChatClient {
    String getUsername();
    void receiveMessage(String sender, String message);
}

