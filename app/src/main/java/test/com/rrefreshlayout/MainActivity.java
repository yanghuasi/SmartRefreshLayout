package test.com.rrefreshlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.com.rrefreshlayout.activity.BannerActivity;
import test.com.rrefreshlayout.activity.ClassicActivity;
import test.com.rrefreshlayout.activity.QQBrowserActivity;
import test.com.rrefreshlayout.activity.RefreshExampleActivity;
import test.com.rrefreshlayout.activity.RefreshPracticeActivity;
import test.com.rrefreshlayout.activity.SecondFloorFragment;
import test.com.rrefreshlayout.activity.SimpleActivity;
import test.com.rrefreshlayout.activity.StylesActivity;
import test.com.rrefreshlayout.adapter.activity.AdapterActivity;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.simple)
    Button simple;
    @BindView(R.id.mode_one)
    Button modeOne;
    @BindView(R.id.mode_two)
    Button modeTwo;
    @BindView(R.id.mode_three)
    Button modeThree;
    @BindView(R.id.refreshLayout)
    LinearLayout refreshLayout;
    @BindView(R.id.adapter)
    Button adapter;
    @BindView(R.id.mode_four)
    Button modeFour;
    @BindView(R.id.mode_five)
    Button modeFive;
    @BindView(R.id.mode_six)
    Button modeSix;
    @BindView(R.id.mode_seven)
    Button modeSeven;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        ButterKnife.bind (this);

    }

    @OnClick({R.id.simple, R.id.mode_one, R.id.mode_two, R.id.mode_three, R.id.adapter, R.id.mode_four,R.id.mode_five, R.id.mode_six, R.id.mode_seven})
    public void onViewClicked(View view) {
        switch (view.getId ()) {
            case R.id.simple:
                startActivity (new Intent (MainActivity.this, SimpleActivity.class));
                break;
            case R.id.mode_one:
                startActivity (new Intent (MainActivity.this, ClassicActivity.class));
                break;
            case R.id.mode_two:
                startActivity (new Intent (MainActivity.this, BannerActivity.class));
                break;
            case R.id.mode_three:
                startActivity (new Intent (MainActivity.this, QQBrowserActivity.class));
                break;
            case R.id.mode_four:
                startActivity (new Intent (MainActivity.this, SecondFloorFragment.class));
                break;
            case R.id.mode_five:
                startActivity (new Intent (MainActivity.this, RefreshPracticeActivity.class));
                break;
            case R.id.mode_six:
                startActivity (new Intent (MainActivity.this, RefreshExampleActivity.class));
                break;
            case  R.id.mode_seven:
                startActivity (new Intent (MainActivity.this, StylesActivity.class));
                break;
            case R.id.adapter:
                startActivity (new Intent (MainActivity.this, AdapterActivity.class));
                break;
        }
    }


}
