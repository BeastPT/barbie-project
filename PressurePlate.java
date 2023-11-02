import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PressurePlate extends Actor
{
    
    private Door door; //Guarda a Porta a que a pressure plate é responsável
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
