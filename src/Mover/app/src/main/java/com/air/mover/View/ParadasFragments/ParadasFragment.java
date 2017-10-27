package com.air.mover.View.ParadasFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.air.mover.R;

public class ParadasFragment extends Fragment
{
    FragmentTabHost mTabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        //mTabHost= new FragmentTabHost(getActivity());

        //mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.activity_paradas_fragment);

        View view = inflater.inflate(R.layout.activity_paradas_fragment, container, false);

        mTabHost = (FragmentTabHost)view.findViewById(R.id.tabhost_paradas);
        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        //Create child tab1
        mTabHost.addTab(mTabHost.newTabSpec("tab_todas").setIndicator("Todas"), ParadasTodasFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_favoritas").setIndicator("Favoritas"), ParadasFavoritasFragment.class, null);

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
