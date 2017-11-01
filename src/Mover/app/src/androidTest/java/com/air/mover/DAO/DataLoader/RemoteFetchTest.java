package com.air.mover.DAO.DataLoader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;

import com.air.mover.View.MainActivity;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by Javier on 30/10/2017.
 */
public class RemoteFetchTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public static final String URL_ERRONEA="http://www.maaaarca.com";

    @Test
    public void testU1a() throws Exception {
        if (!checkInternet()) return;  //Si no tengo internet no me interesa ejecutar esto.

        //Prueba U1.a URL correcta con conexion
        try{
            RemoteFetch.getJSON(RemoteFetch.URL_LINEAS_BUS);
            //Assert.assertNotNull(RemoteFetch.bufferedData);
            Assert.assertTrue(RemoteFetch.bufferedData.available()>=0);  //Se puede leer algo
        }catch(Exception e){
            Assert.fail("Error: Buffereddata es null");
            e.printStackTrace();
        }
    }
    @Test
    public void testU3b() throws Exception{//FALLA

        if (checkInternet()) return;  //Si tengo internet no me interesa ejecutar esto.

        //Prueba U1.b URL correcta sin conexion
        try{
            RemoteFetch.getJSON(RemoteFetch.URL_LINEAS_BUS);
            Assert.assertEquals(RemoteFetch.bufferedData.available(), false); //Esto en realidad nunca ejecuta.
        }catch(IOException e){
            //Se lanza la excepcion porque no se puede acceder a la web.
            e.printStackTrace();
        }


    }
    @Test
    public void testU3c() throws Exception{//FALLA
        if (!checkInternet()) return;  //Si no tengo internet no me interesa ejecutar esto.

        //Prueba U1.c URL erronea
        try{
            RemoteFetch.getJSON(URL_ERRONEA);
            Assert.assertTrue(RemoteFetch.bufferedData.available()>=0); //Nunca se va a ejecutar
        }catch(IOException e){
            //Como la URL no es accesible entonces salta aqui (si todo esta correcto).
            e.printStackTrace();
        }
    }


    /**
     * Metodo auxiliar que sirve para comprobar que existe conexion a internet.
     * @return si hay conexion o no.
     */
    private boolean checkInternet() {
        Context context = mActivityTestRule.getActivity().getApplicationContext();
        if (context != null) {
            ConnectivityManager connMgr = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        } else {
            return false;
        }
    }

}