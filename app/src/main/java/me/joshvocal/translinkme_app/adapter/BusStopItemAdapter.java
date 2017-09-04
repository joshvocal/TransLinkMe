package me.joshvocal.translinkme_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.joshvocal.translinkme_app.R;
import me.joshvocal.translinkme_app.model.BusStop;

/**
 * Created by josh on 9/4/17.
 */

public class BusStopItemAdapter extends RecyclerView.Adapter<BusStopItemAdapter.BusStopHolder> {

    private List<BusStop> mBusStopList;
    private Context mContext;

    public BusStopItemAdapter(Context context, List<BusStop> busStopList) {
        mContext = context;
        mBusStopList = busStopList;
    }

    @Override
    public BusStopHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bus_stop, parent, false);
        return new BusStopHolder(view);
    }

    @Override
    public void onBindViewHolder(BusStopHolder holder, int position) {
        BusStop currentBusStop = mBusStopList.get(position);

        holder.mBusStopName.setText(currentBusStop.getName());
        holder.mBusStopRoutes.setText(currentBusStop.getRoutes());
    }

    @Override
    public int getItemCount() {
        return mBusStopList.size();
    }

    public class BusStopHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mBusStopName;
        private TextView mBusStopRoutes;

        public BusStopHolder(View itemView) {
            super(itemView);

            mBusStopName = itemView.findViewById(R.id.item_bus_stop_name_text_view);
            mBusStopRoutes = itemView.findViewById(R.id.item_bus_stop_routes_text_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Intent intent = new Intent(mContext, BusStopDetailsActiivty.class);
//            intent.putExtra(BUS_STOP_NUMBER_KEY,
//                    mBusStopList.get(getAdapterPosition()).getStopNumber());
//            intent.putExtra(BUS_STOP_AT_STREET_KEY,
//                    mBusStopList.get(getAdapterPosition()).getAtStreet());
//            intent.putExtra(BUS_STOP_ON_STREET_KEY,
//                    mBusStopList.get(getAdapterPosition()).getOnStreet());
//            mContext.startActivity(intent);
        }
    }
}
