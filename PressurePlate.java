import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PressurePlate extends Objects
{
    
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
