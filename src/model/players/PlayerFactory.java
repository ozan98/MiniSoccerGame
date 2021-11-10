package model.players;

import java.awt.Color;

public class PlayerFactory {
    GamePlayer stikerPlayer;
    GamePlayer goalKeeperPlayer;

    /**
     * constructor of PlayerFactory
     * creates instance of Striker and GoalKeerp
     */
    public PlayerFactory(){
        stikerPlayer = new Striker("Striker", Color.BLUE);
        goalKeeperPlayer = new Goalkeeper("Goalkeeper", Color.YELLOW);

    }

    /**
     * returns a GamePlayer based on the specific name
     * @param name name of the GamePlayer. This can be 'Striker' or 'GoalKeeper'
     * @return GamePlayer
     */
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
