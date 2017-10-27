package com.air.mover.View.LineasFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.air.mover.R;

public class LineasFragment extends Fragment
{
    FragmentTabHost mTabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        //super.onCreate(savedInstance);
        //mTabHost= new FragmentTabHost(getActivity());
        View view = inflater.inflate(R.layout.activity_lineas_fragment, container, false);

        mTabHost = (FragmentTabHost)view.findViewById(R.id.tabhost_lineas);
        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        //Create child tab1
        mTabHost.addTab(mTabHost.newTabSpec("tab_todas").setIndicator("Todas"), LineasTodasFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_favoritas").setIndicator("Favoritas"), LineasFavoritasFragment.class, null);


        mTabHost.getTabWidget().getChildTabViewAt(0).getLayoutParams().height = (int) (30 * this.getResources().getDisplayMetrics().density);
        mTabHost.getTabWidget().getChildTabViewAt(1).getLayoutParams().height = (int) (30 * this.getResources().getDisplayMetrics().density);
        return view;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        mTabHost=null;
    }
}
