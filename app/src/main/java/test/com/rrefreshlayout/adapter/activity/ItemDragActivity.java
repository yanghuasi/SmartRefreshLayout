package test.com.rrefreshlayout.adapter.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;

import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.adapter.adapter.ItemDragAdapter;

public class ItemDragActivity extends AppCompatActivity {
    private ItemDragAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_adapter);
        mRecyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        OnItemDragListener onItemDragListener = new OnItemDragListener () {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            }
        };

        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener () {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

            }
        };

        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback (mAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper (itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView (mRecyclerView);

// 开启拖拽
        mAdapter.enableDragItem (itemTouchHelper, R.id.tv, true);
        mAdapter.setOnItemDragListener (onItemDragListener);

// 开启滑动删除
        mAdapter.enableSwipeItem ();
        mAdapter.setOnItemSwipeListener (onItemSwipeListener);

    }




}
