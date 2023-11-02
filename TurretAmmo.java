import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
public class TurretAmmo extends NotCollisionTurret
{
    private final int AMMO_SPEED = 3; // Não reduzir
    private int locX;
    private int locY;
    private double rX;
    private double rY;
    private double d;
    private int counter;
    private Maze world;

    public TurretAmmo(int x, int y){
        // Recebe no construtor a localização da boca da Turret
        locX = x;
        locY = y;
    }
    
    public void act()
    {
        if (counter++ == 1) { // Cria o delay para a Bala andar
            move();
            counter = 0;
        }
    }
    
    protected void addedToWorld(World world){ // Calcula a direção a mover em cada act
        this.world = (Maze) world;
        int delX = locX-getX();
        int delY = locY-getY();
        d = Math.hypot(delX, delY);
        rX = delX/d;
        rY = delY/d;
    }
    
    // Move a bala
    private void move() {
        int moveX = (int) (rX*AMMO_SPEED);
        int moveY = (int) (rY*AMMO_SPEED);
        setLocation(getX()+moveX, getY()+moveY);
        checkExplode();
    }

    // Verifica se a bala deve explodir
    private void checkExplode() {
        Actor object = getOneIntersectingObject(null);
        if (isAtEdge() || (object != null && !(object instanceof NotCollisionTurret)))
            explode();
    }
    
    // A bala explode
    private void explode() {
        world.explodeAmoTurret(getX(), getY()); // Criar animação da explosao
        if (isTouching(Player.class))
            world.removeLife(); // Remove vida aos jogadores
        world.removeObject(this); // Apaga a bala
    }
}
