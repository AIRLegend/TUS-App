package com.air.mover.view.lineasfragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.air.mover.dao.model.Linea;
import com.air.mover.presenter.ListLineasPresenter;
import com.air.mover.R;
import com.air.mover.view.IListLineasView;
import com.air.mover.view.ListLineasAdapter;
import com.air.mover.view.callbacks.CallbackParadasLinea;

import java.util.List;

/**
 *  Esta clase se encarga de definir y gestionar la vista correspondiente al fragmento donde se muestran
 *  todas las lineas de TUS
 *
 * @version 30/10/17
 */
public class LineasTodasFragment extends ListFragment implements IListLineasView
{
    private ProgressDialog dialog;
    private ListLineasPresenter listLineasPresenter;
    private CallbackParadasLinea callback;
    /**
     * Este metodo se añade el fragment a la vista superior. Aqui se comprueba si la activity o
     * fragment superior implementa el Callback que se necesita.
     * NOTA: Para este fragment la sucesion de llamadas es:
     *  LineasTodasFragment -> LineasFragment -> MainActivity.
     * @param context contexto
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof CallbackParadasLinea) {
            callback = (CallbackParadasLinea) getParentFragment();
        }
    }

    /**
     * Metodo que se ejecuta cuando se dibuja por primera vez el fragment en la
     * interfaz de usuario. Se encarga de asociar el fragment con su vista y de
     * retornar dicha vista.
     *
     * @param inflater permite crear una vista a partir de un layout XML
     * @param container vista padre o contenedor donde sera insertado nuestro fragment
     * @param savedInstanceState permite recuperar el estado de una instancia anterior de nuestro fragment
     *
     * @return vista creada para el fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_lineas_todas_fragment, container, false);
    }//onCreateView

    /**
     * Metodo que se ejecutara cuando la actividad contenedora del fragment
     * este completamente creada. Se encargara de inicializar los atributos
     * de la actividad.
     *
     * @param savedInstanceState permite recuperar el estado de una instancia anterior de nuestro fragment
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.listLineasPresenter = new ListLineasPresenter(this);
        dialog= new ProgressDialog(getContext());

        if (getParentFragment() instanceof LineasFragment) {
            ((LineasFragment)getParentFragment()).setLineasListPresenter(listLineasPresenter);
        }

    }//onActivityCreated

    /**
     * Metodo que se ejecuta cuando el usuario regresa a la actividad
     * para interactuar con ella. Invoca al presenter de lineas del TUS para que gestione la view
     */
    @Override
    public void onResume()
    {
        super.onResume();
        this.listLineasPresenter.start();
    }//onResume

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        Log.d("pulsado", Integer.toString(position));
        callback.callback((Linea)listView.getAdapter().getItem(position));
    }//onListItemClick

    /**
     * Metodo que se encarga de mostrar por la interfaz las lineas de TUS
     * pasadas por parametro
     *
     * @param lineaList linea de TUS a mostrar
     */
    @Override
    public void showList(List<Linea> lineaList) {
        ListLineasAdapter listLineasAdapter = new ListLineasAdapter(getContext(), lineaList);
        getListView().setAdapter(listLineasAdapter);
        getListView().deferNotifyDataSetChanged();
    }//showList

    /**
     * Este método cuando es llamado se encarga de mostrar un progressDialog
     * @param state si es true pone el progressDialog en la interfaz, si es false lo cancela
     */
    @Override
    public void showProgress (boolean state)
    {
        if(state)
        {
            dialog.setMessage("Cargando datos");
            dialog.show();
        }//if
        else
        {
            dialog.cancel();
        }//else
    }//showProgress

    public CallbackParadasLinea getCallback()
    {
        return callback;
    }//getCallback

    public void setCallback(CallbackParadasLinea c)
    {
        this.callback=c;
    }//setCallback
}