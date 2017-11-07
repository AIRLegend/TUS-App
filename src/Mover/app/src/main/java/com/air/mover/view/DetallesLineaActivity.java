package com.air.mover.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.air.mover.R;
import com.air.mover.dao.Model.Parada;

import java.util.ArrayList;
import java.util.List;

public class DetallesLineaActivity extends AppCompatActivity implements  ListParadasLineaAdapter.ItemClickListener{

    ListParadasLineaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_linea);

        //Ocultamos el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //Esto es una parada de prueba que dejo porque no van las API y queda hacer el presenter / DAO.
        List<Parada> list = new ArrayList<>();
        list.add(new Parada("PARADA2", 1, 1, 12));


        // Crear el recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaParadasLinea);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListParadasLineaAdapter(this, list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Metodo para manejar los clics en las paradas.
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        Log.d("[Parada]","Parada pulsada");
    }
}
