import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialWorld extends World
{

    /**
     * Constructor for objects of class InitialWorld.
     * 
     */
    public InitialWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 650, 1); 
        prepare();
    }
    
    private void prepare()
    {
        GreenfootImage logo = new GreenfootImage("Barbielogo.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic,getWidth()/2, 100);

        Play play = new Play();
        addObject(play,606,282);
        Instructions instructions = new Instructions();
        addObject(instructions,579,350);
        instructions.setLocation(564,410);
        Credits credits = new Credits();
        addObject(credits,564,410);
        Exit exit = new Exit();
        addObject(exit,559,467);
        instructions.setLocation(584,342);
        instructions.setLocation(584,342);
        play.setLocation(528,282);
    }
}
