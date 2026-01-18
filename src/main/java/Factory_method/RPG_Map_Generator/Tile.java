package Factory_method.RPG_Map_Generator;

public abstract class Tile {
    protected TileType tileType;

    public Tile(TileType tileType){
        this.tileType = tileType;
    }
    public char getCharacter(){
        return tileType.getCharacter();
    }
    public String getType(){
        return tileType.getType();
    }
    public void getAction(){
//        for later implementation

    }
}
