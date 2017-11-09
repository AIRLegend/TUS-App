package com.air.mover.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.test.rule.ActivityTestRule;

import com.air.mover.dao.Model.Parada;
import com.air.mover.view.ListParadasLineaAdapter;
import com.air.mover.view.MainActivity;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by Javier on 09/11/2017.
 */
public class ListParadasLineaPresenterTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    ListParadasLineaPresenter listParadasLinea;
    private List<Parada> datos = Collections.emptyList();
    ListParadasLineaAdapter adapter;

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