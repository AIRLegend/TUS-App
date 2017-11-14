package com.air.mover.presenter;

import com.air.mover.dao.model.Linea;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.air.mover.presenter.CommonUtils.filterLineas;

/**
 * Created by Elisa on 14/11/2017.
 */
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
}