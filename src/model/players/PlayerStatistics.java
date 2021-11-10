package model.players;

public class PlayerStatistics {
    Integer stat;

    /**
     * constructor. Initializes the stat value
     */
    public PlayerStatistics(){
        stat = 0;
    }

    /**
     * Updates the stat value
     * @param stat
     */
    public void setStatistics(Integer stat){
        this.stat = stat;
    }

    /**
     * returns stat value
     * @return stat
     */
    public Integer getStatistics(){
        return this.stat;
    }
    
    /**
     * return string value of stat
     * @return stat
     */
    @Override
    public String toString(){
        return stat.toString();
    }
}
