package com.air.mover.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;

import com.air.mover.view.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Javier on 27/11/2017.
 */
public class DetallesParadaPresenterTest {

    DetallesParadaPresenter detallesParada;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /*
    Test que comprueba que el metodo obtenEstimacionesParada() rellena el buffer
    cuando, con conexion a internet, se le pasa como parametro un identificador
    de parada correcto.
     */
    @Test
    public void U15A() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }
        try{
            boolean b = detallesParada.obtenEstimacionesParada(463);
            Assert.assertEquals(true,b);
            Assert.assertTrue(detallesParada.getListaEstimacionesParada().size()>0);

        }catch(Exception e){

        }
    }
/*
Test que comprueba que cuando se le pasa al metodo un identificador de parada correcto
pero no hay conexion, no rellena el buffer.
 */
    @Test
    public void U15B() throws Exception{
        if(checkInternet()){//Si no tengo internet me interesa ejecutar esto.
            return;
        }
        try{
            boolean b = detallesParada.obtenEstimacionesParada(463);
            Assert.assertEquals(false,b);

        }catch(Exception e){

        }
    }
/*
Test que comprueba que cuando se le  pasa al metodo un identificador de parada incorrecto
no rellena el buffer.
 */
    @Test
    public void U15C() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }
        try{
            boolean b = detallesParada.obtenEstimacionesParada(-5);
            Assert.assertEquals(false,b);

        }catch(Exception e){

        }
    }

    /**
     * Metodo auxiliar que sirve para comprobar si existe conexion a Internet.
     * @return si hay conexion o no.
     */
    private boolean checkInternet(){
        Context context = mActivityTestRule.getActivity().getApplicationContext();
        if(context != null) {
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        }else {
            return false;
        }
    }//checkInternet

}