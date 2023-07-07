package com.example.bugawayme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecycleViewCarouselAdapter extends RecyclerView.Adapter<MyRecycleViewCarouselAdapter.MyViewHolder> {

    List<Integer> data;
    List<Uri> dataUri;
    Context context;



    public MyRecycleViewCarouselAdapter(List<Integer> data,List<Uri> dataUri, Context context) {
        this.dataUri = dataUri;
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecycleViewCarouselAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recycleview_home_carousel, null);
        if (view == null) {
            throw new NullPointerException("Failed to inflate view");
        }
        return new MyViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewCarouselAdapter.MyViewHolder holder, int position) {
//        holder.imageView.setBackgroundResource(data.get(position).getImageViewResource());
        if (data!=null) {
            holder.imageView.setImageResource(data.get(position));
        } else if (dataUri!=null) {
            holder.imageView.setImageURI(dataUri.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private ImageView imageView;
        private OnItemClickListener mListener;


        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_home_carousel);


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



