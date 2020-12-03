package com.example.testviewbinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.testviewbinding.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private MyBaseMultiItemQuickAdapter adapter;
    private List<MultiBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
        initData();
    }

    private void initData() {
        list.add(new MultiBean(MultiBean.SIZE8,MultiBean.TYPE1));
        list.add(new MultiBean(MultiBean.SIZE8,MultiBean.TYPE2));
        list.add(new MultiBean(MultiBean.SIZE8,MultiBean.TYPE3));
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        adapter = new MyBaseMultiItemQuickAdapter(list);
        GridLayoutManager manager = new GridLayoutManager(this, MultiBean.ALLSIZE);
        adapter.setGridSpanSizeLookup(new GridSpanSizeLookup() {
            @Override
            public int getSpanSize(@NonNull GridLayoutManager gridLayoutManager, int viewType, int position) {
                return list.get(position).getSize();
            }
        });
        binding.recycleView.setLayoutManager(manager);
        binding.recycleView.setAdapter(adapter);
    }


    private class MyBaseMultiItemQuickAdapter extends BaseMultiItemQuickAdapter<MultiBean, BaseViewHolder>{

        public MyBaseMultiItemQuickAdapter(List<MultiBean> data){
            super(data);
            addItemType(MultiBean.TYPE1,R.layout.item_multi_item_type1);
            addItemType(MultiBean.TYPE2,R.layout.item_multi_item_type2);
            addItemType(MultiBean.TYPE3,R.layout.item_multi_item_type3);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder holder, MultiBean multiBean) {
            switch (holder.getItemViewType()){
                case MultiBean.TYPE1:
                    break;
                case MultiBean.TYPE2:
                    break;
                case MultiBean.TYPE3:
                    TextView textView = holder.getView(R.id.tvTest);
                    textView.setText("我是第三个布局");
                    break;
            }
        }
    }
}