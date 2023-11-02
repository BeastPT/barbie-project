import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Buttons
{   
    
   public Menu()
    {
        super();
        GreenfootImage imagem4= new GreenfootImage("BackToMenu.png");
        setImage(imagem4);
        
    }
    public void act()
    {
        checkMouse();
        checkClick(new InitialWorld());
    }
}
