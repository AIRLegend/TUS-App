package com.air.mover.View;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TabHost;

import com.air.mover.R;

public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener
{

    private FragmentTabHost mTabHost;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        //frameLayout = (FrameLayout) findViewById(android.R.id.tabcontent);
        mTabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab_lineas").setIndicator("Lineas"),LineasFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_paradas").setIndicator("Paradas"),ParadasFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_direcciones").setIndicator("Direcciones"),DireccionesFragment.class,null);

        mTabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onTabChanged(String tabId)
    {
        switch (tabId)
        {
        }
    }
}
