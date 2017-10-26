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
        mTabHost= new FragmentTabHost(getActivity());

        mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.activity_lineas_fragment);

        //Create child tab1
        mTabHost.addTab(mTabHost.newTabSpec("tab_todas").setIndicator("Todas"), LineasTodasFragment.class, null);

        mTabHost.addTab(mTabHost.newTabSpec("tab_favoritas").setIndicator("Favoritas"), LineasFavoritasFragment.class, null);


        return mTabHost;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        mTabHost=null;
    }
}
