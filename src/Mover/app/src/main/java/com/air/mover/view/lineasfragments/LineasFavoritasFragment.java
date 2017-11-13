package com.air.mover.view.lineasfragments;


import android.os.Bundle;
import com.air.mover.R;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 *  Esta clase se encarga de definir y gestionar la vista correspondiente al fragmento lineas favoritas de la aplicacion
 * @version 30/10/17
 */
public class LineasFavoritasFragment extends Fragment
{

    /**
     * Metodo que se ejecuta cuando se dibuja por primera vez el fragment en la
     * interfaz de usuario. Se encarga de asociar el fragment con su vista y de
     * retornar dicha vista.
     *
     * @param inflater permite crear una vista a partir de un layout XML
     * @param container vista padre o contenedor donde sera insertado nuestro fragment
     * @param savedInstanceState permite recuperar el estado de una instancia anterior de nuestro fragment
     * @return vista creada para el fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_lineas_favoritas_fragment, container, false);
    }//onCreateView
}
