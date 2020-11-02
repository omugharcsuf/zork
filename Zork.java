import java.io.PrintStream;

//enum Direction{NORTH, SOUTH, WEST, EAST};
enum ColItemType{HEALING, WEAPON, LIGHT, TREASURE};
enum ItemType{SWITCH, BOX};

class Zork{
    private int hp;
    public static int currentRow;
    public static int currentColumn;
    public static int numMoves;
    public int atk;
    public int def;
    public ColItem[] inventory=new ColItem[10];

    Zork(){
        this.hp=20;
        this.atk=10;
        this.def=10;
    }

    public static void main(String args[]){
        Zork player=new Zork();
        Map map=new Map(6,4);
        //fill up room details
        Map.rooms[5][1].setName("SOUTH OF HOUSE");
        Map.rooms[5][1].setDesc("There is an open field south of a white house, with an open front door.\nThere is a small mailbox here.\nA rubber mat saying \"Welcome to Zork!\" lies by the door.");
        Map.rooms[4][1].setName("ENTRY HALLWAY");
        Map.rooms[4][1].setDesc("There is a short hallway at the entrance to the house that leads to the living room.\nThere is an empty coat rack on the east wall and a locked door on the west wall.");
        Map.rooms[3][1].setName("LIVING ROOM");
        Map.rooms[3][1].setDesc("There is an old TV mounted on the wall and a few chairs organized in a semicircle.");
        Map.rooms[2][1].setName("EXIT HALLWAY");
        Map.rooms[2][1].setDesc("There is a short hallway leading to the backyard door.\nOn the east wall is an entry to the dining room.");
        Map.rooms[3][0].setName("CLOSET");
        Map.rooms[3][0].setDesc("A very small closet that you can barely fit inside.");
        Map.rooms[3][2].setName("KITCHEN");
        Map.rooms[3][2].setDesc("A kitchen with a wide assortment of devices, most of which don't seem to be of any use to you.");
        Map.rooms[3][3].setName("UPSTAIRS");
        Map.rooms[3][3].setDesc("A large bedroom with a noticeable sum of treasure in the corner of the room.");
        Map.rooms[2][2].setName("DINING ROOM");
        Map.rooms[2][2].setDesc("There is a rectangular table with ornate chairs surrounding it.\nThe wallpaper is peeling off and the chandelier looks like it could fall at any moment.");
        Map.rooms[2][3].setName("STAIRCASE");
        Map.rooms[2][3].setDesc("A narrow staircase connecting the dining room to the upstairs bedroom.");
        Map.rooms[1][1].setName("BACKYARD");
        Map.rooms[1][1].setDesc("A small grassy area with tall walls on the east and west sides and a short fence on the north side.\nYou could probably jump this fence.");
        Map.rooms[0][1].setName("FOREST");
        Map.rooms[0][1].setDesc("You find yourself in a dim forest.\nThere are trees in every direction except the way you came from and you can barely see because of how dark it is.");
    }
}

class ZorkObj{
    public String status;
    public ZorkObj(){}
}

abstract class Conditional{
    public String in;
    public abstract boolean confirm(Zork player);
}

class PlayerHas extends Conditional{
    public String playerName;
    public boolean confirm(Zork player){return true;}
    public PlayerHas(){}
}

class Map extends ZorkObj{
    /*private String name;
    private String desc;*/
    public static final int NORTH=0;
    public static final int EAST=1;
    public static final int SOUTH=2;
    public static final int WEST=3;
    public static final int NO_DIRECTION=4;
    private static String[] walls={"North","East","South","West"};
    public static Room[][] rooms;
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
    public boolean isWall(int row,int column,int wall){
        return rooms[row][column].wallList[wall];
    }

    public void setWall(int row,int column,int wall){
        rooms[row][column].wallList[wall]=true;
    }

    public void setDoor(int row,int column,int wall){
        rooms[row][column].wallList[wall]=false;
    }

    public boolean exitRoom(int wall){
        if(rooms[Zork.currentRow][Zork.currentColumn].wallList[wall]==true)return false;
        else{
            if(wall==0){
                Zork.currentRow++;
                Zork.numMoves++;
                return true;
            }
            else if(wall==1){
                Zork.currentColumn++;
                Zork.numMoves++;
                return true;
            }
            else if(wall==2){
                Zork.currentRow--;
                Zork.numMoves++;
                return true;
            }
            else if(wall==3){
                Zork.currentColumn--;
                Zork.numMoves++;
                return true;
            }
            else return false;
        }
    }

    public Map(int rows,int columns){
        String name=null;
        String desc=null;
        rooms=new Room[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                rooms[i][j]=new Room(name,desc);
            }
        }
    }


}

class Room{
    private String name;
    private String desc;
    boolean[] wallList;
    Room(){
        name=null;
        desc=null;
        wallList=new boolean[4];
        for(int i=0;i<4;i++){
            wallList[i]=true;
        }
    }
    Room(String name,String desc){
        this.name=name;
        this.desc=desc;
        wallList=new boolean[4];
        for(int i=0;i<4;i++){
            wallList[i]=true;
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }

    public void printRoomDesc(int row,int column){
        System.out.println("You are now in the "+Map.rooms[row][column].name+".");
        System.out.println(Map.rooms[row][column].desc);
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