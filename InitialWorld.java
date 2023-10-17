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
        addObject(play,600,250);


    }
}
