import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rocket extends Actor
{
    SimpleTimer timingToShot = new SimpleTimer(); // cria um instancia da classe SimpleTimer para obter um temporizador para controlar o intervalo entre tiros
    
    private String up;
    private String down;
    private String left;
    private String right;
    private String shot;
    
    private HealthBar healthBar;
    
    private final int DELTA = 4;
    private final int BULLET_DELAY = 400;
    
    public Rocket(String up, String down, String left, String right, String shot, String imageUrl, HealthBar healthBar) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.shot = shot;
        
        this.healthBar = healthBar;
        
        setImage(new GreenfootImage(imageUrl));
    }
    
    public void act() {
        move();
    }
    
    private void move() {//movimenta o Rocket
        if (Greenfoot.isKeyDown(right))
            setLocation(getX()+DELTA, getY());
        if (Greenfoot.isKeyDown(up))
            setLocation(getX(),getY()-DELTA);
        if (Greenfoot.isKeyDown(down)&& getY() < 560)
            setLocation(getX(), getY()+DELTA);
        if (Greenfoot.isKeyDown(left))
            setLocation(getX()-DELTA,getY());
        if (Greenfoot.isKeyDown(shot) && timingToShot.millisElapsed() > BULLET_DELAY) { //dispara se o intervalo de tiros nao for menor que 400 milissegundos.
            getWorld().addObject(new Bullet(), getX(), getY()); // Adiciona um objeto da classe Bullet ao mundo nas coordenadas da nave
            Greenfoot.playSound("tiro.mp3");//Apos disparar da o som tiro.mp3
            timingToShot.mark(); // Marca o tempo do último tiro
        }
        
        healthBar.move(getX(), getY());
    }
    
    public HealthBar getHealthBar(){
        return healthBar;
    }
}