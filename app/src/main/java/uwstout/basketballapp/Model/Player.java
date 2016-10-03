package uwstout.basketballapp.Model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by TJ Frisch on 9/25/2016.
 */

public class Player implements Parcelable {
    private String firstName;
    private String lastName;
    private int playerNum;
    private PlayerStatistics playerStats;

    public Player(String firstName, String lastName, int playerNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNum = playerNum;
    }
    protected Player(Parcel in){
        firstName = in.readString();
        lastName = in.readString();
        playerNum = in.readInt();
        playerStats = in.readParcelable(PlayerStatistics.class.getClassLoader());
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeInt(playerNum);
        dest.writeParcelable(playerStats,flags);
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
