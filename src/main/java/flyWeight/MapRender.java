package flyWeight;

import Factory_method.RPG_Map_Generator.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MapRender{

    private final int tileSize = 32;

    public void render(Canvas canvas, Tile[][] tiles) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {

                Tile tile = tiles[y][x];
                TileGraphic graphic = TileGraphicFactory.getGraphic(tile.getTileType());

                gc.setFill(graphic.getColor());
                gc.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }

}
