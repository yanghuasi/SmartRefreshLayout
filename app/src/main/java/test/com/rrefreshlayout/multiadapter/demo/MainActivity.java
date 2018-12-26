package test.com.rrefreshlayout.multiadapter.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.adapter.dataentity.Model;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Model> datas01;
    private List<MyMultipleItem> datas02;
    private MultipleItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        //初始化RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //模拟的假数据（实际开发中当然是从网络获取数据）
        datas01 = new ArrayList<> ();
        Model model;
        for (int i = 0; i < 30; i++) {
            model = new Model();
            model.setTitle("我是第" + i + "条标题");
            model.setContent("第" + i + "条内容");
            datas01.add(model);
        }

        String json = JSON.toJSONString (datas01);
        JSONObject jsonObject = JSONObject.parseObject (json);



        datas02 = new ArrayList<>();
        //这里我是随机给某一条目加载不同的布局
        for (int i = 0; i < 30; i++) {
            if (i / 3 == 1) {
                datas02.add(new MyMultipleItem(MyMultipleItem.FIRST_TYPE, null));
            } else if (i / 7 == 1) {
                datas02.add(new MyMultipleItem(MyMultipleItem.SECOND_TYPE, null));
            } else {
                datas02.add(new MyMultipleItem(MyMultipleItem.NORMAL_TYPE, datas01.get(i)));
            }

        }

        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //纵向布局
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new MultipleItemAdapter(datas02);

        //给RecyclerView设置适配器
        recyclerView.setAdapter(adapter);
    }
}

