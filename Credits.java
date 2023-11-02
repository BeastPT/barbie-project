import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Buttons
{
   public Credits()
    {  
        super();
        GreenfootImage playButton = new GreenfootImage(200,100);
        Font adjustedFont = new Font(true,false,50);
        playButton.setFont(adjustedFont);
        playButton.setColor(Color.WHITE);
        playButton.drawString("Credits",0,50);
        setImage(playButton);
    }
    public void act()
    {
        checkMouse();
        checkClick(new CreditsWorld());
    }
}
