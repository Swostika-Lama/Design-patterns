package Factory_method.RPG_Map_Generator;

import java.util.Random;

public class CityMap extends Map{
    private Random random = new Random();

    public CityMap(int breadth, int length){
        super(breadth, length);
    }

    @Override
    protected Tile createTile() {
        int choice= random.nextInt(3);

        switch (choice){
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default: return new RoadTile();
        }
    }

}
