package uwstout.basketballapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TJ Frisch on 10/6/2016.
 */

public class BasketBallDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "basketball.db";
    private static final int CURRENT_VERSION = 1;

    private static final String SQL_CREATE_PLAYER_MODEL_TABLE =
            "CREATE TABLE " + DataContract.PlayerModelEntry.TABLE_NAME + " (" +
                    DataContract.PlayerModelEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DataContract.PlayerModelEntry.COLUMN_PLAYER_FIRST_NAME + " TEXT NOT NULL," +
                    DataContract.PlayerModelEntry.COLUMN_PLAYER_LAST_NAME + " TEXT NOT NULL," +
                    DataContract.PlayerModelEntry.COLUMN_PLAYER_NUMBER + " INTEGER," +
                    DataContract.PlayerModelEntry.COLUMN_PLAYER_STATISTICS_FOREIGN_KEY + " INTEGER" +
                    " )";
    private static final String SQL_CREATE_PLAYER_STATISTICS_MODEL_TABLE =
            "CREATE TABLE " + DataContract.PlayerModelEntry.TABLE_NAME + " (" +
                    DataContract.PlayerStatisticsModelEntry._ID + " INTEGER PRIMARY KEY," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_HITS + " INTEGER," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_MISSES + " INTEGER," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_LOSSES + " INTEGER," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_WINS + " INTEGER," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_PASSES + " INTEGER," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_POINTS_SCORED + " INTEGER," +
                    DataContract.PlayerStatisticsModelEntry.COLUMN_PLAYER_KEY + " INTEGER" +
                    " )";


    public BasketBallDatabase(Context context){
        super(context, DATABASE_NAME, null, CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PLAYER_MODEL_TABLE);
        db.execSQL(SQL_CREATE_PLAYER_STATISTICS_MODEL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != CURRENT_VERSION) {
            db.execSQL("DROP TABLE IF EXISTS " + DataContract.PlayerModelEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + DataContract.PlayerStatisticsModelEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        // TODO: Make sure to use sqlcipher
        //db.execSQL(String.format("PRAGMA key='%s'",
        //        XORUtils.decode("DiIQODxBLi5hVA==", mContext.getString(R.string.db_key))));
    }


}
