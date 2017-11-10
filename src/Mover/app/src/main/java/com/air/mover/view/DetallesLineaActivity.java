package com.air.mover.view;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.air.mover.R;
import com.air.mover.dao.model.Parada;
import com.air.mover.presenter.ListParadasLineaPresenter;

import java.util.ArrayList;
import java.util.List;

public class DetallesLineaActivity extends AppCompatActivity implements  ListParadasLineaAdapter.ItemClickListener{

    ListParadasLineaAdapter adapter;
    ListParadasLineaPresenter listParadasLineaPresenter;
    private ProgressDialog dialog;
    TextView tituloParadasPorLinea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_linea);

        //Ocultamos el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        dialog= new ProgressDialog(this);

        int identificadorLinea= getIntent().getIntExtra("identificadorLinea", 60);
        String numeroLinea= getIntent().getStringExtra("numeroLinea");
        String nombreLinea= getIntent().getStringExtra("nombreLinea");

        //Esto es una parada de prueba que dejo porque no van las API y queda hacer el presenter / DAO.
        List<Parada> list = new ArrayList<>();



        // Crear el recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaParadasLinea);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListParadasLineaAdapter(this, list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        listParadasLineaPresenter= new ListParadasLineaPresenter(this, adapter, identificadorLinea);

        tituloParadasPorLinea= (TextView) findViewById(R.id.tituloParadasLinea);
        tituloParadasPorLinea.setText("Linea "+ numeroLinea +"\n"+nombreLinea);

    }

    /**
     * Metodo que se ejecuta cuando el usuario regresa a la actividad
     * para interactuar con ella. Invoca al presenter de lineas del TUS para que gestione la view
     */
    @Override
    public void onResume()
    {
        super.onResume();
        this.listParadasLineaPresenter.start();
    }//onResume


    /**
     * Metodo para manejar los clics en las paradas.
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        Log.d("[Parada]","Parada pulsada");
    }

    /**
     * Este método cuando es llamado se encarga de mostrar un progressDialog
     * @param state si es true pone el progressDialog en la interfaz, si es false lo cancela
     */
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
}
