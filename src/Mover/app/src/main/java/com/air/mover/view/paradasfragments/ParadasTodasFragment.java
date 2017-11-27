package com.air.mover.view.paradasfragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.air.mover.R;
import com.air.mover.dao.model.Parada;
import com.air.mover.presenter.ListParadasLineaPresenter;
import com.air.mover.view.IListParadasView;
import com.air.mover.view.ListParadasLineaAdapter;
import com.air.mover.view.callbacks.CallbackParadasLinea;
import java.util.List;

/**
 *  Esta clase se encarga de definir y gestionar la vista correspondiente al fragmento paradas todas de la aplicacion
 * @version 30/10/17
 */
public class ParadasTodasFragment extends Fragment implements IListParadasView, ListParadasLineaAdapter.ItemClickListener
{

    private ProgressDialog dialog;
    private ListParadasLineaAdapter paradasAdapter;
    private ListParadasLineaPresenter paradasLineaPresenter;
    private Context context;
    private RecyclerView recyclerView;
    private CallbackParadasLinea callback;

    /**
     * Metodo que se ejecuta cuando se dibuja por primera vez el fragment en la
     * interfaz de usuario. Se encarga de asociar el fragment con su vista y de
     * retornar dicha vista.
     *
     * @param inflater permite crear una vista a partir de un layout XML
     * @param container vista padre o contenedor donde sera insertado nuestro fragment
     * @param savedInstanceState permite recuperar el estado guardado de una instancia anterior de nuestro fragment
     * @return vista creada para el fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = container.getContext();

        View v =  inflater.inflate(R.layout.activity_paradas_todas_fragment, container, false);

        // Crear el recyclerview
        recyclerView = (RecyclerView) v.findViewById(R.id.lista_paradas);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        paradasAdapter = new ListParadasLineaAdapter(context);
        recyclerView.setAdapter(paradasAdapter);
        paradasAdapter.setClickListener(this);

        paradasLineaPresenter = new ListParadasLineaPresenter(v.getContext(), paradasAdapter);
        paradasLineaPresenter.setListParadasTodasView(this);
        return v;
    }

    /**
     * Metodo que se ejcuta al iniciar la actividad (crear el fragment)
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialog = new ProgressDialog(context);
    }


    /**
     * Este metodo se añade el fragment a la vista superior. Aqui se comprueba si la activity o
     * fragment superior implementa el Callback que se necesita.
     * NOTA: Para este fragment la sucesion de llamadas es:
     *  ParadasTodas -> ParadasFragment -> MainActivity.
     * @param context contexto
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  CallbackParadasLinea) {
            callback = (CallbackParadasLinea) context;
        } else {
            Log.e("Error", "El contexto no es implementa el callback necesario.");
        }
    }//onAttach


    /**
     * Se ejecuta al resumir la actividad y justo después de crearla.
     */
    @Override
    public void onResume() {
        super.onResume();
        paradasLineaPresenter.start();

    }

    /**
     * Muestra una lista de paradas por pantalla
     * @param paradaList
     */
    @Override
    public void showList(List<Parada> paradaList) {
        ListParadasLineaAdapter listParadasAdapter = new ListParadasLineaAdapter(context);
        recyclerView.setAdapter(listParadasAdapter);

    }

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

    /**
     * Metodo para manejar el clic de un item. Llama al callback para que vaya subiendo la
     * señan hasta la activity padre.
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        Log.d("pulsado", Integer.toString(position));
        callback.callbackParada(paradasAdapter.getItem(position));
    }//onItemClick
}
