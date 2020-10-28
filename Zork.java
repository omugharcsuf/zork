import java.util.*;

enum Direction{NORTH, SOUTH, WEST, EAST};
enum ColItemType{HEALING, WEAPON, LIGHT, TREASURE};

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
    private Map<Direction,Room> borders;
    public Room(){this.name=""; this.desc="";}
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