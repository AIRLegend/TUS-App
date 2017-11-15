package com.air.mover.presenter;

<<<<<<< HEAD
import com.air.mover.dao.model.Linea;

import junit.framework.Assert;

=======
import com.air.mover.dao.model.Parada;

import org.junit.Assert;
>>>>>>> US-241438-BuscarParadaDeLinea
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import static com.air.mover.presenter.CommonUtils.filterLineas;


public class CommonUtilsTest {
    private static List<Linea> l = new ArrayList<>();

    /**
     * Inicializar la lista de lineas que vamos a usar en las pruebas
     */
    @BeforeClass
    public static void inicializar(){
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

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  numero que existe
     */
    @Test
    public void U4A() throws Exception {
        Assert.assertEquals(filterLineas(l, "12").size(), 1);
    }//U4A

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 0 cuando buscas por un
     *  numero que no existe
     */
    @Test
    public void U4B() throws Exception {
        Assert.assertEquals(filterLineas(l, "50").size(), 0);
    }//U4B

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 4, 2 y 1 cuando buscas por el
     *  numero 5, 5C y 5C1 respectivamente.
     */
    @Test
    public void U4C() throws Exception {
        Assert.assertEquals(filterLineas(l, "5").size(), 4);
        Assert.assertEquals(filterLineas(l, "5C").size(), 2);
        Assert.assertEquals(filterLineas(l, "5C1").size(), 1);
    }//U4C

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  nombre completo que existe
     */
    @Test
    public void U4D() throws Exception {
        Assert.assertEquals(filterLineas(l, "PLAZA DE LOS REMEDIOS").size(), 1);
    }//U4D

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  nombre en minúsculas que existe
     */
    @Test
    public void U4E() throws Exception {
        Assert.assertEquals(filterLineas(l, "Ojaiz-piquio").size(), 1);
    }//U4E

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 1 cuando buscas por un
     *  nombre que existe intercalando mayúsculas y minúsculas
     */
    @Test
    public void U4F() throws Exception {
        Assert.assertEquals(filterLineas(l, "PcTcAn-VaLdEnOjA").size(), 1);
    }//U4F

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 3 cuando buscas por un
     *  nombre incompleto que existe
     */
    @Test
    public void U4G() throws Exception {
        Assert.assertEquals(filterLineas(l, "Valdec").size(), 3);
    }//U4G

    /**
     *  Test que comprueba que el tamaño de la lista obtenida es 0 cuando buscas por un
     *  nombre que no existe
     */
    @Test
    public void U4H() throws Exception {
        Assert.assertEquals(filterLineas(l, "Unican").size(), 0);
    }//U4H

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 1 cuando el número
     * y nombre introducidos existen y son correspondientes
     */
    @Test
    public void U4I() throws Exception {
        Assert.assertEquals(filterLineas(l, "13 LLUJA-CUETO").size(), 1);
    }//U4I

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 0 (lista vacía) cuando
     * el número existe, pero el nombre introducido no
     */
    @Test
    public void U4J() throws Exception {
        Assert.assertEquals(filterLineas(l, "13 UNICAN").size(), 0);
    }//U4J

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 0 (lista vacía) cuando
     * el número introducido no existe y el nombre sí.
     */
    @Test
    public void U4K() throws Exception {
        Assert.assertEquals(filterLineas(l, "90 PLAZA DE LOS REMEDIOS").size(), 0);

    }//U4K

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 0 (lista vacia) cuando
     * tanto el número como el nombre existen, pero no son correspondientes
     */
    @Test
    public void U4L() throws Exception {
        Assert.assertEquals(filterLineas(l, "13 PLAZA DE LOS REMEDIOS").size(), 0);
    }//U4L

    /**
     * Test que comprueba que el tamaño de la lista obtenida es 1 cuando tanto el número
     * como el nombre existen y son correspondientes, con más de un espacio de separación
     */
    @Test
    public void U4M() throws Exception {
        Assert.assertEquals(filterLineas(l, "13  LLUJA-CUETO").size(), 1);
    }//U4M
=======


/**
 * Created by Javier on 15/11/2017.
 */
public class CommonUtilsTest {

    private static List<Parada> p = new ArrayList<>();

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
    }

    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un numero existente
     */
    @Test
    public void U5A() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "429").size());
    }//U5A

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un numero inexistente
    */
    @Test
    public void U5B() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "90").size());
    }//U5B
    /*
    Método que comprueba si el tamaño de la lista es de dos y de uno cuando se realiza una consulta con un numero de "6"
    y de "68" respectivamente
    */
    @Test
    public void U5C() throws Exception {
        Assert.assertEquals(3, CommonUtils.filterParadas(p, "6").size());
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "68").size());
    }//U5C
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre existente en mayusculas
    */
    @Test
    public void U5D() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "PLAZA DE TOROS").size());
    }//U5D
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre existente en minusculas
    */
    @Test
    public void U5E() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "plaza de toros").size());
    }//U5E
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nobre existente con mayuscula y
    minusculas intercaladas
    */
    @Test
    public void U5F() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "PlAzA De ToRoS").size());
    }//U5F
    /*
    Método que comprueba si el tamaño de la lista es de TRES cuando se realiza una consulta con un nombre incompleto existente
    */
    @Test
    public void U5G() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "Mona").size());
    }//U5G
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre inexistente
    */
    @Test
    public void U5H() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "Plazas").size());
    }//U5H
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre y un valor existentes
    */
    @Test
    public void U5I() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "9 Valdecilla").size());
    }//U5I
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre existente y valor inexistente
    */
    @Test
    public void U5J() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "90 Valdecilla").size());
    }//U5J
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con nombre y un valor inexistentes
    */
    @Test
    public void U5K() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "9 Unican").size());
    }//U5K
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre existente y un valor inexistente
    */
    @Test
    public void U5L() throws Exception {
        Assert.assertEquals(0, CommonUtils.filterParadas(p, "45 Valdecilla").size());
    }//U5L
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un valor y nombre existentes
    separados por dos espacios
    */
    @Test
    public void U5M() throws Exception {
        Assert.assertEquals(1, CommonUtils.filterParadas(p, "9  Valdecilla").size());
    }//U5AM

>>>>>>> US-241438-BuscarParadaDeLinea
}