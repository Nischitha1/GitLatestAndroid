package com.nischitha.albumlist.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nischitha.albumlist.R;
import com.nischitha.albumlist.pojo.Result;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Result> data;

    @Inject
    public RecyclerViewAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtartistName.setText(data.get(position).artistName);
        holder.txttrackId.setText(String.valueOf(data.get(position).trackId));
        holder.txttrackName.setText(data.get(position).trackName);
        holder.txttrackPrice.setText(String.valueOf(data.get(position).trackPrice));
        holder.txtreleaseDate.setText(data.get(position).releaseDate);
        holder.txtprimaryGenreName.setText(data.get(position).primaryGenreName);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtartistName;
        private TextView txttrackId;
        private TextView txttrackName;
        private TextView txttrackPrice;
        private TextView txtreleaseDate;
        private TextView txtprimaryGenreName;

        ViewHolder(View itemView) {
            super(itemView);

            txtartistName = itemView.findViewById(R.id.txtartistName);
            txttrackId = itemView.findViewById(R.id.txttrackId);
            txttrackName = itemView.findViewById(R.id.txttrackName);
            txttrackPrice = itemView.findViewById(R.id.txttrackPrice);
            txtreleaseDate = itemView.findViewById(R.id.txtreleaseDate);
            txtprimaryGenreName = itemView.findViewById(R.id.txtprimaryGenreName);
        }
    }

    public void setData(List<Result> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        int size = data.size();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }
}
