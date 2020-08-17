package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //创建一个viewpager容器对象
    private ViewPager viewpager;
    private ArrayList<View> pages;
    private MyPagerAdapter myPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到需要的容器对象
        initView();
        //获得要装载的数据页面
        getPages();
        //将集合页面装载到MyPagerAapter适配器中，定义在另外一个单独的文件中,需要传入当前上下文对象和页面数据集合，并且将适配器绑定在
        setAdapter();
    }

    //初始化组件
    public void initView() {
        viewpager = findViewById(R.id.viewpager);
    }

    //获得数据源
    public void getPages() {
        //自定义三个页面
        pages = new ArrayList<View>();
        //将布局文件转换为对象
        View page1 = LayoutInflater.from(this).inflate(R.layout.page1, null);
        View page2 = LayoutInflater.from(this).inflate(R.layout.page2, null);
        View page3 = LayoutInflater.from(this).inflate(R.layout.page3, null);
        View page4 = LayoutInflater.from(this).inflate(R.layout.page4, null);
        //将所有页面对象添加到集合对象中
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);
    }

    //设置适配器
    public void setAdapter() {
        myPagerAdapter = new MyPagerAdapter(this, pages);
        viewpager.setAdapter(myPagerAdapter);
    }
}