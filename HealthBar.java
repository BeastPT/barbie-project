import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{
    private Rocket rocket;
    
    private int health = 5  ;
    private int healthWidth=100;
    private int healthHeight= 10;
    private int PointPerHealth = (int) healthWidth/health;
    
    private Color firstColor;
    private Color secondColor;
    
    public HealthBar(Color firstColor, Color secondColor) {//construtor da classe
        this.firstColor = firstColor;
        this.secondColor = secondColor;
        update(); // atualiza barra de vida
    }
    
    private void HealthZero() {// se a vida for 0, perde o jogo
        if(health == 0)
            ((SpaceWorld) getWorld()).loseGame();
    }
    public void act() {
        update();
        HealthZero();
    }
    private void update() {// atualiza a barra de vida no jogo e criacao da mesma
        setImage(new GreenfootImage(healthWidth + 3,healthHeight+3)); // Cria uma nova imagem para a barra de vida
        GreenfootImage myImage = getImage();
        myImage.setColor(firstColor);
        myImage.drawRect(0, 0 , healthWidth + 1, healthHeight + 1);// Desenha a moldura da barra 
        myImage.setColor(secondColor);
        myImage.fillRect(1,1,health*PointPerHealth, healthHeight);
    }
    public void LoseHealth() { // diminui a quantidade de vida
        health--;
    }
    public void move(int x, int y) { //movimenta a barra de vida
        setLocation(x, y+90);
    }
}
