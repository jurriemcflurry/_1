package model;

public class Nbaplayer {
    String id;
    String playerName;
    String teamName;
    int rank;

    public Nbaplayer(String id, String playerName, String teamName, int rank){
        this.id = id;
        this.playerName = playerName;
        this.teamName = teamName;
        this.rank = rank;
    }

    public Nbaplayer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "Nbaplayer{" + "id='" + id + '\'' +
                ",playerName='" + playerName + '\'' +
                ",teamName='" + teamName + '\'' +
                '}';
    }
}
