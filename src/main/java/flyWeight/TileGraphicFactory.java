package flyWeight;

import Factory_method.RPG_Map_Generator.TileType;
import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

    private static final Map<TileType, TileGraphic> cache = new HashMap<>();

    public static TileGraphic getGraphic(TileType type) {
        return cache.computeIfAbsent(type, t -> {
            switch (t) {
                case ROAD: return new TileGraphic(Color.GRAY);
                case FOREST: return new TileGraphic(Color.GREEN);
                case WATER: return new TileGraphic(Color.BLUE);
                case SWAMP: return new TileGraphic(Color.DARKGREEN);
                case BUILDING: return new TileGraphic(Color.BROWN);
                default: return new TileGraphic(Color.BLACK);
            }
        });
    }
}
