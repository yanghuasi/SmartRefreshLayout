package test.com.rrefreshlayout.adapter.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import test.com.rrefreshlayout.MainDataEntity;
import test.com.rrefreshlayout.R;

public class MainAdapter extends BaseQuickAdapter<MainDataEntity, BaseViewHolder> {


    public MainAdapter(@Nullable List<MainDataEntity> data) {
        super (R.layout.item_main, data);
    }



    @Override
    protected void convert(BaseViewHolder helper, MainDataEntity item) {
//        helper.setText (R.id.tv_title, item.getTitie ());
        ImageView imageView = helper.itemView.findViewById (R.id.view);
        Glide.with (mContext).load (item.getView ()).into (imageView);
        ImageView imageView2 = helper.itemView.findViewById (R.id.view_two);
        Glide.with (mContext).load (item.getViewTwo ()).into (imageView2);
        ImageView imageView3 = helper.itemView.findViewById (R.id.view_three);
        Glide.with (mContext).load (item.getViewThree ()).into (imageView3);
        ImageView imageView4 = helper.itemView.findViewById (R.id.view_four);
        Glide.with (mContext).load (item.getViewFour ()).into (imageView4);


        //给Item里的控件设置点击-->HomePageActivity
        helper.addOnClickListener (R.id.view);
        helper.addOnClickListener (R.id.view_two);
        helper.addOnClickListener (R.id.view_three);
        helper.addOnClickListener (R.id.view_four);

//        helper.addOnLongClickListener (R.id.iv_view);长按
    }
}
