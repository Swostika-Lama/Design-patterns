package Factory_method.RPG_Map_Generator;

public abstract class Map {
    protected int breadth;
    protected int length;
    protected Tile[][] tiles;


    //creating tile
    public Map(int breadth, int length){
        this.breadth = breadth;
        this.length = length;
        tiles = new Tile [length][breadth];
    }

    protected abstract Tile createTile();
    //display the map
    public void display(){
        for(int i=0; i<length; i++){
            for(int j =0 ; j<breadth; j++){
                //create tile if not exist
                if(tiles[i][j] == null){
                    tiles[i][j] = createTile();
                }

                System.out.print(tiles[i][j].getCharacter()+ "");
            }
            System.out.println();
        }
    }

}
