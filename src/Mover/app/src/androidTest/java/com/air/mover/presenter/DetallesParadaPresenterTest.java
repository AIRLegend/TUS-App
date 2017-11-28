package com.air.mover.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;

import com.air.mover.dao.model.Estimacion;
import com.air.mover.view.ListEstimacionesAdapter;
import com.air.mover.view.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by Elisa on 27/11/2017. Test integración (US-241917-VerEstimacionAutobuses)
 */
public class DetallesParadaPresenterTest {
    DetallesParadaPresenter detallesParadaPresenter;
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    /**
     * Test para comprobar que el método obtenEstimacionesParada() retorne true cuando haya conexión
     * a internet y el identificador de la parada sea 463.
     * @throws Exception
     */
    @Test
    public void I4A() throws Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Context context = mActivityTestRule.getActivity().getApplicationContext();
                detallesParadaPresenter = new DetallesParadaPresenter(context, new ListEstimacionesAdapter(context),463);
            }
        });
        Assert.assertEquals("Error, no se han obtenido las estimaciones",true,
                detallesParadaPresenter.obtenEstimacionesParada(463));
        Assert.assertTrue(detallesParadaPresenter.getListaEstimacionesParada().size()>0);
    }//I4A

    /**
     * Test para comprobar que el método obtenEstimacionesParada() retorne false cuando no haya conexión
     * a internet y el identificador de la parada sea 463.
     * @throws Exception
     */
    @Test
    public void I4B() throws Exception{
        if(checkInternet()){
            return;     //Si tengo internet no me interesa ejecutar esto.
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Context context = mActivityTestRule.getActivity().getApplicationContext();
                detallesParadaPresenter = new DetallesParadaPresenter(context, new ListEstimacionesAdapter(context),463);
            }
        });
        Assert.assertEquals("Error, no se deberian obtener estimaciones",false,
                detallesParadaPresenter.obtenEstimacionesParada(463));
        List<Estimacion> l = detallesParadaPresenter.getListaEstimacionesParada();
        Assert.assertTrue(l==null);
    }//I4B

    /**
     * Test para comprobar que el método obtenEstimacionesParada() retorne false cuando haya conexión
     * a internet y el identificador de la parada sea -5.
     * @throws Exception
     */
    @Test
    public void I4C() throws Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Context context = mActivityTestRule.getActivity().getApplicationContext();
                detallesParadaPresenter = new DetallesParadaPresenter(context, new ListEstimacionesAdapter(context),-5);
            }
        });
        Assert.assertEquals("Error, no se deberian obtener estimaciones",false,
                detallesParadaPresenter.obtenEstimacionesParada(-5));
        List<Estimacion> l = detallesParadaPresenter.getListaEstimacionesParada();
        Assert.assertTrue(l==null);
    }//I4C


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