package com.example.chapter3.homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;


public class PlaceholderFragment extends Fragment {

    LottieAnimationView lav1;
    RecyclerView rv1;
    Animation fade_in, fade_out;
    private MyAdapter mAdapter;
    private List<Data> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        rv1 = getView().findViewById(R.id.rv1);
        rv1.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new MyAdapter();
        rv1.setAdapter(mAdapter);
        initList();
        mAdapter.setData(list);
        mAdapter.notifyDataSetChanged();
        rv1.setVisibility(View.INVISIBLE);


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                lav1 = getView().findViewById(R.id.lav1);
                fade_out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
                lav1.startAnimation(fade_out);
                lav1.setVisibility(View.INVISIBLE);

                rv1.setVisibility(View.VISIBLE);
                fade_in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
                rv1.startAnimation(fade_in);
            }
        }, 5000);
    }
    protected void initList() {
        for(int i=0;i<30;i++){
            Data data = new Data();
            data.index = i+"";
            data.title = "这是第" + i + "篇title";
            data.recommend = i%5==0;
            data.hot = i%3==0;
            data.New = i%7==0;
            list.add(data);
        }
    }
}
