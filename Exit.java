import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Buttons
{
    public Exit()
    {  
        GreenfootImage imagem2= new GreenfootImage("PauseButton.png");
        setImage(imagem2);
    }
    public void act()
    {
        checkMouse();
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.stop();
        }
    }
}
