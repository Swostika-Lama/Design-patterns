package mediator_chatApp;


import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClientController implements ChatClient {

    private final ClientInfo info;
    private final ChatMediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<ClientInfo> recipientBox;

    public ChatClientController(ClientInfo info, ChatMediator mediator) {
        this.info = info;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    @Override
    public String getUsername() {
        return info.getUsername();
    }

    public ClientInfo getInfo() {
        return info;
    }

    public void setUI(TextArea chatArea, TextField messageField, ComboBox<ClientInfo> recipientBox) {
        this.chatArea = chatArea;
        this.messageField = messageField;
        this.recipientBox = recipientBox;
    }

    public void sendMessage() {
        String message = messageField.getText();
        ClientInfo recipient = recipientBox.getValue();

        if (recipient != null && !message.isEmpty()) {
            mediator.sendMessage(info.getUsername(), recipient.getUsername(), message);
            chatArea.appendText("Me → " + recipient.getUsername() + ": " + message + "\n");
            messageField.clear();
        }
    }

    @Override
    public void receiveMessage(String sender, String message) {
        Platform.runLater(() ->
                chatArea.appendText(sender + " → Me: " + message + "\n")
        );
    }
}
