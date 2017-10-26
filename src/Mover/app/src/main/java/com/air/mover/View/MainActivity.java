package com.air.mover.View;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.air.mover.R;
import com.air.mover.View.DireccionesFragments.DireccionesFragment;
import com.air.mover.View.LineasFragments.LineasFragment;
import com.air.mover.View.ParadasFragments.ParadasFragment;

public class MainActivity extends AppCompatActivity
{

    private FragmentTabHost mTabHost;
    // private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);


        mTabHost.addTab(mTabHost.newTabSpec("tab_lineas").setIndicator("Lineas"),LineasFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_paradas").setIndicator("Paradas"),ParadasFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_direcciones").setIndicator("Direcciones"),DireccionesFragment.class,null);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent2);

    }

}
