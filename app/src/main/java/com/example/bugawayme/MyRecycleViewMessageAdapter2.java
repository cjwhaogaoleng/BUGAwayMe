package com.example.bugawayme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecycleViewMessageAdapter2 extends RecyclerView.Adapter<MyRecycleViewMessageAdapter2.MyViewHolder> {

    List<RecycleViewMessageData> data;

    Context context;



    public MyRecycleViewMessageAdapter2(List<RecycleViewMessageData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecycleViewMessageAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recycleview_message, null);
        if (view == null) {
            throw new NullPointerException("Failed to inflate view");
        }
        return new MyViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewMessageAdapter2.MyViewHolder holder, int position) {
//        holder.imageView.setBackgroundResource(data.get(position).getImageViewResource());
        holder.imageView.setImageResource(data.get(position).getImageViewResource());
        holder.tv_who.setText(data.get(position).getTextViewWho());
        holder.tv_news.setText(data.get(position).getTextViewNews());
        holder.tv_time.setText(data.get(position).getTextViewTime());
        holder.tv_num.setText(data.get(position).getTextViewNumber());


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_who,tv_news,tv_time,tv_num;

        private CircleImageView imageView;
        private OnItemClickListener mListener;


        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_rv_message);
            tv_who = itemView.findViewById(R.id.tv_rv_message_who);
            tv_news = itemView.findViewById(R.id.tv_rv_message_news);
            tv_time = itemView.findViewById(R.id.tv_rv_message_time);
            tv_num = itemView.findViewById(R.id.tv_rv_message_number);

//            if (mListener != null) {
                this.mListener = listener;
                itemView.setOnClickListener(this);
//            }
//            else
//                Toast.makeText(itemView.getContext(), "onTitemCLickListener is null", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getLayoutPosition());
        }
    }


    private OnItemClickListener mClickListener;//自定义的接口

    @SuppressLint("NotifyDataSetChanged")
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mClickListener = onItemClickListener;
        notifyDataSetChanged();  // 可选，用于通知数据集发生更改
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
//        void onLongClick(View view, int position);
    }

}



