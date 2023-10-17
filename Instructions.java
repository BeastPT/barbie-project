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
        GreenfootImage playButton = new GreenfootImage(200,200);
        Font adjustedFont = new Font(true,false,50);
        playButton.setFont(adjustedFont);
        playButton.setColor(Color.WHITE);
        playButton.drawString("Instructions",0,100);
        setImage(playButton);
    }
    public void act()
    {
        checkMouse();
        checkClick(new InstructionsWorld());
    }
}
