package com.air.mover.view.paradasfragments;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.air.mover.R;
import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;
import com.air.mover.view.callbacks.CallbackParadasLinea;

/**
 *  Esta clase se encarga de definir y gestionar la vista correspondiente al fragmento paradas de la aplicacion
 * @version 30/10/17
 */
public class ParadasFragment extends Fragment implements CallbackParadasLinea
{
    FragmentTabHost mTabHost; //TabHost donde se definiran las pestanas del fragmento
    CallbackParadasLinea callback; //Manejador del clic en una parada.

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
        View view = inflater.inflate(R.layout.activity_paradas_fragment, container, false);

        mTabHost = (FragmentTabHost)view.findViewById(R.id.tabhost_paradas);

        //Configuramos el frame que contendra el contenido de la pestana
        mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        //Anadimos las pestanas de nuestro tanHost
        Resources r= getResources();
        mTabHost.addTab(mTabHost.newTabSpec("tab_todas").setIndicator(r.getString(R.string.cont_tab_todas)), ParadasTodasFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_favoritas").setIndicator(r.getString(R.string.cont_tab_favoritas)), ParadasFavoritasFragment.class, null);

        //Modificamos la ubicacion de las pestanas en la interfaz
        mTabHost.getTabWidget().getChildTabViewAt(0).getLayoutParams().height = (int) (30 * r.getDisplayMetrics().density);
        mTabHost.getTabWidget().getChildTabViewAt(1).getLayoutParams().height = (int) (30 * r.getDisplayMetrics().density);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  CallbackParadasLinea) {
            callback = (CallbackParadasLinea) context;
        } else {
            Log.e("Error", "El contexto no es implementa el callback necesario.");
        }
    }

    /**
     * Metodo que es ejecutado cuando la jerarquia de views a la cual ha sido asociado el
     * fragment ha sido destruida. Se encarga de destruir la view del fragment y liberar recursos
     */
    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        mTabHost=null;
    }

    @Override
    public void callback(Linea linea) {
         //No hace nada en este fragment
    }

    /**
     * Se ejecuta cuando se ha pulsado una parada. Sube la acción a la MainActivity para que lo
     * maneje.
     * @param parada
     */
    @Override
    public void callbackParada(Parada parada) {
        callback.callbackParada(parada);
    }
}
