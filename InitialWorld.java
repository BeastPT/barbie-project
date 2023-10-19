import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialWorld extends World
{
    private GreenfootSound soundtrack = new GreenfootSound("Barbie.mp3");
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
        GreenfootImage logo = new GreenfootImage("logoBarbieKeN.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic,getWidth()/2, 139);

        GreenfootImage barbieKen = new GreenfootImage("barbie&kenMenu.png");
        Picture barbieKenPic = new Picture(barbieKen);
        addObject(barbieKenPic,1000, 515);
        
        Play play = new Play();
        addObject(play,600,300);

        Exit exit = new Exit();
        addObject(exit,600,400);

        Instructions instructions = new Instructions();
        addObject(instructions,600,510);

    }

    public void started()
    {
       //soundtrack.play();
    }
    public void stopped()
    {
        soundtrack.stop();
    }

}

