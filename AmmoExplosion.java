import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AmmoExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmmoExplosion extends NotCollisionTurret
{
    /**
     * Act - do whatever the AmmoExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private final static int IMAGE_COUNT = 20;
    private static GreenfootImage[] images;
    private int imgIndex;
    
    // Criação das Imagens para a Utilização na Classe
    static {
        images = new GreenfootImage[IMAGE_COUNT];
        for (int i = 0; i < IMAGE_COUNT; i++) {
            images[i] = new GreenfootImage("AmmoExplosion.png");
            int scale = 5*i + 5;
            images[i].scale(scale, scale);
        }
    }
    
    public AmmoExplosion() {
        setImage(images[0]); // Corrigir pequeno bug da imagem aparecer sem tar scaled
    }
    
    public void act()
    {
        explosionAnimation();
    }
    
    // Vai alternando pelas imagens definidas na classe até chegar a última e o objeto e removido
    private void explosionAnimation(){
        if (++imgIndex < images.length)
            setImage(images[imgIndex]);
        else
            getWorld().removeObject(this);
    }
}
