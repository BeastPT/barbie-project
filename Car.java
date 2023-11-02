import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Car extends Actor
{
    private String up;
    private String down;
    private String left;
    private String right;
    
    private int limiteXMin;
    private int limiteXMax;
    private int limiteYMin;
    private int limiteYMax;
    
    private final int DELTA = 5;
    
    // Construtor de Car para obter os dados necessarios desde o World
    public Car(String up, String down, String left, String right, int limiteXMin, int limiteXMax, int limiteYMin, int limiteYMax, String imageUrl) {
        setImage(new GreenfootImage(imageUrl));
        
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        
        int v = (int) getImage().getWidth()/2;
        
        this.limiteXMin = limiteXMin+v;
        this.limiteXMax = limiteXMax-v;
        this.limiteYMin = limiteYMin+v;
        this.limiteYMax = limiteYMax-v;
    }
    
    public void act() {
        move();
        touchingBall();
    }
    
    // Verifica se o Carro está a tocar em alguma bola e informa o World
    private void touchingBall() {
        if (isTouching(bola.class))
            ((Lobby) getWorld()).touchedBall((bola) getOneIntersectingObject(bola.class));
    }
    
    
    // Faz os movimentar e rodar consoante as teclas
    private void move() {
        int x = getX();
        int y = getY();
        
        if (Greenfoot.isKeyDown(up)) {
            setLocation(x, y-DELTA);
            setRotation(-90);
        }
        if (Greenfoot.isKeyDown(down)) {
            setLocation(x, y+DELTA);
            setRotation(90);
        }
        if (Greenfoot.isKeyDown(left)) {
            setLocation(x-DELTA, y);
            setRotation(180);
        }
        if (Greenfoot.isKeyDown(right)) {
            setLocation(x+DELTA, y);
            setRotation(0);
        }
                
        if (isOnLimit() || isTouching(Car.class))
            setLocation(x, y);
    }
    
    // Verifica se o Carro esta nos limites da Zona
    private boolean isOnLimit(){
        int x = getX();
        int y = getY();
        
        return (x<limiteXMin || x>limiteXMax || y<limiteYMin || y>limiteYMax);
    }
}
