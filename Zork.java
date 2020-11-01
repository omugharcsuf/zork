//enum Direction{NORTH, SOUTH, WEST, EAST};
enum ColItemType{HEALING, WEAPON, LIGHT, TREASURE};
enum ItemType{SWITCH, BOX};

class Zork{
    private int hp;
    public static int currentRow;
    public static int currentColumn;
    public int atk;
    public int def;
    public ColItem[] inventory=new ColItem[10];

    Zork(){
        this.hp=20;
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
        if(rooms[Zork.currentRow][Zork.currentColumn].wallList[wall]=true)return false;
        else{
            if(wall==0){
                Zork.currentRow++;
                return true;
            }
            else if(wall==1){
                Zork.currentColumn++;
                return true;
            }
            else if(wall==2){
                Zork.currentRow--;
                return true;
            }
            else if(wall==3){
                Zork.currentColumn--;
                return true;
            }
            else return false;
        }
    }

    public Map(int rows,int columns){
        String name;
        String desc;
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