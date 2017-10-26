package com.air.mover.View.LineasFragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.air.mover.DAO.Model.Linea;
import com.air.mover.Presenter.ListLineasPresenter;
import com.air.mover.R;
import com.air.mover.View.DataCommunication;
import com.air.mover.View.IListLineasView;
import com.air.mover.View.ListLineasAdapter;

import java.util.List;

public class LineasTodasFragment extends ListFragment implements IListLineasView
{
    private DataCommunication dataCommunication;
    private ProgressDialog dialog;
    private ListLineasPresenter listLineasPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_lineas_todas_fragment, container, false);
        return rootView;
    }

    //Es como el OnCreate para nosotros
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.listLineasPresenter = new ListLineasPresenter(getContext(),this);
        dialog= new ProgressDialog(getContext());

    }

    @Override
    public void onResume() {
        this.listLineasPresenter.start();   // Se pone en el onResume
        super.onResume();
    }
    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        Log.d("pulsado", ""+position);
        //Haciendo uso de la interfaz DataCommunication podemos enviar los datos entre fragmentos
        //Ejemplo:
        //dataCommunication = (DataCommunication) getContext();
        //dataCommunication.setLineaIdentifier(datosBuses.getListaLineasBus().get(position).getIdentifier());
    }

    @Override
    public void showList(List<Linea> lineaList) {
        ListLineasAdapter listLineasAdapter = new ListLineasAdapter(getContext(), lineaList);
        getListView().setAdapter(listLineasAdapter);
        getListView().deferNotifyDataSetChanged();
    }

    /**
     * Este método cuando es llamado se encarga de mostrar un progressDialog
     * @param state si es true pone el progressDialog en la interfaz, si es false lo cancela
     */
    @Override
    public void showProgress (boolean state)
    {
        if(state==true)
        {
            dialog.setMessage("Cargando datos");
            dialog.show();
        }
        else
        {
            dialog.cancel();
        }
    }
}