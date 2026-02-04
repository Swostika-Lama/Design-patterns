package Singleton_Logger_system;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoggerGui extends Application {

    private Logger logger = Logger.getInstance();
    private TextArea logArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Logger System");

        // File name controls
        TextField fileNameField = new TextField("new_logger.txt");
        Button setFileButton = new Button("Set File");
        setFileButton.setOnAction(e -> {
            String name = fileNameField.getText().trim();
            if (!name.isEmpty()) {
                logger.setFileName(name);
                appendToUI("Log file changed to: " + name);
            }
        });

        HBox fileBox = new HBox(10, new Label("Log file:"), fileNameField, setFileButton);

        // Log input controls
        TextField logInputField = new TextField();
        logInputField.setPromptText("Enter log message...");
        Button logButton = new Button("Write Log");
        logButton.setOnAction(e -> {
            String msg = logInputField.getText().trim();
            if (!msg.isEmpty()) {
                logger.write(msg);
                appendToUI("Wrote: " + msg);
                logInputField.clear();
            }
        });

        HBox inputBox = new HBox(10, logInputField, logButton);

        // TextArea to visualize logs
        logArea = new TextArea();
        logArea.setEditable(false);
        logArea.setPrefRowCount(15);

        // Close button
        Button closeButton = new Button("Close Logger");
        closeButton.setOnAction(e -> {
            logger.close();
            appendToUI("Logger closed.");
        });

        VBox root = new VBox(10, fileBox, inputBox, new Label("Log output (UI only):"), logArea, closeButton);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void appendToUI(String text) {
        logArea.appendText(text + "\n");
    }

    @Override
    public void stop() {
        // Ensure logger is closed when app exits
        logger.close();
    }

}
