package com.air.mover.dao.dataloader;

import android.support.test.InstrumentationRegistry;
import android.util.JsonReader;

import com.air.mover.R;
import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;

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

    //TESTS DE PARADAS
    @Test
    public void testU1aParada(){
        //Prueba U1.a //lee parada
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradas_test_readparada);//Añadir json
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            Parada p = ParserJSON.readParada(reader);

            Assert.assertEquals(p.getNombre(),"ARSENIO ODRIOZOLA 16");//Añadir nombre
            Assert.assertEquals(p.getNumParada(),328);//Añandir numero
            Assert.assertEquals(p.getPosX(),435985.96875);//Añadir posx
            Assert.assertEquals(p.getPosY(),4815050.5);//Añadir posy
        }catch(Exception e){
            Assert.fail("Error: lectura de parada incorrecta");
            e.printStackTrace();
        }
    }

    @Test
    public void testU1bParada(){
        //Prueba U1.b //No hay parada
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradas_test_readparada_vacio);//Añadir json
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            Parada p = ParserJSON.readParada(reader);

            Assert.assertEquals(p.getNombre(),"");
            Assert.assertEquals(p.getNumParada(),-1);
            Assert.assertEquals(p.getPosX(),-1.0);
            Assert.assertEquals(p.getPosY(),-1.0);
        }catch(Exception e){
            Assert.fail("Error: no debería de haber parada");
            e.printStackTrace();
        }
    }

    @Test
    public void testU2aParada() throws Exception {

        //Prueba U2.a Lista vacia
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradas_test_vacio);
            List<Parada> p = ParserJSON.readParadasList(is);

            Assert.assertEquals(0, p.size());
        }catch(Exception e){
            Assert.fail("Error: la lsta debería estar vacía");
            e.printStackTrace();

        }
    }

    @Test
    public void testU2bParada() throws Exception{

        //Prueba U2.b Lista con un elemento
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradas_test1);
            List<Parada> p = ParserJSON.readParadasList(is);

            Assert.assertEquals(p.get(0).getNombre(),"ARSENIO ODRIOZOLA 16");//Añadir nombre
            Assert.assertEquals(p.get(0).getNumParada(),328);//Añandir numero
            Assert.assertEquals(p.get(0).getPosX(),435985.96875);//Añadir posx
            Assert.assertEquals(p.get(0).getPosY(),4815050.5);//Añadir posy
        }catch(Exception e){
            Assert.fail("Error: lectura de parada incorrecta");
            e.printStackTrace();
        }
    }

    @Test
    public void testU2cParada() throws Exception{

        //Prueba U2.c Lista con mas de un elemento
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradas_test);
            List<Parada> p = ParserJSON.readParadasList(is);

            Assert.assertEquals(p.get(0).getNombre(),"ARSENIO ODRIOZOLA 16");//Añadir nombre
            Assert.assertEquals(p.get(0).getNumParada(),328);//Añandir numero
            Assert.assertEquals(p.get(0).getPosX(),435985.96875);//Añadir posx
            Assert.assertEquals(p.get(0).getPosY(),4815050.5);//Añadir posy

            Assert.assertEquals(p.get(1).getNombre(),"DOCTOR DIEGO MADRAZO");//Añadir nombre
            Assert.assertEquals(p.get(1).getNumParada(),330);//Añandir numero
            Assert.assertEquals(p.get(1).getPosX(),435737.53125);//Añadir posx
            Assert.assertEquals(p.get(1).getPosY(),4814926.5);//Añadir posy
        }catch(Exception e){
            Assert.fail("Error: lectura de paradas incorrecta");
            e.printStackTrace();
        }
    }

    @Test
    public void testU2dParada() throws Exception{

        //Prueba U2.d Lista con estructura de json incorrecta
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradas_test_erroneo);
            List<Parada> p = ParserJSON.readParadasList(is);

            Assert.assertEquals(0, p.size());
        }catch(Exception e){
            Assert.fail("Error: el tamaño dela lista debería ser cero");
            e.printStackTrace();
        }
    }

    //TESTS PARADAS TODAS

    @Test
    public void testU6a() throws Exception{


        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradastodas_test);
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            Parada p = ParserJSON.readParadaGlobal(reader);

            Assert.assertEquals(p.getNombre(),"La Pereda");
            Assert.assertEquals(p.getNumParada(),463);
            Assert.assertEquals(p.getPosX(),435031.38);
            Assert.assertEquals(p.getPosY(),4814426.15);

        }catch(Exception e){
            Assert.fail("Deberia poder leer la parada");
            e.printStackTrace();
        }
    }

    @Test
    public void testU6b() throws Exception{

        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradastodas_test_vacio);
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            Parada p = ParserJSON.readParadaGlobal(reader);

            Assert.assertEquals(p.getNombre(),"");
            Assert.assertEquals(p.getNumParada(),-1);
            Assert.assertEquals(p.getPosX(),-1.0);
            Assert.assertEquals(p.getPosY(),-1.0);
        }catch(Exception e){
            Assert.fail("No deberia leer ninguna parada");
            e.printStackTrace();
        }
    }

    @Test
    public void testU7a()throws Exception{

        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradastodas_test_vacio);
            List<Parada> p = ParserJSON.readParadasTodasList(is);

            Assert.assertEquals(0, p.size());
        }catch(Exception e){
            Assert.fail("La lista debería estar vacía");
            e.printStackTrace();
        }
    }

    @Test
    public void testU7b()throws Exception{

        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradastodas_test1);
            List<Parada> p = ParserJSON.readParadasTodasList(is);

            Assert.assertEquals(1, p.size());

            Assert.assertEquals(p.get(0).getNombre(),"La Pereda");//Añadir nombre
            Assert.assertEquals(p.get(0).getNumParada(),463);//Añandir numero
            Assert.assertEquals(p.get(0).getPosX(),435031.38);//Añadir posx
            Assert.assertEquals(p.get(0).getPosY(),4814426.15);//Añadir posy

        }catch(Exception e){
            Assert.fail("La lista debería tener 1 linea");
            e.printStackTrace();
        }
    }

    @Test
    public void testU7c()throws Exception{

        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.paradastodas_test_varias);
            List<Parada> p = ParserJSON.readParadasTodasList(is);

            Assert.assertEquals(2, p.size());

            Assert.assertEquals(p.get(0).getNombre(),"La Pereda");
            Assert.assertEquals(p.get(0).getNumParada(),463);
            Assert.assertEquals(p.get(0).getPosX(),435031.38);
            Assert.assertEquals(p.get(0).getPosY(),4814426.15);

            Assert.assertEquals(p.get(1).getNombre(),"Marques de Hazas - 1");
            Assert.assertEquals(p.get(1).getNumParada(),479);
            Assert.assertEquals(p.get(1).getPosX(),434829.58);
            Assert.assertEquals(p.get(1).getPosY(),4814282.99);

        }catch(Exception e){
            Assert.fail("La lista debería tener 2 lineas");
            e.printStackTrace();
        }
    }
}