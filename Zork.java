import java.util.*;

enum Direction{NORTH, SOUTH, WEST, EAST;}

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
    public boolean confirm(Player){}
    public PlayerHas(){this("");}
}

public class Room extends ZorkObj{
    private String name;
    private String desc;
    private Map<Direction,Room> borders;
    public Room(){this.name=""; this.desc="";}
}

class Player{}