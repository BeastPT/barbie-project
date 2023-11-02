import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Portal extends Actor
{   
    private final int PLAYER_AMOUNT = 2;
    
    private SimpleTimer delay = new SimpleTimer();
    private final int DELAY_NEXTGAME = 1000;
    private boolean playersOnPortal;
    public void act() {
        boolean cPlayers = checkPlayers();
        if (playersOnPortal != cPlayers && playersOnPortal == false)
            delay.mark();
            
        playersOnPortal = cPlayers;
        
        delayToJoinPortal();
    }
    
    private boolean checkPlayers() {
        if (isTouching(Player.class)) { // Verifica se algum jogador está no portal de saída
            List<Player> players = getIntersectingObjects(Player.class); // Pega a Lista de Jogadores que está no portal
            return(players.size() == PLAYER_AMOUNT); // Verifica se todos os jogadores estão no portal
        }
        return false;
    }
    
    private void delayToJoinPortal() {
        if (delay.millisElapsed() > DELAY_NEXTGAME && playersOnPortal == true) {
            finishGame();
        }
    }
    
    private void finishGame() {
        ((Maze) getWorld()).winGame();
    }
}
