import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Buttons
{
    //private GreenfootSound soundtrack = new GreenfootSound("Barbie.mp3");
   public Play()
    {  
        GreenfootImage imagem1= new GreenfootImage("PlayButton.png");
        setImage(imagem1);
        
    }
    public void act()
    {
        checkMouse();
        checkClick(new Maze());
    }
}
