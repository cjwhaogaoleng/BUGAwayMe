package com.example.bugawayme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleViewShopAdapter extends RecyclerView.Adapter<MyRecycleViewShopAdapter.MyViewHolder> {

    List<RecycleViewShopData> data;

    Context context;



    public MyRecycleViewShopAdapter(List<RecycleViewShopData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecycleViewShopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recycleview_shop, null);
        if (view == null) {
            throw new NullPointerException("Failed to inflate view");
        }
        return new MyViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewShopAdapter.MyViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(data.get(position).getImageViewResource());

//        holder.imageView.setImageResource(data.get(position).getImageViewResource());
        holder.introduce.setText(data.get(position).getIntroduce());
        holder.price.setText(data.get(position).getPrice());
        holder.name.setText(data.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;

        private ImageView imageView;
        private TextView introduce;
        private TextView price;

        private OnItemClickListener mListener;


        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_shop);
            introduce = itemView.findViewById(R.id.tv_shop_introduce);
            price = itemView.findViewById(R.id.tv_shop_price);
            name = itemView.findViewById(R.id.tv_shop_name);

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



