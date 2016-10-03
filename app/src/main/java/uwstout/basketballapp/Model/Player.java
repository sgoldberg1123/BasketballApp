package uwstout.basketballapp.Model;

import java.io.Serializable;

/**
 * Created by TJ Frisch on 9/25/2016.
 */

public class Player implements Serializable {
    private String firstName;
    private String lastName;
    private int playerNum;
    private PlayerStatistics playerStats;

    public void Player(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public PlayerStatistics getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStatistics playerStats) {
        this.playerStats = playerStats;
    }

}
