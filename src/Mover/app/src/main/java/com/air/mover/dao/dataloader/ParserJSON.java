package com.air.mover.dao.dataloader;

import android.util.JsonReader;

import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Estimacion;
import com.air.mover.dao.model.Parada;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Esta clase se encarga de realizar el parseo de los datos correspondientes a las lineas de los TUS de Santander.
 *  Estos datos son leidos del Open Data proporcionado por el Ayuntamiento de Santander y son representados en un formato denominado JSON.
 *
 *   @version 29/10/17
 */

public class ParserJSON
{
    private static final String RECURSOS_JSON= "resources";
    private static final String UTF8 = "UTF-8";

    //Constructor privado para evitar la creacion de instancias
    private ParserJSON(){}
    /**
     * Método para obtener todas las lineas de buses
     * @param in InputStream del JSON con las lineas de buses
     * @return Lista con todas las lineas
     * @throws IOException
     */
    public static List<Linea> readArrayLineasBus (InputStream in) throws IOException
    {
        JsonReader reader = new JsonReader(new InputStreamReader(in, UTF8));
        List<Linea> listLineasBus = new ArrayList<>();
        reader.beginObject(); //summary y resources
        while (reader.hasNext()){
            String name = reader.nextName();
            if(name.equals (RECURSOS_JSON)){
                reader.beginArray(); //cada elemento del array es un object
                while(reader.hasNext()){
                    listLineasBus.add(readLinea(reader));
                }//while

            }//if
            else{
                reader.skipValue();
            }//else
        }
        //Ordenamos la lista obtenida
        Collections.sort(listLineasBus);

        return listLineasBus;
    }//readArrayLineasBus


    /**
     * Método para obtener todas las paradas de buses
     * @param in InputStream del JSON con las paradas de buses
     * @return Lista con todas las paradas de TUS
     * @throws IOException
     */
    public static List<Parada> readParadasList (InputStream in) throws  IOException
    {
        JsonReader reader = new JsonReader(new InputStreamReader(in, UTF8));
        List<Parada> paradas = new ArrayList<>();
        reader.beginObject();

        while (reader.hasNext())
        {
            String name = reader.nextName();
            if(name.equals (RECURSOS_JSON))
            {
                reader.beginArray(); //cada elemento del array es un object
                while(reader.hasNext())
                {
                    paradas.add(readParada(reader));
                }//while
            }//if
            else
            {
                reader.skipValue();
            }//else
        }//while
        return paradas;
    }//readParadasList



    /**
     * Método para obtener todas (global) las paradas de buses
     * @param in InputStream del JSON con las paradas de buses
     * @return Lista con todas las paradas de TUS
     * @throws IOException
     */
    public static List<Parada> readParadasTodasList (InputStream in) throws  IOException
    {
        JsonReader reader = new JsonReader(new InputStreamReader(in, UTF8));
        List<Parada> paradas = new ArrayList<>();
        reader.beginObject();

        while (reader.hasNext())
        {
            String name = reader.nextName();
            if(name.equals (RECURSOS_JSON))
            {
                reader.beginArray(); //cada elemento del array es un object
                while(reader.hasNext())
                {
                    paradas.add(readParadaGlobal(reader));
                }//while
            }//if
            else
            {
                reader.skipValue();
            }//else
        }//while
        return paradas;
    }//readParadasList


    /**
     * Metodo que se encarga de leer y crear una linea TUS a partir del lector pasado como parametro
     * @param reader lector de los datos con formato JSON
     * @return linea TUS leida
     * @throws IOException
     */
    public static Linea readLinea (JsonReader reader) throws IOException {
        reader.beginObject(); //Leemos un object
        String name ="";
        String numero="";
        int identifier=-1;
        while(reader.hasNext()) {
            String n = reader.nextName();
            if (n.equals("ayto:numero")) {
                numero = reader.nextString();
            }//if
            else if (n.equals("dc:name")) {
                name = reader.nextString();
            }//else if
            else if (n.equals("dc:identifier")) {
                identifier = reader.nextInt();
            }//else if
            else {
                reader.skipValue();
            }//else
        }//while

        reader.endObject();

        return new Linea(name,numero,identifier);

    }//readLinea


    /**
     * Metodo que se encarga de leer y crear una parada de TUS a partir del lector pasado como parametro
     * @param reader lector de los datos con formato JSON
     * @return parada TUS leida
     * @throws IOException
     */
    public static Parada readParada (JsonReader reader) throws IOException
    {
        reader.beginObject(); //Leemos un object
        String name ="";
        double pX = -1.0;
        double pY = -1.0;
        int numParada=-1;
        while(reader.hasNext())
        {
            String n = reader.nextName();
            if (n.equals("ayto:NombreParada"))
            {
                name = reader.nextString();
            }//if
            else if (n.equals("ayto:PosX"))
            {
                pX = reader.nextDouble();
            }//else if
            else if (n.equals("ayto:PosY"))
            {
                pY = reader.nextDouble();
            }//else if
            else if (n.equals("ayto:NParada"))
            {
                numParada = reader.nextInt();
            }//else if
            else
            {
                reader.skipValue();
            }//else
        }//while

        reader.endObject();
        return new Parada(name,pX, pY, numParada);

    }//readParada



    /**
     * Metodo que se encarga de leer y crear una parada de TUS a partir del lector pasado como parametro
     * @param reader lector de los datos con formato JSON
     * @return parada TUS leida
     * @throws IOException
     */
    public static Parada readParadaGlobal (JsonReader reader) throws IOException
    {
        reader.beginObject(); //Leemos un object
        String name ="";
        double pX = -1.0;
        double pY = -1.0;
        int numParada=-1;
        while(reader.hasNext())
        {
            String n = reader.nextName();
            if (n.equals("ayto:parada"))
            {
                name = reader.nextString();
            }//if
            else if (n.equals("gn:coordX"))
            {
                pX = reader.nextDouble();
            }//else if
            else if (n.equals("gn:coordY"))
            {
                pY = reader.nextDouble();
            }//else if
            else if (n.equals("ayto:numero"))
            {
                numParada = reader.nextInt();
            }//else if
            else
            {
                reader.skipValue();
            }//else
        }//while

        reader.endObject();
        return new Parada(name,pX, pY, numParada);

    }//readParada

    /**
     * Método para obtener todas las estimaciones existentes para una parada
     * @param in InputStream del JSON con las lineas de buses
     * @return Lista con todas las estimaciones para la parada
     * @throws IOException
     */
    public static List<Estimacion> readArrayEstimacionesParada (InputStream in) throws IOException
    {
        JsonReader reader = new JsonReader(new InputStreamReader(in, UTF8));
        List<Estimacion> listEstimaciones = new ArrayList<>();
        reader.beginObject(); //summary y resources
        while (reader.hasNext()){
            String name = reader.nextName();
            if(name.equals (RECURSOS_JSON)){
                reader.beginArray(); //cada elemento del array es un object
                while(reader.hasNext()){
                    readEstimacion(reader, listEstimaciones);
                }//while

            }//if
            else{
                reader.skipValue();
            }//else
        }

        //Ordenamos las estimaciones de menor a mayor tiempo restante para la llegada de la linea a la parada
        Collections.sort(listEstimaciones);

        return listEstimaciones;
    }//readArrayEstimacionesParada


    /**
     * Metodo que se encarga de leer y crear dos estimaciones de TUS a partir del lector pasado como parametro.
     * Ademas añade esas dos estimaciones a una lista pasada como parametro
     * @param reader lector de los datos con formato JSON
     * @param listaEstimacion lista sobre la que se anhadiran las dos estimaciones leidas
     */
    public static void readEstimacion (JsonReader reader, List<Estimacion> listaEstimacion) throws IOException
    {
        reader.beginObject(); //Leemos un object

        String numParada ="";
        String numLinea = "";
        String estimacionEnSegundos1="";
        String estimacionEnSegundos2="";
        while(reader.hasNext())
        {
            String n = reader.nextName();
            if (n.equals("ayto:paradaId"))
            {
                numParada = reader.nextString();
            }//if
            else if (n.equals("ayto:etiqLinea"))
            {
                numLinea = reader.nextString();
            }//else if
            else if (n.equals("ayto:tiempo1"))
            {
                estimacionEnSegundos1= reader.nextString();
            }//else if
            else if (n.equals("ayto:tiempo2"))
            {
                estimacionEnSegundos2 = reader.nextString();
            }//else if
            else
            {
                reader.skipValue();
            }//else
        }//while

        if (!numLinea.contains("N")) {
            if(!estimacionEnSegundos1.equals(""))
            {
                //Se trata de una estimacion no vacia, luego anhadimos la estimacion
                listaEstimacion.add(new Estimacion(numLinea,numParada,convierteAMinutos(estimacionEnSegundos1)));
            }//if
            if(!estimacionEnSegundos2.equals(""))
            {
                //Se trata de una estimacion no vacia, luego anhadimos la estimacion
                listaEstimacion.add(new Estimacion(numLinea,numParada,convierteAMinutos(estimacionEnSegundos2)));
            }//if
        }//if
        reader.endObject();
    }//readEstimacion

    /**
     * Metodo encargado de transformar de segundos a minutos el tiempo pasado
     * por parametro
     * @param segundos tiempo en segundos a ser convertidos
     * @return tiempo en minutos
     */
    private static String convierteAMinutos(String segundos)
    {
        return Integer.toString(Integer.parseInt(segundos)/60);
    }//convierteAMinutos


}//ParserJSON
