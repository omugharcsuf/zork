import java.util.*;

//enum Direction{NORTH, SOUTH, WEST, EAST};
enum ColItemType{HEALING, WEAPON, LIGHT, TREASURE};
enum ItemType{SWITCH, BOX}

class Zork{}

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

class Room extends ZorkObj{
    private String name;
    private String desc;
    private Room northN;
    private Room southN;
    private Room westN;
    private Room eastN;
    //private Map<Direction,Room> borders;
    public Room(){this.name=""; this.desc="";}
    public Room getNorthN(){return northN;}
    public void setNorthN(Room room){northN=room;}
    public Room getSouthN(){return southN;}
    public void setSouthN(Room room){southN=room;}
    public Room getWestN(){return westN;}
    public void setWestN(Room room){westN=room;}
    public Room getEastN(){return eastN;}
    public void setEastN(Room room){eastN=room;}
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

class Player{}