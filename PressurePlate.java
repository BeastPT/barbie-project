import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PressurePlate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PressurePlate extends Objects
{
    /**
     * Act - do whatever the PressurePlate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private Door door;
    public PressurePlate(Door door){
        this.door = door;
    }
    
    public void act()
    {
        isPressured();
    }
    
    private void isPressured(){
        if (isTouching(Player.class)) { // abrir porta
            door.openDoor();
        } else if (!isTouching(Player.class)) { //fechar porta
            door.closeDoor();
        }
    }
}
