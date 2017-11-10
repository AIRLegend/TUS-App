package com.air.mover.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import com.air.mover.R;

/**
 * Clase que se encarga de la gestion del splash screen de la aplicacion
 *
 * @version 29/10/17
 */
public class SplashScreen extends AppCompatActivity
{
    private Intent myintent; //Permitira lanzar la main activity despues de x segundos.

    /**
     * Metodo que se llamara cuando se crea la activity y se encargara de la gestion del splash screen
     *
     * @param savedInstanceState estado mas reciente de la activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Ocultamos el ActionBar para mostrar el SplashScreen
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){
            Log.e("Error", "No se ha podido encontrar el ActionBar");
        }


        //Ocultamos la barra de notificaciones
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Establecemos el contenido de la vista despues de la secuencia de arriba (para evitar un bloqueo)
        this.setContentView(R.layout.activity_splash_screen);


        myintent = new Intent(this, MainActivity.class);

        //Mostramos el SplashScreen un tiempo antes de lanzar la actividad principal
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(myintent);
                finish();
            }
        }, 1200);
    }
}
