package com.air.mover.presenter;

import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase comun que contiene metodos que se pueden re-usar. Asi queda un codigo mas limpio y
 * con menos copy/paste
 *
 * @version 14/11/17
 */
public class CommonUtils
{

    /**
     * Ocultar el constructor para que no se creen instancias de esta clase
     */
    private CommonUtils () {}

    /**
     * Filtra una lista de lineas en base al texto que se pasa
     * @param lineaOriginal lista que se quiere filtrar
     * @param query texto de busqueda
     * @return nueva lista con las coincidencias
     */
    public static List<Linea> filterLineas(List<Linea> lineaOriginal, String query)
    {
        List<Linea> nuevaLista = new ArrayList<>();
        query = query.replaceAll("( +)", " ").trim().toLowerCase();

        if (query.length() == 0)
        {
            return lineaOriginal;
        }//if
        else
        {
            for (Linea l : lineaOriginal)
            {
                if (l.toString().toLowerCase().contains(query))
                {
                    nuevaLista.add(l);
                }//if
            }//for
        }//else
        return nuevaLista;
    }//filterLineas


    /**
     * Filtra una lista de lineas en base al texto que se pasa
     * @param listOriginal lista que se quiere filtrar
     * @param query texto de busqueda
     * @return nueva lista con las coincidencias
     */
    public static List<Parada> filterParadas(List<Parada> listOriginal, String query) {
        List<Parada> nuevaListaParadas = new ArrayList<>();
        query = query.replaceAll("( +)", " ").trim().toLowerCase();

        if (query.length() == 0)
        {
            return listOriginal;
        }//if
        else
        {
            for (Parada p : listOriginal) {
                if (p.toString().toLowerCase().contains(query)) {
                    nuevaListaParadas.add(p);
                }//if
            }//for
        }//else
        return nuevaListaParadas;
    } //filterParadas
}