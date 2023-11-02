import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    
    private String up;
    private String down;
    private String left;
    private String right;
    private final int DELTA = 2;
    
    // Atribui as teclas e a imagem ao jogador
    public Player(String up, String down, String left, String right, String imageUrl){
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        
        setImage(new GreenfootImage(imageUrl));
    }
    
    public void act()
    {
        move();
    }
    
    private void move() {
        int x = getX();
        int y = getY();
        
        // Verifica as teclas do Jogador e movimenta o player
        if (Greenfoot.isKeyDown(up))
            setLocation(x, y-DELTA);
        else if (Greenfoot.isKeyDown(down))
            setLocation(x, y+DELTA);
        else if (Greenfoot.isKeyDown(left))
            setLocation(x-DELTA, y);
        else if (Greenfoot.isKeyDown(right))
            setLocation(x+DELTA, y);
        
        // Verifica se tem algum objeto a bloquear
        if (isTouchingBlockers())
            setLocation(x, y);
    }
    
    // Retorna se a porta está visivel (fechada) ou invisivel (aberta)
    private boolean isTouchingDoor() {
        if (isTouching(Door.class)) {
            Door door = (Door) getOneIntersectingObject(Door.class);
            return !door.open;
        } else {
            return false;
        }
    }
    
    // Retorna se o player está a tocar em algum objeto bloqueado
    private boolean isTouchingBlockers() {
        return isTouching(WallBlock.class) || isTouchingDoor();
    }
}
