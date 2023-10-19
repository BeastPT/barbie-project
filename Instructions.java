import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Buttons
{
    public Instructions()
    {  
        GreenfootImage imagem3= new GreenfootImage("InstrutionsButton.png");
        setImage(imagem3);
    }
    public void act()
    {
        checkMouse();
        checkClick(new InstructionsWorld());
    }
}
