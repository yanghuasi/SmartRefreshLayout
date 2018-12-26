package test.com.rrefreshlayout.adapter.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.adapter.adapter.MyAdapter;
import test.com.rrefreshlayout.adapter.dataentity.Model;

public class AdapterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Model> datas;
    private MyAdapter adapter;
    private int mCurrentCounter;
    private int TOTAL_COUNTER;
    boolean isErr=false;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        //初始化RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //模拟的数据（实际开发中一般是从网络获取的）
        datas = new ArrayList<> ();
        Model model;
        for (int i = 0; i < 15; i++) {
            model = new Model();
            model.setTitle("我是第" + i + "条标题");
            model.setContent("第" + i + "条内容");
            datas.add(model);
        }

        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new MyAdapter(R.layout.item_rv, datas);

        //给RecyclerView设置适配器
        recyclerView.setAdapter(adapter);

        //条目点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Toast.makeText(AdapterActivity.this, "点击了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();
            }
        });

        //条目长按事件
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

            Toast.makeText(AdapterActivity.this, "长按了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();
            return false;
        }
    });
        //条目子控件点击事件
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                Toast.makeText(AdapterActivity.this, "点击了第" + (position + 1) + "条条目的图片", Toast.LENGTH_SHORT).show();
            }
        });
        //条目子控件长按事件
        adapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

                Toast.makeText(AdapterActivity.this, "长按了第" + (position + 1) + "条条目的图片", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        //滑动时，对Item使用缩放动画
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //自定义动画效果
        adapter.openLoadAnimation(new BaseAnimation () {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        ObjectAnimator.ofFloat(view, "scaleY", 1, 0.5f, 1),
                        ObjectAnimator.ofFloat(view, "scaleX", 1, 0.5f, 1)
                };
            }
        });
        //设置重复执行动画
        adapter.isFirstOnly(false);
        //添加头部、尾部
//        adapter.addHeaderView(headerView);
//        adapter.addFooterView(footerView);
//上拉加载（设置这个监听就表示有上拉加载功能了）
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        } else {
                            if (isErr) {
                                //成功获取更多数据（可以直接往适配器添加数据）
                                adapter.addData((Collection<? extends Model>) recyclerView);
                                mCurrentCounter = adapter.getData().size();
                                //主动调用加载完成，停止加载
                                adapter.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                Toast.makeText(AdapterActivity.this, R.string.network_err, Toast.LENGTH_LONG).show();
                                //同理，加载失败也要主动调用加载失败来停止加载（而且该方法会提示加载失败）
                                adapter.loadMoreFail();

                            }
                        }
                    }

                }, 2000);
            }
        }, recyclerView);



////注意：如果上拉结束后，下拉刷新需要再次开启上拉监听，需要使用setNewData方法填充数据。
//        adapter.setEnableLoadMore(boolean);



//        //设置下拉加载开启开关
//        adapter.setUpFetchEnable(true);
//        adapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
//            @Override
//            public void onUpFetch() {
//                startUpFetch();
//            }
//        });
//        //开始加载的位置
//        adapter.setStartUpFetchPosition(2);
//}
//
//    private void startUpFetch() {
//        count++;
//
//        adapter.setUpFetching(true);
//
//        recyclerView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                adapter.addData(0, genData());
//
//                adapter.setUpFetching(false);
//
//                if (count > 5) {
//                    adapter.setUpFetchEnable(false);
//                }
//            }
//        }, 300);
    }
}

