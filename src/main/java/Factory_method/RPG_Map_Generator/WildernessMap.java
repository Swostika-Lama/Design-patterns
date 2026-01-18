package Factory_method.RPG_Map_Generator;

import java.util.Random;

public class WildernessMap extends Map{
    private Random random = new Random();

    public WildernessMap(int breadth, int length){
        super(breadth, length);
    }

    @Override
    protected Tile createTile(){
        int choice = random.nextInt(3);

        switch (choice){
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default: return new SwampTile();
        }

    }
}
