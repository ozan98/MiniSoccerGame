package model.players;

import java.util.ArrayList;

import java.util.Collections;

public class PlayerCollection {
    ArrayList<GamePlayer> players;

    public PlayerCollection(){
        players = new ArrayList<GamePlayer>();
    }

    public void add(GamePlayer player){
        this.players.add(player);
    }

    public GamePlayer get(String name){
        for(GamePlayer el : players){
            if(el.getPlayerName().equals(name)){
                return el;
            }
        }
        return null;
        
    }

    public ArrayList<GamePlayer> getPlayers(){
        return this.players;
    }

    public void sort(){
        // for(int i = 0; i < this.players.size(); i++){
        //     if()
        // }
        if(this.players.get(0).playerName.equals("Goalkeeper")){
            Collections.swap(this.players, 0, 1);
        }
    }


}
