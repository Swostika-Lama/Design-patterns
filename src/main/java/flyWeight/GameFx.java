package flyWeight;

import Factory_method.RPG_Map_Generator.Game;
import Factory_method.RPG_Map_Generator.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameFx extends Application {

    @Override
    public void start(Stage stage) {
        Map map = Game.createMap("city", 40, 30);

        map.display(); // ensures tiles are created

        Canvas canvas = new Canvas(40 * 32, 30 * 32);
        MapRender renderer = new MapRender();
        renderer.render(canvas, map.getTiles());

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("RPG Map with Flyweight Rendering");
        stage.show();
    }
}
