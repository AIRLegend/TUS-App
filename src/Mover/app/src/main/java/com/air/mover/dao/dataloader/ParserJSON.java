package com.air.mover.dao.dataloader;

import android.util.JsonReader;

import com.air.mover.dao.Model.Linea;
import com.air.mover.dao.Model.Parada;

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

public class ParserJSON{

    /**
     * Método para obtener todas las lineas de buses
     * @param in InputStream del JSON con las lineas de buses
     * @return Lista con todas las lineas
     * @throws IOException
     */
    public static List<Linea> readArrayLineasBus (InputStream in) throws IOException
    {
            JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
            List<Linea> listLineasBus = new ArrayList<>();
            reader.beginObject(); //summary y resources
            while (reader.hasNext()){
                    String name = reader.nextName();
                    if(name.equals ("resources")){
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
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<Parada> paradas = new ArrayList<Parada>();
        reader.beginObject();

        while (reader.hasNext())
        {
            String name = reader.nextName();
            if(name.equals ("resources"))
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
        double pX = -1.0, pY = -1.0;
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


}//ParserJSON
