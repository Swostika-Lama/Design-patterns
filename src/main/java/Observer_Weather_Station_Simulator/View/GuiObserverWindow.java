package Observer_Weather_Station_Simulator.View;

import Observer_Weather_Station_Simulator.model.WeatherData;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiObserverWindow implements WeatherObserver {

    private String name;
    private WeatherData data;
    private Label label;
    private Stage stage; // store the stage

    public GuiObserverWindow(String name, WeatherData data) {
        this.name = name;
        this.data = data;
        this.label = new Label();

        // Register itself as observer
        data.registerObserver(this);

        createWindow();
    }

    private void createWindow() {
        stage = new Stage(); // initialize the stage
        stage.setTitle(name);

        VBox root = new VBox(10, label);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 350, 200);
        stage.setScene(scene);

    }

    @Override
    public void updateTemperature(int temperature) {
        Platform.runLater(() -> label.setText(name + ": Current temperature is " + temperature + "°C"));
    }

    // Show the window
    public void show() {
        Platform.runLater(() -> stage.show());
    }

    // Close the window
    public void close() {
        Platform.runLater(() -> {
            stage.close();
            data.removeObserver(this); // remove from WeatherData
        });
    }
}
