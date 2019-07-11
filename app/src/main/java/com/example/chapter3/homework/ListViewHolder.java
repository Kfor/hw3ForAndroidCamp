package com.example.chapter3.homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder{

    private TextView mIndex;
    private TextView mTitle;
    private TextView mHot,mNew,mRecommend;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        mIndex = itemView.findViewById(R.id.index);
        mTitle = itemView.findViewById(R.id.Title);
        mHot = itemView.findViewById(R.id.Hot);
        mNew = itemView.findViewById(R.id.New);
        mRecommend = itemView.findViewById(R.id.Recommend);
    }

    public void bind(Data data){
        if(data==null){
            return;
        }
        mIndex.setText(data.index);
        mTitle.setText(data.title);
        if(data.hot) {
            mHot.setText("热!");
        }
        if(data.New)
            mNew.setText("新!");
        if(data.recommend)
            mRecommend.setText("荐!");
    }

    public static ListViewHolder create(Context context, ViewGroup root) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list, root, false);
        return new ListViewHolder(v);
    }

}
