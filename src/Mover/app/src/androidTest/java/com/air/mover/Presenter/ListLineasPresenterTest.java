package com.air.mover.Presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.air.mover.DAO.DataLoader.ParserJSON;
import com.air.mover.DAO.DataLoader.RemoteFetch;
import com.air.mover.DAO.Model.Linea;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import com.air.mover.View.LineasFragments.LineasTodasFragment;
import com.air.mover.View.MainActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by Elisa on 30/10/2017. Tests de integración
 */
public class ListLineasPresenterTest {

    ListLineasPresenter listLineasPresenter;
    RemoteFetch remoteFetchLineas;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Test para comprobar que el metodo obtenLineas() retorne true cuando la url dada es la correcta,
     * haya conexión a internet y el numero de lineas sea mayor que 0.
     * @throws Exception
     */
    @Test
    public void I1A() throws  Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listLineasPresenter = new ListLineasPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new LineasTodasFragment());
            }
        });
        Assert.assertEquals("URL correcta, con conexion a internet",listLineasPresenter.obtenLineas(),true);
        List<Linea> l = listLineasPresenter.getListaLineasBus();
        Assert.assertEquals("El tamaño de la lista es diferente",l.size(),33);
    }//I1A

    /**
     * Test para comprobar que el metodo obtenLineas() retorne true cuando la url dada es incorrecta,
     * haya conexión a internet y el numero de lineas sea 0.
     * @throws Exception
     */
    @Test
    public void I1B() throws  Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listLineasPresenter = new ListLineasPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new LineasTodasFragment()){
                    /**
                     * Sobreescribir el metodo obtenLineas() cambiando la url original por una incorrecta
                     */
                    @Override
                    public boolean obtenLineas(){
                        try {
                            remoteFetchLineas.getJSON("http://www");
                            setListaLineasBus(ParserJSON.readArrayLineasBus(remoteFetchLineas.getBufferedData()));
                            return true;
                        }catch(Exception e){
                            Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
                            e.printStackTrace();
                            return false;
                        }//try
                    }//obtenLineas
                };
            }
        });
        Assert.assertEquals("",listLineasPresenter.obtenLineas(),false);
    }//I1B

    /**
     * Test para comprobar que el metodo obtenLineas() retorne false cuando la url dada es la correcta,
     * pero no haya conexión a internet.
     * @throws Exception
     */
    @Test
    public void I1C() throws  Exception{
        // si tengo internet no me interesa ejecutar esto
        if(checkInternet()){
            return;
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listLineasPresenter = new ListLineasPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new LineasTodasFragment());
            }
        });
        Assert.assertEquals("",listLineasPresenter.obtenLineas(),false);
    }//I1C

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
    }
}