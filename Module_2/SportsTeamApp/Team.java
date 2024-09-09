package Module_2.SportsTeamApp;

public class Team {

    private String teamName;
    private String[] players;
    private int playerCount;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[20]; 
        this.playerCount = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addPlayer(String player) {
        if (playerCount < 20) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Team is full!");
        }
    }

    public int getPlayerCount() {
        return playerCount;
    }


    public String[] getPlayers() {
        return players;
    }
}

