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

    private List<String> mTitleInfo;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    RecviewAdapter(Context context, List<String> tleInfo){
     this.mInflater = LayoutInflater.from(context);
     this.mTitleInfo = tleInfo;
    }

    @NonNull
    @Override
    public RecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.recviewitem, parent,false);
        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recviewitem,parent,false);

        return new ViewHolder(view);
        //return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecviewAdapter.ViewHolder holder, int position) {

        String titlview = mTitleInfo.get(position);
        holder.tvtle.setText(titlview);
    }

    @Override
    public int getItemCount() {

        return mTitleInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvtle;

        ViewHolder(View itemView) {
            super(itemView);
            tvtle = itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }
    @Override

        public  void onClick(View view) {
         if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }


        String getItem(int id){
            return mTitleInfo.get(id);

        }
        void setClickListener(ItemClickListener itemClickListener){
            this.mClickListener = itemClickListener;
        }


        public interface ItemClickListener{
        void onItemClick (View view, int position);

            }
}
