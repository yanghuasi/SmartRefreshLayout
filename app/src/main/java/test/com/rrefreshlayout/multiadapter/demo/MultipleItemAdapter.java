package test.com.rrefreshlayout.multiadapter.demo;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import test.com.rrefreshlayout.R;

public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<MyMultipleItem, BaseViewHolder> {

    public MultipleItemAdapter(List data) {
        super(data);
        //必须绑定type和layout的关系
        addItemType(MyMultipleItem.FIRST_TYPE, R.layout.first_type_layout);
        addItemType(MyMultipleItem.SECOND_TYPE, R.layout.second_type_layout);
        addItemType(MyMultipleItem.NORMAL_TYPE, R.layout.item_rv);

    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultipleItem item) {
        switch (helper.getItemViewType()) {
            case MyMultipleItem.FIRST_TYPE:
                helper.setText (R.id.tv,"我是第一种item");
                Log.i("tag","FIRST_TYPE==============="+helper.getLayoutPosition());
                break;
            case MyMultipleItem.SECOND_TYPE:
                Log.i("tag","SECOND_TYPE==============="+helper.getLayoutPosition());
                break;
            case MyMultipleItem.NORMAL_TYPE:
                helper.setImageResource(R.id.iv_img, R.mipmap.ic_launcher)
                        .setText(R.id.tv_title, item.getData().getTitle())
                        .setText(R.id.tv_content, item.getData().getContent());
                break;
        }
    }
}
