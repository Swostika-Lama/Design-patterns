package Factory_method.RPG_Map_Generator;

public enum TileType {
    SWAMP('s', "swamp"),
    WATER('w', "water"),
    ROAD('r', "road"),
    FOREST('f', "forest"),
    BUILDING('b', "building");

    private char character;
    private String type;

    TileType(char character, String type){
        this.character = character;
        this.type = type;
    }

    public char getCharacter() {
        return character;
    }

    public String getType() {
        return type;
    }
}
