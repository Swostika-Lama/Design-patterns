package Observer_Weather_Station_Simulator.View;

import Observer_Weather_Station_Simulator.model.WeatherData;
import Observer_Weather_Station_Simulator.model.WeatherStation;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationApp extends Application {

    private List<GuiObserverWindow> windows = new ArrayList<>();
    private int windowCount = 0;

    @Override
    public void start(Stage primaryStage) {

        // Shared model
        WeatherData data = new WeatherData();
        WeatherStation station = new WeatherStation(data);

        // Buttons
        Button addButton = new Button("Add Observer");
        Button removeButton = new Button("Remove Observer");

        addButton.setOnAction(e -> {
            windowCount++;
            GuiObserverWindow newWindow = new GuiObserverWindow("Window " + windowCount, data);
            windows.add(newWindow);
            newWindow.show();
        });

        removeButton.setOnAction(e -> {
            if (!windows.isEmpty()) {
                GuiObserverWindow lastWindow = windows.remove(windows.size() - 1);
                lastWindow.close(); // close the window
                windowCount--;
            }
        });

        HBox buttonBox = new HBox(10, addButton, removeButton);
        VBox root = new VBox(10, buttonBox);

        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather Station Controller");
        primaryStage.show();

        // Start the weather station thread
        station.start();
    }

}
