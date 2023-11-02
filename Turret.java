import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Math;


public class Turret extends NotCollisionTurret
{   
    
    SimpleTimer timerShot = new SimpleTimer();
    SimpleTimer timerReload = new SimpleTimer();
    
    public static final int RECHARGE_DELAY = 3500;
    
    private final int TURRET_RANGE = 250;
    private final int SHOTS_TO_RECHARGE = 5;
    private final int SHOT_DELAY = 1500; // in MS
    private final int ROTATION_INCREMENT = 5;
    
    private int xPos;
    private int yPos;
    
    private int rechargeDelay;
    private int shotsBeforeRecharge;
    
    private Maze world;

    public void act()
    {
        if (!foundTarget())
            spinTurret();
        
        if(rechargeDelay > 0)
            rechargeDelay--;
    }
    
    protected void addedToWorld(World world){
        xPos = getX();
        yPos = getY();
        this.world = (Maze) world;
    }
    
    private boolean foundTarget() {
        boolean foundTarget = false;
        List<Player> objs = getObjectsInRange(TURRET_RANGE, Player.class); // Pega os Players no raio TURRET_RANGE
        for(Player player : objs) { // Para cada jogador no raio ele verifica
            boolean foundCollision = false;
            int playerX = player.getX();
            int playerY = player.getY();
            int dX = playerX-xPos; //Delta X Jogador-Turret
            int dY = playerY-yPos; //Delta Y Jogador-Turret
            int d = (int) Math.hypot(dX, dY); // hipotenusa do triangulo dX, dY
            while (d>40) { // Enquanto a distância da Turret ao Player for maior que 40 (evitar dar conflito com a própria Turret)
                // Vai reduzindo o cateto dX e dY consoante a hip d
                dX = (int) (dX*(d-10))/d; 
                dY = (int) (dY*(d-10))/d;
                Actor object = getOneObjectAtOffset(dX, dY, null); // Verifica se tem algum objeto na dada distancia
                if (object != null && !(object instanceof NotCollisionTurret) && !(object instanceof Player)) {
                    foundCollision = true; //Collision encontrada! Não existe necessidade de continuar a procura de outros objetos
                    break;
                }
                d -= 10;
            }
            
            // Caso nenhuma colision for encontrada
            if(!foundCollision) {
                foundTarget = true;
                turnTowards(playerX, playerY);
                shot(playerX, playerY);
                break; // cada turret pode apenas ter um target de cada vez
            }
        }
        return foundTarget;
    }
    
    private void spinTurret() {
        // Faz com que a Turret fique a girar
        setRotation(getRotation()+ROTATION_INCREMENT);
    }
    
    private void shot(int playerX, int playerY) {
        // Caso seja possivel disparar, ou seja, nao estar em nenhum delay (tempo entre tiros ou tempo de recarregamento)
        if (timerShot.millisElapsed() > SHOT_DELAY && !(isOnDelay())) {
            timerShot.mark();
            int dX = playerX-xPos;
            int sX = (int) Math.signum(dX);
            int dY = playerY-yPos;
            int sY = (int) Math.signum(dY);
            double hip = Math.hypot(dX, dY);
            double prop = hip/28;
            shotsBeforeRecharge++; // aumenta o contador dos tiros
            world.addAmoTurret(numberToShot(dX, xPos, sX, prop),numberToShot(dY, yPos, sY, prop), playerX, playerY); //adiciona o tiro no mundo
        }
        
        if (shotsBeforeRecharge > SHOTS_TO_RECHARGE) { // Verificamos se a Turret deve ser recarregada
            activeRechargeDelay();
        }
    }
    
    private int numberToShot(int x, int pos, int sig, double prop) {
        return (int) Math.round(pos+x/prop); //Math.round((x))+pos-(sig*10); // Calcula a boca da turret
    }
    
    private void activeRechargeDelay() {
        shotsBeforeRecharge = 0; // resetar a variavel dos tiros dados
        timerReload.mark();
    }
    
    public boolean isOnDelay() { // metodo para verificar se a turret está recarregando
        return (timerReload.millisElapsed() < RECHARGE_DELAY);
    }
    
    public SimpleTimer getReloadTimer() {
        return timerReload;
    }
}
