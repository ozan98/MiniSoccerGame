package model.players;

public class PlayerStatistics {
    Integer stat;

    public PlayerStatistics(){
        stat = 0;
    }

    public void setStatistics(Integer stat){
        this.stat = stat;
    }

    public Integer getStatistics(){
        return this.stat;
    }
    
    @Override
    public String toString(){
        return stat.toString();
    }
}
