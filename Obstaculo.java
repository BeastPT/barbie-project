import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Obstaculo extends Actor
{
    private final int DELTA = 6;
    
    public Obstaculo(String imageUrl) {
        setImage(new GreenfootImage(imageUrl));
    }
    
    public void act() {
        move();
        outWorld();
    }
     //Verifica se o ator saiu do mundo ou colidiu com os foguetes e depois tem consequencias como diminuir a vida dos jogadores
    public void outWorld()
    {
        if(isTouching(Rocket.class)) { //verifica se colidiu com o KenRocket
            Rocket rocket = (Rocket) getOneIntersectingObject(Rocket.class);
            rocket.getHealthBar().LoseHealth();
            Greenfoot.playSound("death.mp3");
            getWorld().removeObject(this);
        }
        else if (getY() == 649) { //remove a galaxia assim que chegue ao fundo do mapa
            getWorld().removeObject(this); 
        }
    }
    
    private void move() {
        setLocation(getX(), getY()+DELTA);
    }
}

