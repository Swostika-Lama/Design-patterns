package Factory_method.RPG_Map_Generator;

public class Game {
    public static Map createMap(String tileType, int breadth, int length){
        if (tileType.equalsIgnoreCase("city")) {
            return new CityMap(breadth, length);
        } else if (tileType.equalsIgnoreCase("wilderness")){
            return new WildernessMap(breadth, length);
        } else {
            throw new IllegalArgumentException("unknown map type" + tileType);
        }
    }

    public static void main(String[] args){
        Map map = createMap("city", 5,12);
        map.display();

        System.out.println("------------");

        Map map2 = createMap("wilderness", 4, 9);
        map2.display();
    }
}

