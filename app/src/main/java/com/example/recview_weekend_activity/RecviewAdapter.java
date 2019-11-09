package com.example.recview_weekend_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecviewAdapter extends RecyclerView.Adapter {

    public List<MessageInterface> mTitleInfo;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public RecviewAdapter(Context context, List<MessageInterface> tleInfo) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitleInfo = tleInfo;
    }

    class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvtle;
        TextView tvuser;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtle = itemView.findViewById(R.id.tv_title);
            tvuser = itemView.findViewById(R.id.tv_producer);

            itemView.setOnClickListener(this);
        }

        void bindView(int position) {
            Message message = (Message) mTitleInfo.get(position);

            tvtle.setText(message.getTitle());
            tvuser.setText(message.getmUser());
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    class MessageTelephoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvufirst;
        TextView tvlast;
        TextView tvutel;

        public MessageTelephoneViewHolder(@NonNull View itemView) {
            super(itemView);
            tvufirst = itemView.findViewById(R.id.tv_userFirst);
            tvlast = itemView.findViewById(R.id.tv_userLast);
            tvutel = itemView.findViewById(R.id.tv_userTel);

            itemView.setOnClickListener(this);
        }

        void bindView(int position) {
            MessageTelephone messageTelephone = (MessageTelephone) mTitleInfo.get(position);

            tvufirst.setText(messageTelephone.getmUserFirst());
            tvlast.setText(messageTelephone.getmUserLast());
            tvutel.setText(messageTelephone.getmTel());

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case Message.MESSAGE_TEXT:
                itemView = mInflater
                        .inflate(R.layout.recviewitem, parent, false);
                viewHolder = new MessageViewHolder(itemView);

                break;

            case Message.MESSAGE_URL:
                itemView = mInflater
                        .inflate(R.layout.recviewitemdetails, parent, false);
                viewHolder = new MessageTelephoneViewHolder(itemView);

                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return mTitleInfo.get(position).getType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Message.MESSAGE_TEXT:
                ((MessageViewHolder) holder).bindView(position);
                break;

            case Message.MESSAGE_URL:
                ((MessageTelephoneViewHolder) holder).bindView(position);

                break;
        }

    }

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
