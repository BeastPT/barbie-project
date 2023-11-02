import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class SpaceWorld extends World
{
    private int Timer =3000; 
    private TimerDisplay timeDisplay =new TimerDisplay();
    Counter scoreCounter  = new Counter();
    private int score = 0;
    public SpaceWorld(int score){    
        super(1200, 650, 1); 
        prepare();
        this.score = score;
    }
    
    public void act(){
        if(Greenfoot.getRandomNumber(100)<1) //Chance de criar das galaxias
            randomObstacle("galaxy.png");
        if(Greenfoot.getRandomNumber(100)<1) // Chance de criar das rochas
            randomObstacle("meteoro.png");
        if (Greenfoot.getRandomNumber(100)<100) //Chance de criar estrelas 1
            randomStar(1);
        if (Greenfoot.getRandomNumber(100)<100) //Chance de criar das estrelas2
            randomStar(2);
        if (Greenfoot.getRandomNumber(100)<100) //chance de criar estrelas 3
            randomStar(3);
        
        if (Timer > 0){
            Timer--;
            updateDisplay();// Atualiza a exibição do temporizador.
        }
        else// se o tempo chegar a 0 o jogo termina
            loseGame();
    }
    
    public void updateDisplay(){
        GreenfootImage backgroundImage = new GreenfootImage(getWidth(), getHeight());
        backgroundImage.setColor(Color.BLACK);
        backgroundImage.fill();
        backgroundImage.setColor(Color.MAGENTA);
        int tamanhoDaFonte = 30;
        Font fonte = new Font("Open Sans", tamanhoDaFonte);
        backgroundImage.setFont(fonte);
        backgroundImage.drawString("Time: " + Timer, 1000, 60);
        setBackground(backgroundImage);
    }
    
    private void randomObstacle(String imageUrl){ //Adiciona uma instância da classe Galaxy numa posicao aleatoria no topo do mundo
        addObject(new Obstaculo(imageUrl), Greenfoot.getRandomNumber(1200),0);
    }
    
    private void randomStar(int type){//Adiciona uma instância da classe Star1 numa posicao aleatoria no topo do mundo
       addObject(new Star(type), Greenfoot.getRandomNumber(1200),0);
    }
    
    private void prepare(){ // cria atores e configuração do mundo
        //Ken
        HealthBar healthKen = new HealthBar(Color.WHITE, Color.BLUE);
        Rocket rocketKen = new Rocket("up", "down", "left", "right", "enter", "KenRocket.png", healthKen);
        addObject(rocketKen,770,550);
        addObject(healthKen,770,640);
        
        //Barbie
        HealthBar healthBarbie = new HealthBar(Color.WHITE, Color.RED);
        Rocket rocketBarbie = new Rocket("w", "s", "a", "d", "r", "BarbieRocket.png", healthBarbie);
        addObject(rocketBarbie, 400,550);
        addObject(healthBarbie, 400,640);
        
        addObject(scoreCounter,77,60);
        setPaintOrder(Counter.class , Obstaculo.class);
    }
    
    public void loseGame() {
        Greenfoot.setWorld(new End(scoreCounter.getValue()+score, false)); 
    }
    
    public void winGame() {
        Greenfoot.setWorld(new End(scoreCounter.getValue()+score, true));
        Greenfoot.playSound("BarbieWin.mp3");
    }
}
