package mediator_chatApp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        ConcreteChatMediator mediator = new ConcreteChatMediator();

        ClientInfo c1 = new ClientInfo("Alice");
        ClientInfo c2 = new ClientInfo("Bob");
        ClientInfo c3 = new ClientInfo("Charlie");

        ClientInfo[] allClients = {c1, c2, c3};

        ChatClientController ctrl1 = new ChatClientController(c1, mediator);
        ChatClientController ctrl2 = new ChatClientController(c2, mediator);
        ChatClientController ctrl3 = new ChatClientController(c3, mediator);

        new ChatClientView(ctrl1, allClients);
        new ChatClientView(ctrl2, allClients);
        new ChatClientView(ctrl3, allClients);
    }

}

