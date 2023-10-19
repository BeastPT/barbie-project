import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionsWorld extends World
{

    /**
     * Constructor for objects of class InstructionsWorld.
     * 
     */
    public InstructionsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 650, 1); 
        prepare();
    }
    
    private void prepare()
    {  
        Menu menu = new Menu();
        addObject(menu,68,81);
        
        GreenfootImage logo = new GreenfootImage("HowToPlayLogo.png");
        Picture logoPic = new Picture(logo);
        addObject(logoPic,getWidth()/2, 69);
    
        GreenfootImage logo2 = new GreenfootImage("Barbie&ken2.png");
        Picture logoPic2 = new Picture(logo2);
        addObject(logoPic2,1050, 270);
        
        GreenfootImage logo3 = new GreenfootImage("Barbielogo.png");
        Picture logoPic3 = new Picture(logo3);
        addObject(logoPic3,150, 270);
    }
}
