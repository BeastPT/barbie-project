import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Objects
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean open = false;
    private boolean opening = false;
    private boolean closing = false;
    private GreenfootImage image;
    private final int DELTA_TRANSPARENCY = 5; // multiplos de 100
    
    public Door() {
        super();
        image = getImage();
    }
    
    public void act(){
        removeTransparency();
        addTransparency();
    }
    
    public void openDoor(){
        if (!open && !opening) { // abrir porta
            opening = true;
            closing = false;
        }
    }
    
    public void closeDoor(){
        if (open || opening) { // fechar porta
            open = false;
            opening = false;
            closing = true;
        }
    }
    
    private void removeTransparency() {
        if (opening) {
            int transparency = image.getTransparency();
            if (transparency > 0+DELTA_TRANSPARENCY)
                image.setTransparency(transparency-DELTA_TRANSPARENCY);
            else {
                opening = false;
                open = true;
            }
        }
    };
    
    private void addTransparency() {
        if (closing) {
            int transparency = image.getTransparency();
            if (transparency < 255)
                image.setTransparency(transparency+DELTA_TRANSPARENCY);
            else {
                closing = false;
            }
        }
    };
}
