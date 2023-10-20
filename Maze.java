import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Maze extends World
{
    
    private int mazeMapVersion;
    static final int MAP_DOORS = 2;
    
    public Maze() {    
        super(1200, 650, 1);
        mazeMapVersion = 0;//Greenfoot.getRandomNumber(1);
        prepare();
    }
    
    private void prepare() {
        setupMazeWalls();
        setupMazeDoors();
        setupPlayers();
    }
    
    private void setupPlayers(){
        Player player1 = new Player("w", "s", "a", "d", "BarbieWalking1.png");
        addObject(player1, 25, 25);
        
        Player player2 = new Player("up", "down", "left", "right", "KenWalking1.png");
        addObject(player2, 50*3+25, 50*12+25);
    }
    
    private void setupMazeWalls() {
        boolean[][][] walls = {{
            {false, false, false, false,false, false, false, false,true, false, false, false,true, false, false, false,false, false, false, true,true, false, false, false},
            {true, true, true, true,false, true, true, true,true, false, true, false,true, true, false, true,false, true, true, true,true, true, false, false},
            {false, false, false, false,false, false, false, true,false, false, true, false,false, true, false, true,false, true, false, false,false, true, true, false},
            {false, true, true, true,true, false, true, true,false, true, true, true,false, true, true, true,false, true, false, true,false, false, true, false},
            {false, true, false, false,false, false, false, false,false, true, false, true,false, false, false, false,false, false, false, true,false, false, false, false},
            {false, true, true, true,true, true, true, true,true, true, false, true,true, true, true, true,true, true, true, true,true, false, true, true},
            {false, false, false, false,true, false, false, false,false, false, false, true,false, true, true, true,true, true, true, true,false, false, true, false},
            {true, true, true, true,true, false, true, true,true, true, true, true,false, false, false, false,false, false, false, true,true, false, true, false},
            {false, false, false, false,true, false, false, false,true, false, true, false,false, true, false, true,false, true, false, false, true, false, true, false},
            {false, true, true, true,true, false, true, false,true, false, true, false,true, true, false, true,false, true, false, false,false, false, false, false},
            {false, false, false, false,false, false, true, false,true, false, true, false,true, true, true, true,false, true, true, true,true, true, false, false},
            {false, true, true, true,true, false, true, false,true, false, true, false,true, false, false, true,false, false, false, false,true, false, false, false},
            {false, false, false, false,true, false, true, false,false, false, false, false,false, false, false, false,true, false, false, false,true, false, false, false},
        },
        {
            {false,true, true,true,true, true, true,true,true, true, true, true,false, true, false, false,false, false, false, true,false, true, false, false},
            {false, false, false, false,false, false, false, true,false, false, false, true,false, false, false, false,true, true, false, true,false, true, false, false},
            {false, true, true, true,true, true, false, true,false,true, false, true,false, true, true, true,false, false, false, true,false, true,false, false},
            {false, false, false, false,true, true, false, false,false, true, false, false,false, false, false, true,false, true, true, false,false, true, false, false},
            {true, true, true, false,true, true, false, true,false, false, true, true,true, false, true, true,false, false, false, false,true, false, false, true},
            {false, false, true, true,true, false, true, true,true, true, true, false,true, false, false, false,true, true, true, true,true, false, false, true},
            {false, true, true, false,true, false, false, false,false, false, true, false,true, true, true, false,false, false, false, false,true, false, true, true},
            {false, false, false, false,false, false, true, false,true, false, false,false,false, false, false,true,true, true, true, false,false, false, true, false},
            {false, true, true, true,true, true, false, false,false,true, true, true,true, true, false, false,true, false, true, true, true, false, false, false},
            {false, true, true, false,false, false, false, true,false, true, true, false,false, false, true, false,false, false, false, false,true, true, true, false},
            {false, false, true, false,true, false, false, true,false, false, true, false,false, true, false, false,true, false, true, false,true, false, false, false},
            {true, false, false, false,true, true, false, true,false, false, true, false,true, false, false, true,true, false, true, true,false,true, false, false},
            {true, true, true, false,true, true, false, true,false, false, false, false,true, false, false, false,false, false, false, false,false, false, false, false},
        },
        {
            {false,true, false,false,true, false, false,false,false, false,false,false,true, true,false, false,false, false, false, true,true, true, false, false},
            {false, true, false, true,true, false, true, true,true,true,true,false,false, false, false, true,true, true, true, true,false, false, false, false},
            {false, false,false, false,true,false,true, false,false,false, false, true,true, true, false, true,false, false, false, true,true, false,false, true},
            {false, true, false, false,false,false, true, false,false, true, false, false,false, true, false, true,true, false, true, true,true, false, true, true},
            {true, true, true, false,true, true, false, false,true, true, true, true,false, true, false,true,false, false, false, true,false, false, false, false},
            {false, true, true, false,true,false,false, true, true, true,false, true, false, true,false, true, true, true,false, true, false, true,true, false},
            {false, false,false, false,false, false, true, false,false, false, false, true,false, true, false, false,false, false, false, true,false, false, true, false},
            {true, true, true, true,true, true, false, false,false, true, false,true,false, false,true,true,true, true,false, false,true, false, true, false},
            {false, false, false, false,false, false, true, true,false,true, false,false,true, false, false, false,false, false, true, false, true, false, true, false},
            {false, false, true, false,true, true, false, true,false, false, true, false,false, true, true, true,true, false, false, true,true, false, true, false},
            {true, false, true, false,false, false, false, true,false, false, false, true,false, false, true, false,false, true, false, false,false, false, true, false},
            {true, false,true, false,true, false, false, false,false, true, false, true,true, false, false, false,true, false, true, true,true,true, true, false},
            {false,false, true,false,true, true, true, true,true, false, false, false,true, false, true, false,false, false, false, false,false, false, false, false},
        }};
        
        for (int i = 1; i < 14; i++) { //linhas
          for (int j = 0; j < 24; j++) { // colunas
               if (walls[mazeMapVersion][i-1][j])
                  addObject(new WallBlock(), j*50+25, i*50-25);
            }
        }
    }
    
    private void setupMazeDoors() {
        //[mapVersion][DoorNumber][x, y]
        int[][][] mapsDoors = {
            {{15, 5}, {22, 6}},
            {{5, 1}, {13, 2}},
            {{5, 1}, {13, 2}}
        };
        
        int[][][] pressurePlates = {
            {{14, 12}, {18, 1}},
            {{5, 1}, {13, 2}},
            {{5, 1}, {13, 2}}
        };
        
        for (int i=0; i<2; i++) {
            int[] doorLoc = mapsDoors[mazeMapVersion][i];
            int[] pressureLoc = pressurePlates[mazeMapVersion][i];
            Door door = new Door();
            addObject(door, doorLoc[0]*50-25, doorLoc[1]*50-25);
            addObject(new PressurePlate(door), pressureLoc[0]*50-25, pressureLoc[1]*50-25);
        };        
    }
}
