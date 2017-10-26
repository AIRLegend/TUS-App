package com.air.mover.View.LineasFragments;


import android.os.Bundle;

import com.air.mover.R;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LineasFavoritasFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_lineas_favoritas_fragment, container, false);
        return rootView;
    }
}
