package test.com.rrefreshlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.com.rrefreshlayout.MainDataEntity;
import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.adapter.BaseRecyclerAdapter;
import test.com.rrefreshlayout.adapter.SmartViewHolder;

public class SimpleActivity extends AppCompatActivity {
    private class Model {
        int imageId;
        int avatarId;
        String name;
        String nickname;
    }
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    //    private MainAdapter listAdapter;
    private List<MainDataEntity> entities;
    private BaseRecyclerAdapter<Model> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_simple);
        ButterKnife.bind (this);
        recyclerView = (RecyclerView) findViewById (R.id.recyclerView);
        refreshLayout = (SmartRefreshLayout) findViewById (R.id.refreshLayout);
        //下拉刷新
        refreshLayout.setOnRefreshListener (new OnRefreshListener () {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh (2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener (new OnLoadMoreListener () {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore (2000/*,false*/);//传入false表示加载失败
            }
        });
        //给recyclerView适配Item
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
        //设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator ());
        //设置适配器
        recyclerView.setAdapter(listAdapter = new BaseRecyclerAdapter<Model> (loadModels(), R.layout.item_practice_repast) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Model model, int position) {
                holder.text(R.id.name, model.name);
                holder.text(R.id.nickname, model.nickname);
                holder.image(R.id.image, model.imageId);
                holder.image(R.id.avatar, model.avatarId);
            }
        });
//        //去网络请求数据
//        entities = new ArrayList<> ();
//        MainDataEntity newEntity = new MainDataEntity ("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2159989106,3526791124&fm=26&gp=0.jpg", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2263956994,1370962370&os=3482962655,3878497456&simid=4150691715,676820019&pn=91&rn=1&di=100729314840&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=3c&objurl=http%3A%2F%2Fimage.17173.com%2Fbbs%2Fv1%2F2010%2F09%2F08%2F1283947526539.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3143213859,4199303994&os=3558792314,2735997829&simid=83592992,935505849&pn=230&rn=1&di=51606847270&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=b4&objurl=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fa8773912b31bb0512211a8d9347adab44aede00e.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3445190730,1948150448&os=1599560082,3615752837&simid=0,0&pn=266&rn=1&di=217505119260&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=d2&objurl=http%3A%2F%2Fimg.article.pchome.net%2F00%2F40%2F23%2F91%2Fpic_lib%2Fs960x639%2FZhuoku012s960x639.jpg&rpstart=0&rpnum=0&adpicid=0");
//        MainDataEntity newEntity2 = new MainDataEntity ("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2159989106,3526791124&fm=26&gp=0.jpg", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2263956994,1370962370&os=3482962655,3878497456&simid=4150691715,676820019&pn=91&rn=1&di=100729314840&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=3c&objurl=http%3A%2F%2Fimage.17173.com%2Fbbs%2Fv1%2F2010%2F09%2F08%2F1283947526539.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3143213859,4199303994&os=3558792314,2735997829&simid=83592992,935505849&pn=230&rn=1&di=51606847270&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=b4&objurl=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fa8773912b31bb0512211a8d9347adab44aede00e.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3445190730,1948150448&os=1599560082,3615752837&simid=0,0&pn=266&rn=1&di=217505119260&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=d2&objurl=http%3A%2F%2Fimg.article.pchome.net%2F00%2F40%2F23%2F91%2Fpic_lib%2Fs960x639%2FZhuoku012s960x639.jpg&rpstart=0&rpnum=0&adpicid=0");
//        MainDataEntity newEntity3 = new MainDataEntity ("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2159989106,3526791124&fm=26&gp=0.jpg", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2263956994,1370962370&os=3482962655,3878497456&simid=4150691715,676820019&pn=91&rn=1&di=100729314840&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=3c&objurl=http%3A%2F%2Fimage.17173.com%2Fbbs%2Fv1%2F2010%2F09%2F08%2F1283947526539.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3143213859,4199303994&os=3558792314,2735997829&simid=83592992,935505849&pn=230&rn=1&di=51606847270&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=b4&objurl=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fa8773912b31bb0512211a8d9347adab44aede00e.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3445190730,1948150448&os=1599560082,3615752837&simid=0,0&pn=266&rn=1&di=217505119260&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=d2&objurl=http%3A%2F%2Fimg.article.pchome.net%2F00%2F40%2F23%2F91%2Fpic_lib%2Fs960x639%2FZhuoku012s960x639.jpg&rpstart=0&rpnum=0&adpicid=0");
//        MainDataEntity newEntity4 = new MainDataEntity ("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2159989106,3526791124&fm=26&gp=0.jpg", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2263956994,1370962370&os=3482962655,3878497456&simid=4150691715,676820019&pn=91&rn=1&di=100729314840&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=3c&objurl=http%3A%2F%2Fimage.17173.com%2Fbbs%2Fv1%2F2010%2F09%2F08%2F1283947526539.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3143213859,4199303994&os=3558792314,2735997829&simid=83592992,935505849&pn=230&rn=1&di=51606847270&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=b4&objurl=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fa8773912b31bb0512211a8d9347adab44aede00e.jpg&rpstart=0&rpnum=0&adpicid=0", "http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%A3%81%E7%BA%B8&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=3445190730,1948150448&os=1599560082,3615752837&simid=0,0&pn=266&rn=1&di=217505119260&ln=3556&fr=&fmq=1545192484777_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=d2&objurl=http%3A%2F%2Fimg.article.pchome.net%2F00%2F40%2F23%2F91%2Fpic_lib%2Fs960x639%2FZhuoku012s960x639.jpg&rpstart=0&rpnum=0&adpicid=0");
//
//
//        entities.add (newEntity);
//        entities.add (newEntity4);
//        entities.add (newEntity2);
//        entities.add (newEntity3);
//        //去网络请求数据
//
//        listAdapter = new MainAdapter (entities);
////        list.setLayoutManager (new LinearLayoutManager (this));线性布局 从上到下的列表
//        recyclerView.setLayoutManager (new GridLayoutManager (this, 3)); //表哥布局 一行x个
//        recyclerView.setAdapter (listAdapter);

    }

    @OnClick({R.id.recyclerView, R.id.refreshLayout})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.recyclerView:
                break;
            case R.id.refreshLayout:
                break;
        }
    }
    /**
     * 模拟数据
     */
    private Collection<Model> loadModels() {
        return Arrays.asList(
                new Model () {{
                    this.name = "但家香酥鸭";
                    this.nickname = "爱过那张脸";
                    this.imageId = R.mipmap.image_practice_repast_1;
                    this.avatarId = R.mipmap.image_avatar_1;
                }}, new Model () {{
                    this.name = "香菇蒸鸟蛋";
                    this.nickname = "淑女算个鸟";
                    this.imageId = R.mipmap.image_practice_repast_2;
                    this.avatarId = R.mipmap.image_avatar_2;
                }}, new Model () {{
                    this.name = "花溪牛肉粉";
                    this.nickname = "性感妩媚";
                    this.imageId = R.mipmap.image_practice_repast_3;
                    this.avatarId = R.mipmap.image_avatar_3;
                }}, new Model () {{
                    this.name = "破酥包";
                    this.nickname = "一丝丝纯真";
                    this.imageId = R.mipmap.image_practice_repast_4;
                    this.avatarId = R.mipmap.image_avatar_4;
                }}, new Model () {{
                    this.name = "盐菜饭";
                    this.nickname = "等着你回来";
                    this.imageId = R.mipmap.image_practice_repast_5;
                    this.avatarId = R.mipmap.image_avatar_5;
                }}, new Model () {{
                    this.name = "米豆腐";
                    this.nickname = "宝宝树人";
                    this.imageId = R.mipmap.image_practice_repast_6;
                    this.avatarId = R.mipmap.image_avatar_6;
                }});
    }
}