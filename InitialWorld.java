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
        GreenfootImage image = new GreenfootImage("background.menu.jpg");
        
        GreenfootImage logo = new GreenfootImage("logoBarbieKeN.png");
        image.drawImage(logo, getWidth()/2-logo.getWidth()/2, 10);
        
        GreenfootImage barbieKen = new GreenfootImage("barbie&kenMenu.png");
        image.drawImage(barbieKen, 1000-barbieKen.getWidth()/2, 515-barbieKen.getHeight()/2);
        
        setBackground(image);
        
        Play play = new Play();
        addObject(play,600,300);

        Exit exit = new Exit();
        addObject(exit,600,400);

        Instructions instructions = new Instructions();
        addObject(instructions,600,510);

    }
}

