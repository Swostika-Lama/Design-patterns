package Factory_method.RPG_Map_Generator;

public class RoadTile extends Tile{
    public RoadTile(){
        super(TileType.ROAD);
    }
    @Override
    public void getAction(){
        System.out.println("You are at road tile.");
    }
}
