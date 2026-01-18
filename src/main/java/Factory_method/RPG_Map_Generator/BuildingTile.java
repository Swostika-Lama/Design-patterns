package Factory_method.RPG_Map_Generator;

public class BuildingTile extends Tile{
    public BuildingTile(){
        super(TileType.BUILDING);
    }
    @Override
    public void getAction(){
        System.out.println("You are at the building");
    }
}
