import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TurretDelay extends NotCollisionTurret
{
    private int imageWidth = 42;
    private int imageHeight = 7;
    private final int DELAY = Turret.RECHARGE_DELAY;
    private double widthPerDelay = (double) imageWidth/Turret.RECHARGE_DELAY; //WIDTH_DELAY
    private Turret turret;
    private GreenfootImage currentImage;
    
    private boolean isFull = true;
    
    private SimpleTimer timerReload;
    
    // Atribui ao TurretDelay a sua Turret
    public TurretDelay(Turret turret) {
        this.turret = turret;
        this.timerReload = turret.getReloadTimer();
    }
    
    protected void addedToWorld(World world){
        //Adiciona a barra do Delay
        setImage(new GreenfootImage(imageWidth + 3, imageHeight+3));
        currentImage = getImage();
        currentImage.setColor(Color.WHITE);
        currentImage.drawRect(0, 0 , imageWidth + 1, imageHeight + 1);
        currentImage.setColor(Color.GRAY);
        currentImage.fillRect(1,1, imageWidth, imageHeight);
        currentImage.setColor(Color.WHITE);
    }
    
    public void act()
    {
        // Se a Turret tiver a recarregar
        if (timerReload.millisElapsed() < DELAY) {
            isFull = false;
            turretDelayAnimation(); // Criar animação da Barra
        } else if (!isFull) {
            currentImage.setColor(Color.GRAY);
            currentImage.fillRect(1,1, imageWidth, imageHeight);
            currentImage.setColor(Color.WHITE);
            isFull = true;
        }
           
    }
    
    // Animação da barra
    private void turretDelayAnimation() {
        currentImage.fillRect(1, 1, (int) (widthPerDelay*(DELAY - (DELAY-timerReload.millisElapsed()))), imageHeight);
    } 
}
