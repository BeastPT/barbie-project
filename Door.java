import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Door extends Actor
{
    public boolean open = false;
    private boolean opening = false;
    private boolean closing = false;
    private GreenfootImage image;
    private final int DELTA_TRANSPARENCY = 5; // multiplos de 255
    
    public Door() {
        image = getImage();
    }
    
    public void act(){
        removeTransparency();
        addTransparency();
    }
    
    // Cria a função publica para abrir a porta (chamada pela class PressurePlate)
    // Ideia de Event & Listener
    public void openDoor(){
        if (!open && !opening) { // verifica se a porta não esta aberta ou não esta abrindo
            opening = true;
            closing = false;
        }
    }
    
    // Cria a função publica para fechar a porta (chamada pela class PressurePlate)
    public void closeDoor(){
        if (open || opening) { // Verifica se a porta esta aberta ou esta abrindo
            open = false;
            opening = false;
            closing = true;
        }
    }
    
    // Abre a porta colocando a imagem como transparente
    private void removeTransparency() {
        if (opening) { // verifica se a porta deve ser aberta
            int transparency = image.getTransparency();
            if (transparency > 0)
                image.setTransparency(transparency-DELTA_TRANSPARENCY);
            else {
                opening = false;
                open = true;
            }
        }
    };
    
    // Fecha a porta colocando a imagem como opaca
    private void addTransparency() {
        if (closing) { // Verifica se a porta deve ser fechada
            int transparency = image.getTransparency();
            if (transparency < 255)
                image.setTransparency(transparency+DELTA_TRANSPARENCY);
            else {
                closing = false;
            }
        }
    };
}
