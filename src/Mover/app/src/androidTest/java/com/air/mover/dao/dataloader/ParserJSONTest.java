package com.air.mover.dao.dataloader;

import android.support.test.InstrumentationRegistry;
import android.util.JsonReader;

import com.air.mover.dao.Model.Linea;
import com.air.mover.R;

import junit.framework.Assert;

import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Javier on 30/10/2017.
 */
public class ParserJSONTest {

    @Test
    public void testU1a() throws Exception {

        //Prueba U1.a //lee linea
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test_readlinea);
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            Linea l = ParserJSON.readLinea(reader);

            Assert.assertEquals("20", l.getNumero());
            Assert.assertEquals("ESTACIONES-BARRIO LA TORRE", l.getName());
            Assert.assertTrue(l.getIdentifier() == 20);
        }catch(Exception e){
            Assert.fail("Error: lectura de linea incorrecta");
            e.printStackTrace();
        }
    }
    @Test
    public void testU1b() throws Exception {

        //Prueba U1.b No hay linea
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test_readlinea_vacio);
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            Linea l = ParserJSON.readLinea(reader);

            Assert.assertTrue(l.getName()=="");
            Assert.assertTrue(l.getNumero()=="");
            Assert.assertTrue(l.getIdentifier()==-1);


        }catch(Exception e){
            Assert.fail("Error: no deberia de haber linea");
            e.printStackTrace();
        }
    }

    @Test
    public void testU2a() throws Exception {

        //Prueba U2.a Lista vacia
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test_vacio);
            List<Linea> l = ParserJSON.readArrayLineasBus(is);

            Assert.assertEquals(0, l.size());
        }catch(Exception e){
            Assert.fail("Error: la lsta debería estar vacía");
            e.printStackTrace();

        }
    }
    @Test
    public void testU2b() throws Exception{

        //Prueba U2.b Lista con un elemento
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test1);
            List<Linea> l = ParserJSON.readArrayLineasBus(is);

            Assert.assertEquals("20", l.get(1).getNumero());
            Assert.assertEquals("ESTACIONES-BARRIO LA TORRE", l.get(1).getName());
            Assert.assertEquals(20, l.get(1).getIdentifier());
        }catch(Exception e){
            Assert.fail("Error: lectura de linea incorrecta");
            e.printStackTrace();
        }
    }
    @Test
    public void testU2c() throws Exception{

        //Prueba U2.c Lista con mas de un elemento
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test);
            List<Linea> l = ParserJSON.readArrayLineasBus(is);

            Assert.assertEquals("20", l.get(1).getNumero());
            Assert.assertEquals("ESTACIONES-BARRIO LA TORRE", l.get(1).getName());
            Assert.assertEquals(20, l.get(1).getIdentifier());

            Assert.assertEquals("19", l.get(0).getNumero());
            Assert.assertEquals("ESTACIONES-RICARDO L. ARANDA", l.get(0).getName());
            Assert.assertEquals(19, l.get(0).getIdentifier());
        }catch(Exception e){
            Assert.fail("Error: lectura de lineas incorrecta");
            e.printStackTrace();
        }
    }
    @Test
    public void testU2d() throws Exception{

        //Prueba U2.d Lista con estructura de json incorrecta
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.lineas_test_erroneo);
            List<Linea> l = ParserJSON.readArrayLineasBus(is);

            Assert.assertEquals(0, l.size());
        }catch(Exception e){
            Assert.fail("Error: eltamaño dela lista debería ser cero");
            e.printStackTrace();
        }
    }
}