package com.my.qiubaiui;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import com.my.qiubaiui.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private SlidingPaneLayout drawer;
    private NavigationView menu;
    private ViewPager pager;
    private TabLayout tab;
    private List<String> list;
    private MyAdapter adapter;
    private static int ITEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (SlidingPaneLayout) findViewById(R.id.drawer);
        menu = (NavigationView) findViewById(R.id.menu);
        menu.setNavigationItemSelectedListener(this);

        pager = (ViewPager) findViewById(R.id.pager);
        list = new ArrayList<>();

        list.add("专享");
        list.add("视频");
        list.add("纯文");
        list.add("纯图");
        list.add("最新");

        adapter = new MyAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);

        tab = (TabLayout) findViewById(R.id.tab);
        tab.setupWithViewPager(pager);

        pager.addOnPageChangeListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_1:
                ITEM = 1;

                list.clear();
                list.add("专享");
                list.add("视频");
                list.add("纯文");
                list.add("纯图");
                list.add("最新");
                break;
            case R.id.item_2:
                ITEM = 2;
                list.clear();
                list.add("隔壁");
                list.add("已粉");
                list.add("话题");
                break;
            case R.id.item_3:
                list.clear();
                break;
            case R.id.item_4:
                list.clear();
                break;
            case R.id.item_5:
                list.clear();
                break;
            case R.id.item_6:
                ActivityCompat.finishAffinity(this);
                break;
        }

        adapter.notifyDataSetChanged();
        tab.setupWithViewPager(pager);
        drawer.closePane();

        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                Log.d("MainActivity","page 0");
                break;
            case 1:
                Log.d("MainActivity","page 1");
                break;
            case 2:
                Log.d("MainActivity","page 2");
                break;
            case 3:
                Log.d("MainActivity","page 3");
                break;
            case 4:
                Log.d("MainActivity","page 4");
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
