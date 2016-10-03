package uwstout.basketballapp.ModelUnitTests;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import uwstout.basketballapp.Model.Player;
import uwstout.basketballapp.Model.PlayerStatistics;

import static junit.framework.Assert.*;
/**
 * Created by TJ Frisch on 10/2/2016.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class PlayerUnitTest {

    Random random = new Random();
    Player tPlayer = generateRandomPlayer();
    @Before
    public Player generateRandomPlayer(){
        //Generate random player number from 1 to 50.
        int rNum = random.nextInt((50-1) + 1) + 1;
        String firstName = "Timothy";
        String lastName = "Frisch";
        Player generatedPlayer = new Player(firstName, lastName,rNum);
        generatedPlayer.setPlayerStats(generateRandomPlayerStatistics());
        return generatedPlayer;
    }
    public PlayerStatistics generateRandomPlayerStatistics(){
        //Generate random stats.
        int misses = random.nextInt((50-1)+1)+1;
        int hits = random.nextInt((50-1)+1)+1;
        int passes = random.nextInt((100-1)+1)+1;
        int wins = random.nextInt((50-1)+1)+1;
        int losses = random.nextInt((50-1)+1)+1;
        //Points correlated to shots made (hits).
        int pointsScored = random.nextInt((hits*3)+1)+1;

        PlayerStatistics randomStats = new PlayerStatistics(misses, hits, passes, wins, losses, pointsScored);
        return randomStats;
    }

    @Test
    public void testPlayerCreation() throws Exception{

        //Test if the creation was successful.
        assertTrue(!tPlayer.equals(null));
    }

    @Test
    public void testPlayerParcelization() throws Exception{
       Parcel testParcel = Parcel.obtain();
        tPlayer.writeToParcel(testParcel,0);

        testParcel.setDataPosition(0);

        Player playerFromParcel = Player.CREATOR.createFromParcel(testParcel);
        assertEquals(tPlayer,playerFromParcel);
    }

}
