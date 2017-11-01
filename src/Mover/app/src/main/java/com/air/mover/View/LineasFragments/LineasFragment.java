package com.air.mover.View.LineasFragments;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.air.mover.R;

/**
 *  Esta clase se encarga de definir y gestionar la vista correspondiente al fragmento lineas de la aplicacion
 * @version 30/10/17
 */
public class LineasFragment extends Fragment
{
    FragmentTabHost mTabHost; //TabHost donde se definiran las pestanas del fragmento

    /**
     * Metodo que se ejecuta cuando se dibuja por primera vez el fragment en la
     * interfaz de usuario. Se encarga de asociar el fragment con su vista y de
     * retornar dicha vista.
     *
     * @param inflater permite crear una vista a partir de un layout XML
     * @param container vista padre o contenedor donde sera insertado nuestro fragment
     * @param savedInstance permite recuperar posibles valores guardados de una instancia anterior de nuestro fragment
     * @return vista creada para el fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        super.onCreate(savedInstance);

        View view = inflater.inflate(R.layout.activity_lineas_fragment, container, false);

        mTabHost = (FragmentTabHost)view.findViewById(R.id.tabhost_lineas);

        //Configuramos el frame que contendra el contenido de la pestana
        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        //Anadimos las pestanas de nuestro tanHost

        Resources r= getResources();
        mTabHost.addTab(mTabHost.newTabSpec("tab_todas").setIndicator(r.getString(R.string.cont_tab_todas)), LineasTodasFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_favoritas").setIndicator(r.getString(R.string.cont_tab_favoritas)), LineasFavoritasFragment.class, null);

        //Modificamos la ubicacion de las pestanas en la interfaz
        mTabHost.getTabWidget().getChildTabViewAt(0).getLayoutParams().height = (int) (30 * r.getDisplayMetrics().density);
        mTabHost.getTabWidget().getChildTabViewAt(1).getLayoutParams().height = (int) (30 * r.getDisplayMetrics().density);

        return view;

    }//onCreateView


    /**
     * Metodo que es ejecutado cuando la jerarquia de views a la cual ha sido asociado el
     * fragment ha sido destruida. Se encarga de destruir la view del fragment y liberar recursos
     */
   @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        mTabHost=null;

    }//onDestroyView
}
