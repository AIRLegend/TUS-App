package com.air.mover.presenter;

import com.air.mover.dao.model.Parada;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



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
        Assert.assertEquals(filterParadas(p, "429").size(), 1);
    }//U5A

    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un numero inexistente
    */
    @Test
    public void U5B() throws Exception {
        Assert.assertEquals(filterParadas(p, "90").size(), 0);
    }//U5B
    /*
    Método que comprueba si el tamaño de la lista es de dos y de uno cuando se realiza una consulta con un numero de "6"
    y de "68" respectivamente
    */
    @Test
    public void U5C() throws Exception {
        Assert.assertEquals(filterParadas(p, "6").size(), 2);
        Assert.assertEquals(filterParadas(p, "68").size(), 1);
    }//U5C
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre existente en mayusculas
    */
    @Test
    public void U5D() throws Exception {
        Assert.assertEquals(filterParadas(p, "PLAZA DE TOROS").size(), 1);
    }//U5D
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre existente en minusculas
    */
    @Test
    public void U5E() throws Exception {
        Assert.assertEquals(filterParadas(p, "plaza de toros").size(), 1);
    }//U5E
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nobre existente con mayuscula y
    minusculas intercaladas
    */
    @Test
    public void U5F() throws Exception {
        Assert.assertEquals(filterParadas(p, "PlAzA De ToRoS").size(), 1);
    }//U5F
    /*
    Método que comprueba si el tamaño de la lista es de TRES cuando se realiza una consulta con un nombre incompleto existente
    */
    @Test
    public void U5G() throws Exception {
        Assert.assertEquals(filterParadas(p, "Mona").size(), 3);
    }//U5G
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre inexistente
    */
    @Test
    public void U5H() throws Exception {
        Assert.assertEquals(filterParadas(p, "Plazas").size(), 0);
    }//U5H
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un nombre y un valor existentes
    */
    @Test
    public void U5I() throws Exception {
        Assert.assertEquals(filterParadas(p, "9 Valdecilla").size(), 1);
    }//U5I
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre existente y valor inexistente
    */
    @Test
    public void U5J() throws Exception {
        Assert.assertEquals(filterParadas(p, "90 Valdecilla").size(), 0);
    }//U5J
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con nombre y un valor inexistentes
    */
    @Test
    public void U5K() throws Exception {
        Assert.assertEquals(filterParadas(p, "9 Unican").size(), 0);
    }//U5K
    /*
    Método que comprueba si el tamaño de la lista es de cero cuando se realiza una consulta con un nombre existente y un valor inexistente
    */
    @Test
    public void U5L() throws Exception {
        Assert.assertEquals(filterParadas(p, "45 Valdecilla").size(), 0);
    }//U5L
    /*
    Método que comprueba si el tamaño de la lista es de uno cuando se realiza una consulta con un valor y nombre existentes
    separados por dos espacios
    */
    @Test
    public void U5M() throws Exception {
        Assert.assertEquals(filterParadas(p, "9  Valdecilla").size(), 1);
    }//U5AM

}