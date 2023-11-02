import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Bullet extends Actor // definir a clasee Bullet
{
    public void act()
    {
        MoveBullet(); // chamamos o método MoveBullet()
        killBullets(); // chamamaos o método killBullets()
    }
    public void MoveBullet() // movimenta a bola para cima 10
    {
        setLocation(getX(), getY() - 10);
    }
    public void killBullets() // verifica se existe colisao entre as balas e os obstaculos
    {
        Actor Obstaculos = getOneIntersectingObject(Obstaculo.class);
        if (Obstaculos != null) {
          getWorld().removeObject(Obstaculos);
          Greenfoot.playSound("Contact.mp3");
          Counter counter = (Counter) getWorld().getObjects(Counter.class).get(0);
          counter.add(1);
          getWorld().removeObject(this);
        }
        else if (getY() <= 0) // se a bala atingir o topo é removida
            getWorld().removeObject(this);
    }
}
