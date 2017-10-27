package com.air.mover.View;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.air.mover.R;
import com.air.mover.View.DireccionesFragments.DireccionesFragment;
import com.air.mover.View.LineasFragments.LineasFragment;
import com.air.mover.View.ParadasFragments.ParadasFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{

    private FragmentTabHost mTabHost;
    // private FrameLayout frameLayout;
    private BottomNavigationView mBottomBar;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mTabHost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);


        mTabHost.addTab(mTabHost.newTabSpec("tab_lineas").setIndicator("Lineas"),LineasFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_paradas").setIndicator("Paradas"),ParadasFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_direcciones").setIndicator("Direcciones"),DireccionesFragment.class,null);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent2);*/

        mBottomBar = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomBar.setOnNavigationItemSelectedListener(this);

        frameLayout = (FrameLayout) findViewById(R.id.frame_main);
        LineasFragment lf = new LineasFragment();
        lf.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.frame_main, lf).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_buscar:
                DireccionesFragment df = new DireccionesFragment();
                df.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, df).commit();
                break;

            case R.id.action_paradas:
                ParadasFragment pf = new ParadasFragment();
                pf.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, pf).commit();
                break;

            case R.id.action_lineas:
                LineasFragment lf = new LineasFragment();
                lf.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, lf).commit();
                break;

        }
        return true;
    }
}
