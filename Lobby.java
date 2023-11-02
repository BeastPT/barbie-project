import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lobby extends World
{
    
    private final int limiteXMin = 290;
    private final int limiteXMax = 905;
    private final int limiteYMin = 147;
    private final int limiteYMax = 585;
        
    public Lobby(){    
        super(1200, 650, 1); 
        prepare();
    }
    
    // Prepara o Lobby, criando os carros, butao de voltar a tras e adicionando as bolas
    private void prepare() {
        Car BarbieCar = new Car("w", "s", "a", "d", limiteXMin, limiteXMax, limiteYMin, limiteYMax,"BarbieCar.png"); 
        addObject(BarbieCar, getWidth() / 2 - 80 , getHeight() / 2 ); 
        
        Car KenCar = new Car("up", "down", "left", "right", limiteXMin, limiteXMax, limiteYMin, limiteYMax, "KenCar.png"); 
        addObject(KenCar, getWidth() / 2 + 80, getHeight() / 2 );
        
        addObject(new Menu(), 40, 40);
        
        adicionarBolas(7);
    }
    
    // adiciona as bolas no mundo
    private void adicionarBolas(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            int x = Greenfoot.getRandomNumber(limiteXMax - limiteXMin) + limiteXMin;
            int y = Greenfoot.getRandomNumber(limiteYMax - limiteYMin) + limiteYMin;
            bola Bola = new bola(); 
            addObject(Bola, x, y);
        }
    }
    
    //Se alguma bola foi tocada por um carro é apagada e criada uma nova
    public void touchedBall(Actor ball) {
        removeObject(ball);
        adicionarBolas(1);
    }
}


  
