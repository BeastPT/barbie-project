import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class End extends World
{
    private int score = 0;
    private GreenfootImage image;
    public End(int score, boolean win){    
        super(1200, 650, 1);
        this.score = score;        
        String imgUrl;
        if (win) {
            imgUrl = "Win_2.png";
        } else {
            imgUrl = "lose.jpg";
        }
        image = new GreenfootImage(imgUrl);
        setBackground(image);
        GreenfootImage loseImage = getBackground();
        loseImage.setColor(Color.BLUE);
        loseImage.setFont(new Font("Open Sans", 30));
        loseImage.drawString("Pontuação: " + score, 100,500);
    }
}
