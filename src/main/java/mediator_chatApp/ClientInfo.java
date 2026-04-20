package mediator_chatApp;

public class ClientInfo {
    private final String username;

    public ClientInfo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }


}
