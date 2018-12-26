package test.com.rrefreshlayout.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.activity.SecondFloorFragment;

public class FragmentActivity extends Activity{
    private SecondFloorFragment secondFloorFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.fragment_secondfloor);
    }

    //activity跳转到fragment
//    @Override
//    protected void onResume() {
//        int id = getIntent().getIntExtra("id", 0);
//        if (id == 2) {
//            SecondFloorFragment secondFloorFragment = new SecondFloorFragment();
//            FragmentManager secondFloorFragment = getSupportFragmentManager();
//            FragmentTransaction transaction = secondFloorFragment.beginTransaction();
//            transaction.replace(R.id.viewpager, fragmen);
//            transaction.commit();
//            mViewPager.setCurrentItem(2);//
//            //帮助跳转到指定子fragment
//            Intent i=new Intent();
//            i.setClass(FragmentActivity.this,SecondFloorFragment.class);
//            i.putExtra("id",2);
//        }
//        super.onResume();
//    }
}
