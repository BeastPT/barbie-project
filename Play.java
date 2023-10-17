import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Buttons
{
   public Play()
    {  
        GreenfootImage imagem1= new GreenfootImage("ButtonPlay.png");
        setImage(imagem1);
        
    }
    public void act()
    {
        checkMouse();
        checkClick(new Maze());
    }
}
