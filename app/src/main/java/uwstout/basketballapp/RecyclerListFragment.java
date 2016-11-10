package uwstout.basketballapp;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import uwstout.basketballapp.Adapters.PlayersAdapter;
import uwstout.basketballapp.Model.Player;

/**
 * Created by Student on 10/30/2016.
 */

public class RecyclerListFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.roster_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPlayers = (RecyclerView) view.findViewById(R.id.rosterListView);
        ArrayList<Player> players = new ArrayList<>();

        Player player1 = new Player("Kayla", "Bowe", 11, "center");
        players.add(player1);
        Player player2 = new Player("Kayla", "Bowe", 11, "point guard");
        players.add(player2);
        Player player3 = new Player("Kayla", "Bowe", 11, "shooting guard");
        players.add(player3);

        PlayersAdapter adapter = new PlayersAdapter(getContext(), players);

        rvPlayers.setAdapter(adapter);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
        rvPlayers.setHasFixedSize(true);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(rvPlayers);
    }
}
