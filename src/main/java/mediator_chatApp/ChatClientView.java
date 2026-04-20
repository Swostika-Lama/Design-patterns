package mediator_chatApp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatClientView {

    public ChatClientView(ChatClientController controller, ClientInfo[] allClients) {

        Stage stage = new Stage();
        stage.setTitle(controller.getInfo().getUsername());

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField messageField = new TextField();
        messageField.setPromptText("Type message...");

        ComboBox<ClientInfo> recipientBox = new ComboBox<>();
        for (ClientInfo c : allClients) {
            if (!c.getUsername().equals(controller.getInfo().getUsername())) {
                recipientBox.getItems().add(c);
            }
        }

        Button sendBtn = new Button("Send");
        sendBtn.setOnAction(e -> controller.sendMessage());

        controller.setUI(chatArea, messageField, recipientBox);

        VBox layout = new VBox(10, chatArea, messageField, recipientBox, sendBtn);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout, 350, 400));
        stage.show();
    }
}
