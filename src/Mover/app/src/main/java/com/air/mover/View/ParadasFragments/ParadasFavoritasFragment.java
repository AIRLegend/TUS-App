package com.air.mover.View.ParadasFragments;

import android.os.Bundle;

import com.air.mover.R;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ParadasFavoritasFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_paradas_favoritas_fragment, container, false);
        return rootView;
    }
}
