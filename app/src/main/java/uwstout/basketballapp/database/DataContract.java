package uwstout.basketballapp.database;

import android.provider.BaseColumns;

/**
 * Created by TJ Frisch on 10/6/2016.
 */

public final class DataContract {
    //To prevent accidental instantiation of the contract class,
    //make the constructor private.
    private DataContract(){

    }

    /*Inner class that defines the Player Model Table and it's contents.*/
    public static class PlayerModelEntry implements BaseColumns{
        public static final String TABLE_NAME = "PlayerEntry";
        public static final String COLUMN_PLAYER_STATISTICS_FOREIGN_KEY = "player_statistics_key";
        public static final String COLUMN_PLAYER_FIRST_NAME = "first_name";
        public static final String COLUMN_PLAYER_LAST_NAME = "last_name";
        public static final String COLUMN_PLAYER_NUMBER = "player_num";
    }

    /*Inner class that defines the Player Model Table and it's contents.*/
    public static class PlayerStatisticsModelEntry implements BaseColumns{
        public static final String TABLE_NAME = "PlayerStatisticsEntry";
        public static final String COLUMN_PLAYER_KEY = "player_key";
        public static final String COLUMN_PLAYER_MISSES = "misses";
        public static final String COLUMN_PLAYER_HITS = "hits";
        public static final String COLUMN_PLAYER_PASSES = "passes";
        public static final String COLUMN_PLAYER_WINS = "wins";
        public static final String COLUMN_PLAYER_LOSSES = "losses";
        public static final String COLUMN_PLAYER_POINTS_SCORED = "points_scored";
    }


}
