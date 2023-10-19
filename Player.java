import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    private String up;
    private String down;
    private String left;
    private String right;
    private final int DELTA = 2;
    
    public Player(String up, String down, String left, String right){
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    
    public void act()
    {
        move();
    }
    
    private void move() {
        int x = getX();
        int y = getY();
        
        if (Greenfoot.isKeyDown(up))
            setLocation(x, y-DELTA);
        else if (Greenfoot.isKeyDown(down))
            setLocation(x, y+DELTA);
        else if (Greenfoot.isKeyDown(left))
            setLocation(x-DELTA, y);
        else if (Greenfoot.isKeyDown(right))
            setLocation(x+DELTA, y);
            
        if (isTouchingBlockers())
            setLocation(x, y);
    }
    
    private boolean isTouchingDoor() {
        if (isTouching(Door.class)) {
            Door door = (Door) getOneIntersectingObject(Door.class);
            return !door.open;
        } else {
            return false;
        }
    }
    
    private boolean isTouchingBlockers() {
        return isTouching(WallBlock.class) || isTouchingDoor();
    }
}
