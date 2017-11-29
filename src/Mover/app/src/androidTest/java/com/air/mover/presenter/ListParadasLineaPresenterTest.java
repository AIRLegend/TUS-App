package com.air.mover.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;

import com.air.mover.dao.model.Parada;
import com.air.mover.view.ListParadasLineaAdapter;
import com.air.mover.view.MainActivity;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/**
 * Created by Javier on 09/11/2017.
 */
public class ListParadasLineaPresenterTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    ListParadasLineaPresenter listParadasLinea;
    ListParadasLineaAdapter adapter;

    ListParadasLineaPresenter listParadasLineaPresenter;

    //PRUEBAS UNITARIAS (US241261-VerParadasLinea)

    @Test
    //Id linea existente, URL correcta, con conexion a internet. Devuelve true.
    public void U6A() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
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
    public void U6B() throws Exception{
        if(checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
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
    public void U6C() throws Exception{
        if(!checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
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
    public void U6D() throws Exception{
        if(!checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
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
    public void U6E() throws Exception{
        if(!checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
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
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()),1);
            }
        });
        Assert.assertEquals("Error, no se han obtenido las paradas",true,
                listParadasLineaPresenter.obtenParadasLineas(1));
    }//I2A

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
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()), 1);
            }
        });
        Assert.assertEquals("Error, no se deberian obtener las paradas",false,
                listParadasLineaPresenter.obtenParadasLineas(1));
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
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()),0);
            }
        });
        Assert.assertEquals("Error en la obtención de las paradas",true,
                listParadasLineaPresenter.obtenParadasLineas(0));
    }//I2C

    /**
     * Test para comprobar que el metodo obtenParadasLinea() retorne true cuando la url dada es correcta,
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
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()),100000);
            }
        });
        Assert.assertEquals("Error en la obtención de las paradas",true,
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
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()),-1);
            }
        });
        Assert.assertEquals("Error, no se deberian obtener las paradas",false,
                listParadasLineaPresenter.obtenParadasLineas(-1));
    }//I2E




    /**
     *
     * Pruebas de la historia de usuario US244924-VerParadas
     * Created on 21/11/2017.
     */

    // PRUEBAS UNITARIAS

        /*
    Test que comprueba si cuando se le pasa un -10 como parametro al metodo obtenParadasLineas() se descargan todas las paradas.
     */
    @Test
    public void U8A() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(-10);
            Assert.assertEquals(bool, true);
            Assert.assertTrue(listParadasLinea.getListaParadasLineaBus().size() > 400);//En total hay 443 paradas.

        }catch(Exception e){
            Assert.fail("Error: se deberian obtener todas las paradas");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que cuando se le pasa un numero diferente de -10 aobtenParadasLineas() se descargan las paradas
    correspondientes a la linea pasada como parametro.
     */
    @Test
    public void U8B() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(1);
            Assert.assertEquals(bool, true);
            Assert.assertTrue(listParadasLinea.getListaParadasLineaBus().size() > 0);//En total hay 443 paradas.

        }catch(Exception e){
            Assert.fail("Error: se deberian obtener las paradas referentes a la linea 1");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que cuando no hay conexion a internet no se
    pueden obtener las lineas
     */
    @Test
    public void U8C() throws Exception{
        if(checkInternet()){//Si tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(1);
            Assert.assertEquals(bool, false);

        }catch(Exception e){
            Assert.fail("Error: no se deberian obtener las paradas porque no hay internet");
            e.printStackTrace();
        }
    }

    @Test
    public void U8D() throws Exception{
        if(!checkInternet()){//Si no tengo internet no me interesa ejecutar esto.
            return;
        }

        try{
            //inicializacion
            adapter = new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext());
            listParadasLinea = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),adapter,1);
            //comprobacion
            boolean bool = listParadasLinea.obtenParadasLineas(-1);
            Assert.assertEquals(bool, false);

        }catch(Exception e){
            Assert.fail("Error: no se deberian obtener las paradas porque no hay internet");
            e.printStackTrace();
        }
    }


    // PRUEBAS DE INTEGRACIÓN

    /**
     * Test para comprobar que el metodo obtenParadasLineas() retorne true cuando
     * haya conexión a internet y el identificador de la línea sea -10.
     * @throws Exception
     */
    @Test
    public void I3A() throws Exception {
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()));
            }
        });
        Assert.assertEquals("Error en la obtención de paradas",true,
                listParadasLineaPresenter.obtenParadasLineas(-10));
    }//I3A

    /**
     * Test para comprobar que el metodo obtenParadasLineas() retorne true cuando haya
     * conexión a internet y el identificador de la línea sea distinto de -10 y mayor que 0
     * (en el este caso de prueba usaremos un id=2).
     * @throws Exception
     */
    @Test
    public void I3B() throws Exception {
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()));
            }
        });
        Assert.assertEquals("Error en la obtención de las paradas",true,
                listParadasLineaPresenter.obtenParadasLineas(2));
    }//I3B

    /**
     * Test para comprobar que el metodo obtenParadasLineas() retorne false cuando
     * no haya conexión a internet.
     * @throws Exception
     */
    @Test
    public void I3C() throws Exception {
        // si tengo internet no me interesa ejecutar esto
        if(checkInternet()){
            return;
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()));
            }
        });
        Assert.assertEquals("Error, no se deberian obtener las paradas",false,
                listParadasLineaPresenter.obtenParadasLineas(1));
    }//I3C

    /**
     * Test para comprobar que el metodo obtenParadasLineas() retorne false cuando haya
     * conexión a internet y el identificador de la línea sea menor que 0 (en este caso -1)
     * @throws Exception
     */
    @Test
    public void I3D() throws Exception {
        if(!checkInternet()){
            return;     // si no tengo conexion no me interesa ejecutarlo
        }//if
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listParadasLineaPresenter = new ListParadasLineaPresenter(mActivityTestRule.getActivity().getApplicationContext(),
                        new ListParadasLineaAdapter(mActivityTestRule.getActivity().getApplicationContext()));
            }
        });
        Assert.assertEquals("Error, no se deberian obtener las paradas",false,
                listParadasLineaPresenter.obtenParadasLineas(-1));
    }//I3D


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