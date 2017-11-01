package com.air.mover.View;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.air.mover.R;
import com.air.mover.View.DireccionesFragments.DireccionesFragment;
import com.air.mover.View.LineasFragments.LineasFragment;
import com.air.mover.View.ParadasFragments.ParadasFragment;

/**
 *  Esta clase se encarga de definir y gestionar la vista principal de la aplicacion
 *
 *  @version 29/10/17
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    private BottomNavigationView mBottomBar;

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
                lf.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, lf).commit();
                break;
        } //switch
        return true;

    } //onNavigationItemSelected



    /**
     *  Metodo que se ejecuta cuando se reinicia la app y hace que la activity se ponga por defecto en
     *  la primera pestana de lineas.

    @Override
    protected void onStart()
    {
        super.onStart();
        onNavigationItemSelected(mBottomBar.getMenu().getItem(0));
        mBottomBar.setSelectedItemId(R.id.action_lineas);
    } //onStart

    // */
}
