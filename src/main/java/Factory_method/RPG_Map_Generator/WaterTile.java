package Factory_method.RPG_Map_Generator;

public class WaterTile extends Tile{
    public WaterTile(){
        super(TileType.WATER);
    }
    @Override
    public void getAction(){
        System.out.println("You are at water tile");
    }
}
