//enum Direction{NORTH, SOUTH, WEST, EAST};
enum ColItemType{HEALING, WEAPON, LIGHT, TREASURE};
enum ItemType{SWITCH, BOX}my

class Zork{
    private int hp;
    private Room currentRoom;
    public int atk;
    public int def;
    public ColItem[] inventory=new ColItem[10];

    Zork(Room currentRoom){
        this.hp=20;
        this.currentRoom=currentRoom;
        this.atk=10;
        this.def=10;
    }

    public static void main(String args[]){

    }
}

class ZorkObj{
    public String status;
    public ZorkObj(){}
}

abstract class Conditional{
    public String in;
    public abstract boolean confirm(Player);
}

public class PlayerHas extends Conditional{
    public String playerName;
    public boolean confirm(Player){return true;}
    public PlayerHas(){}
}

class Map extends ZorkObj{
    /*private String name;
    private String desc;*/
    public static final int NORTH=1;
    public static final int EAST=2;
    public static final int SOUTH=3;
    public static final int WEST=4;
    public static final int NO_DIRECTION=0;
    private static String[] walls={"North","East","South","West"};
    private Room[][] rooms;
    /*private Room northN;
    private Room southN;
    private Room westN;
    private Room eastN;
    //private Map<Direction,Room> borders;*/

    /*public Room getNorthN(){return northN;}
    public void setNorthN(Room room){northN=room;}
    public Room getSouthN(){return southN;}
    public void setSouthN(Room room){southN=room;}
    public Room getWestN(){return westN;}
    public void setWestN(Room room){westN=room;}
    public Room getEastN(){return eastN;}
    public void setEastN(Room room){eastN=room;}*/
    public boolean isClosed(int row,int column,int wall){
        return rooms[row][column].wallList[wall];
    }

    public Map(){}


}

class Room{
    private String name;
    private String desc;
    boolean[] wallList;
    Room(String name,String desc){
        this.name=name;
        this.desc=desc;
        wallList=new boolean[4];
        for(int i=0;i<4;i++){
            wallList[i]=true;
        }
    }
}

class ColItem extends ZorkObj{
    private String name;
    private ColItemType type;
    public ColItem(){}
}

class Item extends ZorkObj{
    private String name;
    private ItemType type;
    public Item(){}
}