import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze extends World
{

    /**
     * Constructor for objects of class Maze.
     * 
     */
    public Maze() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 650, 1);
        prepare();
    }
    
    private void prepare() {
        boolean[][] walls = {
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
        };
        
        for (int i = 1; i < 14; i++) { //linhas
          for (int j = 0; j < 24; j++) { // colunas
              if (walls[i-1][j])
                  addObject(new WallBlock(), j*50+25, i*50-25);
            }
        }
    }
}
