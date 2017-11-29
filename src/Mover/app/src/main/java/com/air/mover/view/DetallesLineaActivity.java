package com.air.mover.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.air.mover.R;
import com.air.mover.dao.model.Parada;
import com.air.mover.presenter.ListParadasLineaPresenter;

public class DetallesLineaActivity extends AppCompatActivity implements  ListParadasLineaAdapter.ItemClickListener, SearchView.OnQueryTextListener{

    ListParadasLineaAdapter adapterParadasLinea;
    ListParadasLineaPresenter listParadasLineaPresenter;
    private ProgressDialog dialog;
    private SearchView searchParadasLinea;
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

        // Crear el recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaParadasLinea);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterParadasLinea = new ListParadasLineaAdapter(this);
        adapterParadasLinea.setClickListener(this);
        recyclerView.setAdapter(adapterParadasLinea);

        listParadasLineaPresenter= new ListParadasLineaPresenter(this, adapterParadasLinea, identificadorLinea);

        tituloParadasPorLinea= (TextView) findViewById(R.id.tituloParadasLinea);
        tituloParadasPorLinea.setText("Linea "+ numeroLinea +"\n"+nombreLinea);

        searchParadasLinea= (SearchView) findViewById(R.id.searchParadasLinea);
        searchParadasLinea.setQueryHint("\f"+getResources().getString(R.string.search_paradas_lineas));
        searchParadasLinea.setOnQueryTextListener(this);
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
        Parada parada = adapterParadasLinea.getItem(position);
        Intent intent = new Intent(this, DetallesParadaActivity.class);
        intent.putExtra("nombre", parada.getNombre());
        intent.putExtra("posX", parada.getPosX());
        intent.putExtra("posY", parada.getPosY());
        intent.putExtra("numero", parada.getNumParada());
        Log.d("[Parada pulsada] ==> ", parada.getNombre());
        startActivity(intent);
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

    /**
     * Metodo que se ejecuta cuando el usuario pulsa la tecla de confirmacion de busqueda.
     * El metodo se encarga de cerrar el teclado emergente en el momento de la busqueda
     *
     * @param textoDeFiltraje texto existente en el campo de busqueda al momento de confirmar la busqueda
     * @return true siempre puesto que la accion siempre es manejada
     */
    @Override
    public boolean onQueryTextSubmit(String textoDeFiltraje)
    {
        searchParadasLinea.clearFocus();
        return true;
    }//onQueryTextSubmit

    /**
     * Metodo que se ejecuta cada vez que el usuario modifica el texto del campo de busqueda.
     * El metodo se encarga de actualizar la vista mostrando tan solo aquellas paradas que coincidan
     * con el texto modificado.
     *
     * @param newText nuevo texto para realizar el filtraje de paradas
     * @return true siempre puesto que la accion siempre es manejada
     */
    @Override
    public boolean onQueryTextChange(String newText)
    {
        adapterParadasLinea.filter(newText);
        return true;
    }//onQueryTextChange
}
