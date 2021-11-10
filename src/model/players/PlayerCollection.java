package model.players;

import java.util.ArrayList;

import java.util.Collections;

public class PlayerCollection {
    
    ArrayList<GamePlayer> players;

    /**
     * Constructor. Initialized the collection of GamePlayer
     */
    public PlayerCollection(){
        players = new ArrayList<GamePlayer>();
    }

    /**
     * Adds the given GamePlayer in to the Collection
     * @param player Player to be added to collection
     */
    public void add(GamePlayer player){
        this.players.add(player);
    }

    /**
     * returns GamePlayer based on a specific name
     * @param name name of the GamePlayer to be returned
     * @return GamePlayer
     */
    public GamePlayer get(String name){
        for(GamePlayer el : players){
            if(el.getPlayerName().equals(name)){
                return el;
            }
        }
        return null;
        
    }

    /**
     * returns collection of GamePlayers
     * @return players
     */
    public ArrayList<GamePlayer> getPlayers(){
        return this.players;
    }

    /**
     * sorts the collection in order of Striker to GoalKeeper
     */
    public void sort(){
        if(this.players.get(0).playerName.equals("Goalkeeper")){
            Collections.swap(this.players, 0, 1);
        }
    }


}
