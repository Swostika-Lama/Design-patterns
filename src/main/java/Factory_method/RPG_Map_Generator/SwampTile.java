package Factory_method.RPG_Map_Generator;

public class SwampTile extends Tile{
    public SwampTile(){
        super(TileType.SWAMP);
    }
    @Override
    public void getAction(){
        System.out.println("You are at swamp tile");
    }
}
