package test.com.rrefreshlayout.adapter.adapter;

import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;

import java.util.List;

import test.com.rrefreshlayout.R;

public class ItemDragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {


    public ItemDragAdapter(List data) {
        super (R.layout.item_draggable_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText (R.id.tv, item);
    }



}

