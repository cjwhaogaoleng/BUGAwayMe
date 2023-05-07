package com.example.bugawayme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bugawayme.data.RecycleViewData;
import com.example.bugawayme.mainFragment.MineFragment;

import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> {

    List<RecycleViewData> data;

    Context context;

    public MyRecycleViewAdapter(List<RecycleViewData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recycleview_mine, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(data.get(position).getImageViewResource());
        holder.textView.setText(data.get(position).getTextViewText());

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_rv_mine1);
            imageView = itemView.findViewById(R.id.iv_rv_mine1);

        }
    }
}
