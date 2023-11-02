import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Star extends Actor
{
    private int delta;
    private String imageUrl;
    
    public Star(int type) {
        switch(type) {
            case 1:
                imageUrl = "star.png";
                delta = 7;
                break;
            case 2:
                imageUrl = "Star2.png";
                delta = 4;
                break;
            case 3:
                delta = 3;
                imageUrl = "Star3.png";
                break;
            default:
                imageUrl = "star.png";
                delta = 7;
                break;
        }
        setImage(new GreenfootImage(imageUrl));
    }
    
    public void act(){
        move();
        outWorld(); //Chama o método que está em Stars
    }
    
    private void move(){ //movimentam-se automaticamente para baixo
        setLocation(getX(), getY()+delta);    
    }
    
    public void outWorld() {// se chegar ao fundo do mundo, são removidas
        if (getY() >= 649)
        {
            getWorld().removeObject(this);
        }
    }
}
