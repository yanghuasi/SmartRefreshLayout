package test.com.rrefreshlayout.adapter.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


import java.util.List;

import test.com.rrefreshlayout.MainDataEntity;
import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.adapter.dataentity.Model;


public class MyAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {
    public MyAdapter(int item_rv, @Nullable List<Model> data) {
        super (R.layout.item_rv, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Model item) {
//        //可链式调用赋值
//        helper.setText(R.id.tv_title, item.getTitle())
//                .setText(R.id.tv_content, item.getContent())
//                .setImageResource(R.id.iv_img, R.mipmap.ic_launcher);
//
//        //获取当前条目position
//        //int position = helper.getLayoutPosition();

        helper.setText(R.id.tv_title, item.getTitle ())
                .setText(R.id.tv_content, item.getContent ());
//                .setText(R.id.tweetDate, item.getCreatedAt())
//                .setVisible(R.id.tweetRT, item.isRetweet())
//                .linkify(R.id.tweetText);
        //给Item子控件设置点击事件
        helper.addOnClickListener(R.id.tv_title);
        helper.addOnClickListener(R.id.tv_content);
        helper.addOnClickListener(R.id.iv_img);
        //给Item子控件设置长按事件
        helper.addOnLongClickListener(R.id.iv_img);
        Glide.with(mContext).load(item.getImgUrl ()).crossFade().into((ImageView) helper.getView(R.id.iv_img));

    }




}

