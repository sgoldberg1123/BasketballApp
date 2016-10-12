package uwstout.basketballapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import uwstout.basketballapp.Model.Player;
import uwstout.basketballapp.R;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.ViewHolder>{

    private List<Player> mPlayerList;
    private Context mContext;

    public PlayersAdapter(Context context, List<Player> playerList){
        mPlayerList = playerList;
        mContext = context;
    }

    private Context getContext(){
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public TextView numberTextView;
        public TextView positionTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            firstNameTextView = (TextView) itemView.findViewById(R.id.firstNametextView);
            lastNameTextView = (TextView) itemView.findViewById(R.id.lastNametextView);
            numberTextView = (TextView) itemView.findViewById(R.id.NumbertextView);
            positionTextView = (TextView) itemView.findViewById(R.id.PositiontextView);


        }
    }


    @Override
    public PlayersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.items_for_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlayersAdapter.ViewHolder viewHolder, int position) {
        Player player = mPlayerList.get(position);

        TextView firstNameTV = viewHolder.firstNameTextView;
        TextView lastNameTV = viewHolder.lastNameTextView;
        TextView numberTV = viewHolder.numberTextView;
        TextView positionTV = viewHolder.positionTextView;

        firstNameTV.setText(player.getFirstName());
        lastNameTV.setText(player.getLastName());
        numberTV.setText(player.getPlayerNum());
        positionTV.setText(player.getPosition());
    }

    @Override
    public int getItemCount() {
        return mPlayerList.size();
    }
}
