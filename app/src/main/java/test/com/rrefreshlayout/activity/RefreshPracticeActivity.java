package test.com.rrefreshlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.Arrays;
import java.util.Collection;

import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.adapter.BaseRecyclerAdapter;
import test.com.rrefreshlayout.adapter.SmartViewHolder;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class RefreshPracticeActivity extends AppCompatActivity {
    private class Model {
        int imageId;
        int avatarId;
        String name;
        String nickname;
    }
    private RecyclerView recyclerView;
    private BaseRecyclerAdapter<Model> listAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_refresh_practice);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);

        recyclerView=(RecyclerView)findViewById (R.id.recyclerView) ;

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
        //修饰recyclerView
        recyclerView.addItemDecoration(new DividerItemDecoration (this, VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
        recyclerView.setAdapter(listAdapter);
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

