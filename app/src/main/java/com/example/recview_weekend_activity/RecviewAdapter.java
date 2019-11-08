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

    public List<MessageInterface> mTitleInfo;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public RecviewAdapter(Context context, List<MessageInterface> tleInfo) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitleInfo = tleInfo;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvtle;
        TextView tvuser;

        TextView tvufirst;
        TextView tvlast;
        TextView tvutel;

        class MessageViewHolder extends RecyclerView.ViewHolder {

            public MessageViewHolder(@NonNull View itemView) {
                super(itemView);
                tvtle = itemView.findViewById(R.id.tv_title);
                tvuser = itemView.findViewById(R.id.tv_producer);

                itemView.setOnClickListener((View.OnClickListener) this);
            }

            void bindView(int position) {
                Message message = (Message) mTitleInfo.get(position);

                tvtle.setText(((Message) mTitleInfo.get(position)).getTitle());
                tvuser.setText(((Message) mTitleInfo.get(position)).getmUser());
            }
        }

        class MessageTelephoneViewHolder extends RecyclerView.ViewHolder {

            public MessageTelephoneViewHolder(@NonNull View itemView) {
                super(itemView);
                tvufirst = itemView.findViewById(R.id.tv_userFirst);
                tvlast = itemView.findViewById(R.id.tv_userLast);
                tvutel = itemView.findViewById(R.id.tv_userTel);

                itemView.setOnClickListener((View.OnClickListener) this);
            }

            void bindView(int position) {
                MessageTelephone messageTelephone = (MessageTelephone) mTitleInfo.get(position);
                tvufirst.setText(((Message) mTitleInfo.get(position)).getTitle());
                tvlast.setText(((Message) mTitleInfo.get(position)).getmUser());
                tvutel.setText(((Message) mTitleInfo.get(position)).getTitle());

            }
        }

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recviewitem, parent, false);
        return new ViewHolder(view);

        //View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recviewitem,parent,false);
        //return new ViewHolder(itemView);
    }

    /*@Override
    public void onBindViewHolder(@NonNull RecviewAdapter.ViewHolder holder, int position) {
        holder.tvtle.setText(mTitleInfo.get(position).getTitle());
        holder.tvuser.setText(mTitleInfo.get(position).getmUser());

        *//*Message message = mTitleInfo.get(position);
        holder.tvtle.setText(message.getTitle());*//*
    }*/

    @Override
    public int getItemCount() {
        return mTitleInfo.size();
    }

    MessageInterface getItem(int id) {
        return mTitleInfo.get(id);

    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setListofMessages(List<MessageInterface> msgLst) {
        this.mTitleInfo = msgLst;
        notifyDataSetChanged();
    }
}
