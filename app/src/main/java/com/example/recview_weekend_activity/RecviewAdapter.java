package com.example.recview_weekend_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecviewAdapter extends RecyclerView.Adapter<RecviewAdapter.ViewHolder> {

    public List<Message> mTitleInfo;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public RecviewAdapter(Context context, List<Message> tleInfo){
        this.mInflater = LayoutInflater.from(context);
        this.mTitleInfo = tleInfo;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvtle;
        TextView tvuser;

        public  ViewHolder(View itemView) {
            super(itemView);

            tvtle = itemView.findViewById(R.id.tv_title);
            tvuser = itemView.findViewById(R.id.tv_producer);

            itemView.setOnClickListener(this);
        }
        @Override
        public  void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recviewitem, parent,false);
        return new ViewHolder(view);

        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recviewitem,parent,false);
        //return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewAdapter.ViewHolder holder, int position) {
        holder.tvtle.setText(mTitleInfo.get(position).getTitle());
        holder.tvuser.setText(mTitleInfo.get(position).getmUser());

        /*Message message = mTitleInfo.get(position);
        holder.tvtle.setText(message.getTitle());*/
    }

    @Override
    public int getItemCount() {
        return mTitleInfo.size();
    }

    Message getItem(int id){
        return mTitleInfo.get(id);

    }

    void setClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick (View view, int position);
    }
}
