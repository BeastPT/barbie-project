import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Actor
{
    private boolean mouseEmCima = false;
    private static int MAX_TRANS = 225;
    GreenfootSound som = new GreenfootSound("interface.mp3");
    
    public void checkMouse()
    {
        if(Greenfoot.mouseMoved(null))
        {
            mouseEmCima = Greenfoot.mouseMoved(this);
        }
        if(mouseEmCima)
        {
            adjTrans(MAX_TRANS/2);
        }
        else
        {
        adjTrans(MAX_TRANS);
        }
    }
    public void checkClick(World world)
    { 
        if(Greenfoot.mouseClicked(this))
        {
            som.play();
            Greenfoot.setWorld(world);
        }
    
    }
    public void adjTrans(int adjust)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
        setImage(tempImage);
    }
}
