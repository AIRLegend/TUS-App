package com.air.mover.presenter;

import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.air.mover.presenter.CommonUtils.filterLineas;


/**
 * Created by Javier on 15/11/2017.
 */
public class CommonUtilsTest {

    private static List<Parada> p = new ArrayList<>();
    private static List<Linea> l = new ArrayList<>();

    /**
     * Inicializar la lista de lineas y paradas que vamos a usar en las pruebas
     */
    @BeforeClass
    public static void inicializar() {

        Parada p1 = new Parada("CALLE ALTA 46",434147.8125,4812396.0,429);
        Parada p2 = new Parada("MERCADO MEJICO",433345.71875,4812227.0,268);
        Parada p3 = new Parada("CALLE ALTA 109",433624.0,4812247.0,269);
        Parada p4 = new Parada("PLAZA DE TOROS",433225.0,4812076.0,433);
        Parada p5 = new Parada("JESUS DE MONASTERIO 21",434379.78125,4812618.5,12);
        Parada p6 = new Parada("VALDECILLA",432950.0,4812158.0,9);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);

        Linea l1 = new Linea("PCTCAN-VALDENOJA", "1", 1);
        Linea l2 = new Linea("OJAIZ-PIQUIO","3",3);
        Linea l3 = new Linea("MIRANDA/PLZ. ITALIA C1","5C1",51);
        Linea l4 = new Linea("MIRANDA/PLZ. ITALIA C2","5C2",52);
        Linea l5 = new Linea("VALDECILLA-C/ ALTA","11",11);
        Linea l6 = new Linea("CARREFOUR-CANALEJAS", "12", 12);
        Linea l7 = new Linea("LLUJA-CUETO","13",13);
        Linea l8 = new Linea("ESTACIONES-AV. VALDECILLA","14",14);
        Linea l9 = new Linea("ESTACIONES-EL FARO","15",15);
        Linea l10 = new Linea("PLAZA DE LOS REMEDIOS","16",16);
        Linea l11 = new Linea("VALDECILLA-GREGORIO MARAÑON", "E1",41);
        Linea l12 = new Linea("SE C/ALTA-INSTITUTOS", "E5", 45);
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        l.add(l6);
        l.add(l7);
        l.add(l8);
        l.add(l9);
        l.add(l10);
        l.add(l11);
        l.add(l12);
    }

    // PRUEBAS UNITARIAS (US-241438-BuscarParadaDeLinea)

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un numero existente
     */
    @Test
    public void U7A() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "429").size());
    }//U7A

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un numero inexistente
    */
    @Test
    public void U7B() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "90").size());
    }//U7B

    /*
    Método que comprueba si el tamaño de la lista es de dos y de uno cuando se realiza una consulta con un numero de "6"
    y de "68" respectivamente
    */
    @Test
    public void U7C() throws Exception {
        Assert.assertEquals(3, CommonUtils.filterParadas(p, "6").size());
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "68").size());
    }//U7C

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre existente en mayusculas
    */
    @Test
    public void U7D() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "PLAZA DE TOROS").size());
    }//U7D

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre existente en minusculas
    */
    @Test
    public void U7E() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "plaza de toros").size());
    }//U7E

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nobre existente con mayuscula y
    minusculas intercaladas
    */
    @Test
    public void U7F() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "PlAzA De ToRoS").size());
    }//U7F

    /*
    Método que comprueba si el tamaño de la lista es de TRES cuando se realiza una consulta con un nombre incompleto existente
    */
    @Test
    public void U7G() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "Mona").size());
    }//U7G

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre inexistente
    */
    @Test
    public void U7H() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "Plazas").size());
    }//U7H

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre y un valor existentes
    */
    @Test
    public void U7I() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "9 Valdecilla").size());
    }//U7I

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre existente y valor inexistente
    */
    @Test
    public void U7J() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "90 Valdecilla").size());
    }//U7J

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con nombre y un valor inexistentes
    */
    @Test
    public void U7K() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "9 Unican").size());
    }//U7K

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre existente y un valor inexistente
    */
    @Test
    public void U7L() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "45 Valdecilla").size());
    }//U7L

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un valor y nombre existentes
    separados por dos espacios
    */
    @Test
    public void U7M() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "9  Valdecilla").size());
    }//U7M

    // PRUEBAS UNITARIAS (US-241258-BuscarLinea)

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  numero que existe
     */
    @Test
    public void U8A() throws Exception {
        Assert.assertEquals(1,filterLineas(l, "12").size());
    }//U8A

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 0 cuando buscas por un
     *  numero que no existe
     */
    @Test
    public void U8B() throws Exception {
        Assert.assertEquals(0,filterLineas(l, "50").size());
    }//U8B

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 4, 2 y 1 cuando buscas por el
     *  numero 5, 5C y 5C1 respectivamente.
     */
    @Test
    public void U8C() throws Exception {
        Assert.assertEquals(4,filterLineas(l, "5").size());
        Assert.assertEquals(2,filterLineas(l, "5C").size());
        Assert.assertEquals(1,filterLineas(l, "5C1").size());
    }//U8C

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  nombre completo que existe
     */
    @Test
    public void U8D() throws Exception {
        Assert.assertEquals(1,filterLineas(l, "PLAZA DE LOS REMEDIOS").size());
    }//U8D

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  nombre en minúsculas que existe
     */
    @Test
    public void U8E() throws Exception {
        Assert.assertEquals(1,filterLineas(l, "Ojaiz-piquio").size());
    }//U8E

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  nombre que existe intercalando mayúsculas y minúsculas
     */
    @Test
    public void U8F() throws Exception {
        Assert.assertEquals(1,filterLineas(l, "PcTcAn-VaLdEnOjA").size());
    }//U8F

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 3 cuando buscas por un
     *  nombre incompleto que existe
     */
    @Test
    public void U8G() throws Exception {
        Assert.assertEquals(3,filterLineas(l, "Valdec").size());
    }//U8G

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 0 cuando buscas por un
     *  nombre que no existe
     */
    @Test
    public void U8H() throws Exception {
        Assert.assertEquals(0,filterLineas(l, "Unican").size());
    }//U8H

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 1 cuando el número
     * y nombre introducidos existen y son correspondientes
     */
    @Test
    public void U8I() throws Exception {
        Assert.assertEquals(1,filterLineas(l, "13 LLUJA-CUETO").size());
    }//U8I

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 0 (lista vacía) cuando
     * el número existe, pero el nombre introducido no
     */
    @Test
    public void U8J() throws Exception {
        Assert.assertEquals(0,filterLineas(l, "13 UNICAN").size());
    }//U8J

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 0 (lista vacía) cuando
     * el número introducido no existe y el nombre sí.
     */
    @Test
    public void U8K() throws Exception {
        Assert.assertEquals(0,filterLineas(l, "90 PLAZA DE LOS REMEDIOS").size());

    }//U8K

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 0 (lista vacia) cuando
     * tanto el número como el nombre existen, pero no son correspondientes
     */
    @Test
    public void U8L() throws Exception {
        Assert.assertEquals(0,filterLineas(l, "13 PLAZA DE LOS REMEDIOS").size());
    }//U8L

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 1 cuando tanto el número
     * como el nombre existen y son correspondientes, con más de un espacio de separación
     */
    @Test
    public void U8M() throws Exception {
        Assert.assertEquals(1,filterLineas(l, "13  LLUJA-CUETO").size());
    }//U8M

}