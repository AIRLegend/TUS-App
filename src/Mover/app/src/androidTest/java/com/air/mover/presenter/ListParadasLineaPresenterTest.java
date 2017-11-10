package com.air.mover.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.air.mover.dao.model.Parada;
import com.air.mover.dao.dataloader.ParserJSON;
import com.air.mover.dao.dataloader.RemoteFetch;
import com.air.mover.view.ListParadasLineaAdapter;
import com.air.mover.view.MainActivity;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by Javier on 09/11/2017.
 */
public class ListParadasLineaPresenterTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    ListParadasLineaPresenter listParadasLinea;
    private List<Parada> datos = Collections.emptyList();
    ListParadasLineaAdapter adapter;

    ListParadasLineaPresenter listParadasLineaPresenter;

    //PRUEBAS UNITARIAS

    @Test
    //Id linea existente, URL correcta, con conexion a internet. Devuelve true.
    public void U3aTest() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),datos);
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(1);
            Assert.assertEquals(bool, true);

        }catch(Exception e){
            Assert.fail("Error: no se pudieron obtener las paradas");
            e.printStackTrace();
        }
    }

    //Id linea existente, URL correcta, sin conexion a internet. Devuelve false.
    @Test
    public void U3bTest() throws Exception{
        if(checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),datos);
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(1);
            Assert.assertEquals(bool, false);

        }catch(Exception e){
            Assert.fail("Error: no se deberían poder obtener las paradas");
            e.printStackTrace();
        }
    }

    @Test
    //Línea igual a 0 .
    public void U3cTest() throws Exception{
        if(!checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),datos);
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(0); //Devuelve true pero con lista vacia.
            Assert.assertEquals(bool, true);
            Assert.assertEquals(listParadasLinea.getListaParadasLineaBus().size(), 0);

        }catch(Exception e){
            Assert.fail("Error: no se deberían poder obtener las paradas");
            e.printStackTrace();
        }
    }

    @Test
    //Linea mayor que 0 y no existente
    public void U3dTest() throws Exception{
        if(!checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),datos);
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(10000); //Devuelve true pero con lista vacia.
            Assert.assertEquals(bool, true);
            Assert.assertEquals(listParadasLinea.getListaParadasLineaBus().size(), 0);

        }catch(Exception e){
            Assert.fail("Error: no se deberían poder obtener las paradas");
            e.printStackTrace();
        }
    }

    @Test
    //Linea menor que 0.
    public void U3eTest() throws Exception{
        if(!checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),datos);
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(-1);
            Assert.assertEquals(bool, false);

        }catch(Exception e){
            Assert.fail("Error: no se deberían poder obtener las paradas");
            e.printStackTrace();
        }
    }

    //PRUEBAS INTEGRACION

/**
 * Created by Elisa on 08/11/2017. Test de integración (US241261-VerParadasLinea)
 */

    /**
     * Test para comprobar que el metodo obtenParadasLineas() retorne true cuando la url dada es la correcta,
     * haya conexión a internet y el identificador de la línea es 1.
     * @throws Exception
     */
    @Test
    public void I2A() throws  Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),
                                Collections.<Parada>emptyList()),1);
            }
        });
        Assert.assertEquals("URL correcta, con conexion a internet",true,
                listParadasLineaPresenter.obtenParadasLineas(1));
    }//I2A

    /**
     * Test para comprobar que el metodo obtenParadasLinea() retorne false cuando la url dada es incorrecta,
     * haya conexión a internet y el identificador de la línea es 1.
     * @throws Exception
     */
    @Test
    public void I2prueba_url() throws  Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),
                                Collections.<Parada>emptyList()),1){
                    /**
                     * Sobreescribir el metodo obtenParadasLinea() cambiando la url original por una incorrecta
                     */
                    @Override
                    public boolean obtenParadasLineas(int identificadorLinea){
                        try
                        {
                            RemoteFetch.getJSON("http://www");
                            setListaLineasBus(ParserJSON.readParadasList(RemoteFetch.getBufferedData()));
                            return true;
                        }//try
                        catch(Exception e){
                            Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
                            return false;
                        }//catch
                    }//obtenParadasLinea
                };
            }
        });
        Assert.assertEquals(false, listParadasLineaPresenter.obtenParadasLineas(1));
    }//I2prueba_de_mas

    /**
     * Test para comprobar que el metodo obtenParadasLinea() retorne false cuando la url dada es la correcta,
     * pero no haya conexión a internet y el identificador de la línea sea 1.
     * @throws Exception
     */
    @Test
    public void I2B() throws  Exception{
        // si tengo internet no me interesa ejecutar esto
        if(checkInternet()){
            return;
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),
                                Collections.<Parada>emptyList()),1);
            }
        });
        Assert.assertEquals(false,listParadasLineaPresenter.obtenParadasLineas(1));
    }//I2B

    /**
     * Test para comprobar que el metodo obtenParadasLinea() retorne true cuando la url dada es correcta,
     * haya conexión a internet y el identificador de la línea es 0.
     * @throws Exception
     */
    @Test
    public void I2C() throws Exception {
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),
                                Collections.<Parada>emptyList()),0);
            }
        });
        Assert.assertEquals("El identificador de la línea no existe",true,
                listParadasLineaPresenter.obtenParadasLineas(0));
    }//I2C

    /**
     * Test para comprobar que el metodo obtenParadasLinea() retorne true(false) cuando la url dada es correcta,
     * haya conexión a internet y el identificador de la línea es mayor que 0 y no existente.
     * @throws Exception
     */
    @Test
    public void I2D() throws Exception{
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),
                                Collections.<Parada>emptyList()),100000);
            }
        });
        // me parece que si el id no existe si que pasa
        Assert.assertEquals("El identificador de la línea no existe",true,
                listParadasLineaPresenter.obtenParadasLineas(100000));
        // comprobamos que la lista de paradas de la línea esta vacía
        // si metemos un identificador inexistente
        List<Parada> listaParadasLinea = listParadasLineaPresenter.getListaParadasLineaBus();
        Assert.assertEquals("El tamaño de la lista es diferente",0,listaParadasLinea.size());
    }//I2D

    /**
     * Test para comprobar que el metodo obtenParadasLinea() retorne false cuando la url dada es correcta,
     * haya conexión a internet y el identificador de la línea es menor que 0.
     * @throws Exception
     */
    @Test
    public void I2E() throws Exception {
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext(),
                                Collections.<Parada>emptyList()),-1);
            }
        });
        Assert.assertEquals("El identificador de la línea no existe",false,
                listParadasLineaPresenter.obtenParadasLineas(-1));
    }//I2E


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