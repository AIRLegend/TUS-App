package com.air.mover.dao.dataloader;

import android.support.test.InstrumentationRegistry;
import android.util.JsonReader;

import com.air.mover.R;
import com.air.mover.dao.model.Estimacion;
import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;

import junit.framework.Assert;

import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 30/10/2017.
 */
public class ParserJSONTest {

    @Test
    public void U1A() throws Exception {

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
    public void U1B() throws Exception {

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
    public void U2A() throws Exception {

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
    public void U2B() throws Exception{

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
    public void U2C() throws Exception{

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

    // PRUEBAS UNITARIAS US-VerParadasLinea
    @Test
    public void U4A(){
        //Prueba U4A //lee parada
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
    public void U4B(){
        //Prueba U4B //No hay parada
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
    public void U5A() throws Exception {

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
    public void U5B() throws Exception{

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
    public void U5C() throws Exception{

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

    // PRUEBAS UNITARIAS US-244924-VerParadas

    @Test
    public void U9A() throws Exception{


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
    public void U9B() throws Exception{

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
    public void U10A()throws Exception{

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
    public void U10B()throws Exception{

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
    public void U10C()throws Exception{

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
    //PRUEBAS UNITARIAS US-VerEstimaciones

/*
Test que comprueba que readEstimacion() lee correctamente el objeto correspondiente
cuando este contiene las 2 proximas llegadas.
 */
    @Test
    public void U13A() throws Exception{
        try{
            List<Estimacion> list = new ArrayList<>();
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.estimaciones_test_readestimacion);//cambiar por json de estimaciones
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            ParserJSON.readEstimacion(reader, list);

            Assert.assertEquals("20",list.get(0).getNumLinea());
            Assert.assertEquals("463",list.get(0).getNumParada());
            Assert.assertEquals("0",list.get(0).getTiempoParaLlegada());


            Assert.assertEquals("20",list.get(1).getNumLinea());
            Assert.assertEquals("463",list.get(1).getNumParada());
            Assert.assertEquals("0",list.get(1).getTiempoParaLlegada());

        }catch(Exception e){
            Assert.fail("Error");
            e.printStackTrace();

        }
    }
/*
Test que comprueba que readEstimacion() lee correctamente el objeto correspondiente
cuando este contiene unicamente 1 proxima llegada.
 */
    @Test
    public void U13B() throws Exception{
        try{
            List<Estimacion> list = new ArrayList<>();
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.estimaciones_test_readestimacion1);//cambiar por json de estimacion
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            ParserJSON.readEstimacion(reader, list);

            Assert.assertEquals("20",list.get(0).getNumLinea());
            Assert.assertEquals("463",list.get(0).getNumParada());
            Assert.assertEquals("0",list.get(0).getTiempoParaLlegada());

        }catch(Exception e){
            Assert.fail("Error");
            e.printStackTrace();

        }
    }

    /*
Test que comprueba que readEstimacion() no rellena la lista pasada como
parametro cuando intenta leer un json vacio.
 */
    @Test
    public void U13C() throws Exception{
        try{
            List<Estimacion> list = new ArrayList<>();
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.estimaciones_test_readestimacion_vacio);//cambiar por json de estimacion vacio
            JsonReader reader = new JsonReader(new InputStreamReader(is, "UTF-8"));
            ParserJSON.readEstimacion(reader, list);

            Assert.assertEquals(0,list.size());

        }catch(Exception e){
            Assert.fail("Error");
            e.printStackTrace();

        }
    }
    /*
    Test que comprueba que el metodo readArrayEstimacionesParada()
    devuelve una lista vacia al leeer un json sin estimaciones
     */
    @Test
    public void U14A() throws Exception{
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.estimaciones_test_vacio);//json estimaciones vacio
            List<Estimacion> e = ParserJSON.readArrayEstimacionesParada(is);

            Assert.assertEquals(0,e.size());

        }catch(Exception e){
            Assert.fail("Error");
            e.printStackTrace();

        }
    }

    /*
Test que comprueba que el metodo readArrayEstimacionesParada()
devuelve una lista de 1 elemento al leeer un json con 1 estimacion.
 */
    @Test
    public void U14B() throws Exception{
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.estimaciones_test_1);//json estimaciones vacio
            List<Estimacion> e = ParserJSON.readArrayEstimacionesParada(is);

            Assert.assertEquals("20",e.get(0).getNumLinea());
            Assert.assertEquals("463",e.get(0).getNumParada());
            Assert.assertEquals("0",e.get(0).getTiempoParaLlegada());


        }catch(Exception e){

        }
    }

    /*
Test que comprueba que el metodo readArrayEstimacionesParada()
devuelve una lista de varios elementos al leeer un json con mas de una estimacion.
*/
    @Test
    public void U14C() throws Exception{
        try{
            InputStream is = InstrumentationRegistry.getTargetContext().getResources().openRawResource(R.raw.estimaciones_test);//json estimaciones vacio
            List<Estimacion> e = ParserJSON.readArrayEstimacionesParada(is);

            Assert.assertEquals("20",e.get(0).getNumLinea());
            Assert.assertEquals("463",e.get(0).getNumParada());
            Assert.assertEquals("0",e.get(0).getTiempoParaLlegada());

            Assert.assertEquals("20",e.get(1).getNumLinea());
            Assert.assertEquals("463",e.get(1).getNumParada());
            Assert.assertEquals("0",e.get(1).getTiempoParaLlegada());

            Assert.assertEquals("21",e.get(2).getNumLinea());
            Assert.assertEquals("467",e.get(2).getNumParada());
            Assert.assertEquals("0",e.get(2).getTiempoParaLlegada());

            Assert.assertEquals("21",e.get(3).getNumLinea());
            Assert.assertEquals("467",e.get(3).getNumParada());
            Assert.assertEquals("1",e.get(3).getTiempoParaLlegada());

        }catch(Exception e){
            Assert.fail("Error");
            e.printStackTrace();

        }
    }
}