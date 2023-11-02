import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Maze extends World
{
    
    private int mazeMapVersion;
    private int currentLifes = 3;
    private List<PlayerLife> lifesArray = new ArrayList<PlayerLife>();
    public Maze() {    
        super(1200, 650, 1);
        mazeMapVersion = Greenfoot.getRandomNumber(2);
        prepare();
    }
    
    private void prepare() {
        setupMazeWalls();
        setupMazeDoors();
        setupPlayers();
        setupTurrets();
        setupExit();
        setupPlayerLifes();
        setPaintOrder(Player.class, Portal.class, PlayerLife.class, AmmoExplosion.class);
    }
    
    private void setupExit() {
        addObject(new Portal(), getWidth()-25, 25);
    }

    private void setupPlayerLifes() {
        int x = (int) getWidth()/2 - currentLifes*15;
        // Cria as vidas dos jogadores consoante o currentLifes é definido
        for (int i = 0; i<currentLifes; i++) {
            PlayerLife nPL = new PlayerLife();
            lifesArray.add(nPL);
            addObject(nPL, x+i*45, 25);
        }
    }
    
    private void setupPlayers(){
        Player player1 = new Player("w", "s", "a", "d", "BarbieWalking1.png");
        addObject(player1, 25, 25);
        
        Player player2 = new Player("up", "down", "left", "right", "KenWalking1.png");
        addObject(player2, 50*3+25, 50*12+25);
    }
    
    private void setupMazeWalls() {
        // Criação das parades do labirinto num grid 23x13
        boolean[][][] walls = {{
            {false, false, false, false,false, false, false, false,true, false, false, false,true, false, false, false,false, false, false, true,true, false, false, false},
            {true, true, true, true,false, true, true, true,true, false, true, false,true, true, false, true,false, true, true, true,true, true, false, false},
            {false, false, false, false,false, false, false, true,false, false, true, false,false, true, false, true,false, true, false, false,false, true, true, false},
            {false, true, true, true,true, false, true, true,false, true, true, true,false, true, true, true,false, true, false, true,false, false, true, false},
            {false, true, false, false,false, false, false, false,false, true, false, true,false, false, false, false,false, false, false, true,false, false, false, false},
            {false, true, true, true,true, true, true, true,true, true, false, true,true, true, true, true,true, true, true, true,true, false, true, true},
            {false, false, false, false,true, false, false, false,false, false, false, true,false, true, true, true,true, true, true, true,false, false, true, false},
            {true, true, true, true,true, false, true, true,true, true, true, true,false, false, false, false,false, false, false, true,true, false, true, false},
            {false, false, false, false,true, false, false, false,true, false, true, false,false, true, false, true,false, true, false, false, true, false, true, false},
            {false, true, true, true,true, false, true, false,true, false, true, false,false, true, false, true,false, true, false, false,false, false, false, false},
            {false, false, false, false,false, false, true, false,true, false, true, false,true, true, true, true,false, true, true, true,true, true, false, false},
            {false, true, true, true,true, false, true, false,true, false, true, false,true, false, false, true,false, false, false, false,true, false, false, false},
            {false, false, false, false,true, false, true, false,false, false, false, false,false, false, false, false,true, false, false, false,true, false, false, false},
        },
        {
            {false,true, true,true,true, true, true,true,true, true, true, true,false, true, false, false,false, false, false, true,false, true, false, false},
            {false, false, false, false,false, false, false, true,false, false, false, true,false, false, false, false,true, true, false, true,false, true, false, false},
            {false, true, true, true,true, true, false, true,false,true, false, true,false, true, true, true,false, false, false, true,false, true,false, false},
            {false, false, false, false,true, true, false, false,false, true, false, false,false, false, false, true,false, true, true, false,false, true, false, false},
            {true, true, true, false,true, true, false, true,false, false, true, true,true, false, false, true,false, false, false, false,true, false, false, true},
            {false, false, true, true,true, false, true, true,true, true, true, false,true, false, false, false,true, true, true, true,true, false, false, true},
            {false, true, true, false,true, false, false, false,false, false, true, false,true, true, true, false,false, false, false, false,true, false, true, true},
            {false, false, false, false,false, false, true, false,true, false, false,false,false, false, false,true,true, true, true, false,false, false, true, false},
            {false, true, true, true,true, true, false, false,false,true, true, true,true, true, false, false,true, false, true, true, true, false, false, false},
            {false, true, true, false,false, false, false, true,false, true, true, false,false, false, true, false,false, false, false, false,true, true, true, false},
            {false, false, true, false,true, false, false, true,false, false, true, false,false, true, false, false,true, false, true, false,true, false, false, false},
            {true, false, false, false,true, true, false, true,false, false, true, false,true, false, false, true,true, false, true, true,false,true, false, false},
            {true, true, true, false,true, true, false, true,false, false, false, false,true, false, false, false,false, false, false, false,false, false, false, false},
        },
        {
            {false,true, false,false,true, false, false,false,false, false,false,false,true, false,false, false,false, false, false, true,true, true, false, false},
            {false, true, false, true,true, false, true, true,true,true,true,false,false, false, false, true,true, true, true, true,false, false, false, false},
            {false, false,false, false,true,false,true, false,false,false, false, true,true, true, false, true,false, false, false, true,true, false,false, true},
            {false, true, false, false,false,false, true, false,false, true, false, false,false, true, false, true,true, false, true, true,true, false, true, true},
            {true, true, true, false,true, true, false, false,true, true, true, true,false, true, false, false,false, false, false, true,false, false, false, false},
            {false, true, true, false,true,false,false, true, true, true,false, true, false, true,false, true, true, true,false, true, false, true,true, false},
            {false, false,false, false,false, false, true, false,false, false, false, true, false, true, false, true,false, false, false, true,false, false, true, false},
            {true, true, true, true,true, true, false, false,false, true, false,true,false, false,true,true,true, true,false, false,true, false, true, false},
            {false, false, false, false,false, false, true, true,false,true, false,false,true, false, false, false,false, false, true, true, true, false, true, false},
            {false, false, true, false,true, true, false, true,false, false, true, false,false, true, true, true,true, false, false, false,false, false, true, false},
            {true, false, true, false,false, false, false, true,false, false, false, true,false, false, true, false,false, true, true, true,true, false, true, false},
            {true, false,true, false,true, false, false, false,false, true, false, true,true, false, false, false,true, false, true, false,false,true, true, false},
            {false,false, true,false,true, true, true, true,true, false, false, false,true, false, true, false,false, false, false, false,false, false, false, false},
        }};
        
        // Iteração pelo array multi dimensional
        for (int i = 1; i < 14; i++) { //linhas
          for (int j = 0; j < 24; j++) { // colunas
               if (walls[mazeMapVersion][i-1][j])
                  addObject(new WallBlock(), j*50+25, i*50-25);
            }
        }
    }
    
    private void setupMazeDoors() {
        //[mapVersion][DoorNumber][x/y]
        int[][][] mapsDoors = {
            {{15, 5}, {22, 6}},
            {{12, 4}, {22, 13}},
            {{13, 11}, {8, 5}}
        };
        
        int[][][] pressurePlates = {
            {{14, 12}, {18, 1}},
            {{13, 10}, {21, 1}},
            {{17, 3}, {17, 11}}
        };
        
        // Iteração até a quantidade de portas que tem nesse mapa e criação da porta/placa de pressão
        for (int i=0; i<mapsDoors[mazeMapVersion].length; i++) {
            int[] doorLoc = mapsDoors[mazeMapVersion][i];
            int[] pressureLoc = pressurePlates[mazeMapVersion][i];
            Door door = new Door();
            addObject(door, doorLoc[0]*50-25, doorLoc[1]*50-25);
            addObject(new PressurePlate(door), pressureLoc[0]*50-25, pressureLoc[1]*50-25);
        };        
    }
    
    private void setupTurrets() {
        //[mapVersion][turretNumber][x/y]
        int[][][] mapsTurrets = {
            {{13, 7}, {14, 1}},
            {{10, 11}, {15, 4}},
            {{15, 1}, {21, 12}}
        };
        
        //For each dos objetos dentro da lista de Turrets de um mapa e sua criação
        for (int[] turretLoc : mapsTurrets[mazeMapVersion]) {
            Turret turret = new Turret();
            addObject(turret, turretLoc[0]*50-25, turretLoc[1]*50-25);
            addObject(new TurretDelay(turret), turretLoc[0]*50-25, turretLoc[1]*50-25);
        }
    };
    
    // Adiciona a bala da Turret ao Mundo
    public void addAmoTurret(int fromX, int fromY, int toX, int toY) {
        addObject(new TurretAmmo(toX, toY), fromX, fromY);
    }
    
    // Adiciona a explosão ao Mundo
    public void explodeAmoTurret(int x, int y) {
        addObject(new AmmoExplosion(), x, y);
    }
    
    // Remove as vidas dos Jogadores
    public void removeLife() {
        int size = lifesArray.size();
        if (size > 0)
            removeObject(lifesArray.remove(size - 1)); // Remove o ultimo objeto da Lista
        else {
            Greenfoot.setWorld(new End(0, false));
            Greenfoot.stop();
        }
            
    }
    
    public void winGame() {
        Greenfoot.setWorld(new SpaceWorld(lifesArray.size()*10)); 
    }
}
