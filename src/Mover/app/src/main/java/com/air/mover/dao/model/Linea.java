package com.air.mover.dao.model;

import android.support.annotation.NonNull;

/**
 * Clase que almacena la información referente a una línea de TUS
 *
 * @version 29/10/17
 */

public class Linea implements Comparable<Linea>
 {

    private String name; //Nombre de la linea TUS
    private String numero; //Numero de la linea TUS
    private int identifier; //Identificador de la linea TUS utilizado por el Ayuntamiento de Santander


     /**
      * Metodo constructor que se encarga de inicializar los atributos de la clase
      * en base a los parametros pasados
      *
      * @param name Nombre de la linea TUS
      * @param numero Numero de la linea TUS
      * @param identifier Identificador de la linea TUS
      */
     public Linea(String name, String numero, int identifier)
     {
        this.name = name;
        this.numero = numero;
        this.identifier = identifier;
    }//Linea

     /**
      * Metodo observador del atributo name
      *
      * @return Nombre de la linea TUS
      */
    public String getName() {
        return name;
    }//getName

     /**
      * Metodo que se encarga de modificar el nombre de la linea de TUS
      *
      * @param name Nombre nuevo de la linea de TUS
      */
    public void setName(String name) {
        this.name = name;
    }//setName

     /**
      * Metodo observador del atributo numero de TUS
      *
      * @return Numero de la linea TUS
      */
    public String getNumero() {
        return numero;
    } //getNumero

     /**
      * Metodo que se encarga de modificar el numero de la linea de TUS
      *
      * @param numero Numero nuevo de la linea de TUS
      */
    public void setNumero(String numero) {
        this.numero = numero;
    }//setNumero

     /**
      * Metodo observador del atributo identifier
      *
      * @return Identificador de la linea TUS
      */
    public int getIdentifier() {
        return identifier;
    }//getIdentifier

    /**
      * Metodo que se encarga de modificar el identificador de la linea de TUS
      *
      * @param identifier Identificador nuevo de la linea de TUS
      */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    } //setIdentifier


     /**
      * Metodo que se encarga de comparar la linea TUS con otra
      * @param linea linea TUS con la que se realiza la comparacion
      * @return 0 si this=linea, <0 si this<linea, >0 si this>linea
      */
     @Override
     public int compareTo(@NonNull Linea linea)
     {
         return identifier - linea.getIdentifier();
     }//compareTo

     /**
      * Metodo que se encarga de dictaminar si el objeto pasado como parametro
      * es igual al objeto this
      * @param obj objeto con el que se comprueba si es igual
      * @return true si es igual, false en caso contrario
      */
     @Override
     public boolean equals(Object obj) {
         if(obj instanceof Linea){
             Linea l = (Linea) obj;
             if(l.getName().equals(name) && l.getNumero().equals(numero) && l.getIdentifier()==identifier){
                 return true;
             }//if
         }//if
         return false;
     }//equals

     /**
      * Metodo encargado de generar el codigo hash del objeto this
      * @return codigo hash del objeto this
      */
     @Override
     public int hashCode() {
         return super.hashCode();
     }//hashCode

     /**
      * Metodo encargado de describir el objeto this a modo de string
      * @return descripcion del objeto this
      */
     @Override
     public String toString()
     {
        return numero +" "+name;
     }//toString

 }//Linea
