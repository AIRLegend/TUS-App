package com.air.mover.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.air.mover.R;
import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;
import com.air.mover.view.direccionesfragments.DireccionesFragment;
import com.air.mover.view.lineasfragments.LineasFragment;
import com.air.mover.view.paradasfragments.ParadasFragment;
import com.air.mover.view.callbacks.CallbackParadasLinea;

import java.io.Serializable;

/**
 *  Esta clase se encarga de definir y gestionar la vista principal de la aplicacion
 *
 *  @version 29/10/17
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        CallbackParadasLinea, Serializable
{
    private transient BottomNavigationView mBottomBar;

    //Para controlar si se ha cambiado de actividad. Asi no se puede lanzar dos veces
    private boolean isChangingActivity ;

    /**
     * Metodo que se ejecuta cuando se crea la activity. Se encarga
     * de asociar la activity con su vista asi como de la gestion de esta
     *
     * @param savedInstanceState estado mas reciente de la activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Ocultamos el ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //Asociamos el contenido de la activity a la vista definida en xml
        setContentView(R.layout.activity_main);


        mBottomBar = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomBar.setOnNavigationItemSelectedListener(this);

        //Inicialmente se mostrara la opcion de las lineas de TUS
        LineasFragment lf = new LineasFragment();
        lf.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, lf).commit();

        isChangingActivity = false;

    } //onCreate

    /**
     * Metodo que indica que accion realizar cuando se seleccione el item indicado en el menu
     * @param item item seleccionado
     * @return true si el evento fue manejado
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_buscar:
                DireccionesFragment df = new DireccionesFragment();
                df.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, df).commit();
                break;

            case R.id.action_paradas:
                ParadasFragment pf = new ParadasFragment();
                pf.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, pf).commit();
                break;

            case R.id.action_lineas:
                LineasFragment lf = new LineasFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, lf).commit();
                break;
            default:
                LineasFragment defaultF = new LineasFragment();
                defaultF.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, defaultF).commit();
                break;
        } //switch
        return true;

    } //onNavigationItemSelected

    /**
     * Este método se ejecuta cuando se ha pulsado una linea. Abrira una Activity nueva con
     * las paradas de esa linea.
     * @param linea
     */
    @Override
    public void callback(Linea linea) {

        if (!isChangingActivity) {
            Intent intent = new Intent(this, DetallesLineaActivity.class);
            intent.putExtra("identificadorLinea",linea.getIdentifier());
            intent.putExtra("numeroLinea", linea.getNumero());
            intent.putExtra("nombreLinea", linea.getName());
            isChangingActivity = true;
            startActivity(intent);
        }
    }//callback


    /**
     * Este metodo se llama cuando se ha pulsado una parada. Abrira una Activity nueva con
     * los detalles de esa parada.
     * @param parada
     */
    @Override
    public void callbackParada(Parada parada) {
        if (!isChangingActivity) {
            Intent intent = new Intent(this, DetallesParadaActivity.class);
            intent.putExtra("nombre", parada.getNombre());
            intent.putExtra("posX", parada.getPosX());
            intent.putExtra("posY", parada.getPosY());
            intent.putExtra("numero", parada.getNumParada());
            Log.d("[Parada pulsada] ==> ", parada.getNombre());
            startActivity(intent);
            isChangingActivity = true;
        }
    }


    /**
     * Metodo que se ejecuta cuando se rescata una actividad de memoria (al volver a la app,
     * de otra activity...)
     */
    @Override
    public void onResume() {
        super.onResume();
        isChangingActivity = false;
    }
}
