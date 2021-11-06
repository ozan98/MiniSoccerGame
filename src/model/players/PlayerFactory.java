package model.players;

import java.awt.Color;

public class PlayerFactory {
    GamePlayer stikerPlayer;
    GamePlayer goalKeeperPlayer;

    public PlayerFactory(){
        stikerPlayer = new Striker("Striker", Color.BLUE);
        goalKeeperPlayer = new Goalkeeper("Goalkeeper", Color.YELLOW);

    }

    public GamePlayer getPlayer(String name){
        if(name.equals("Striker")){
            return stikerPlayer;
        }
        if(name.equals("Goalkeeper")){
            return goalKeeperPlayer;
        }
        return null;
    }

    
    
}
