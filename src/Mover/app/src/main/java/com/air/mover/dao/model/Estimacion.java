package com.air.mover.dao.model;

import android.support.annotation.NonNull;

/**
 * Clase que almacena la información referente a las estimaciones de una parada de TUS
 *
 * @version 29/11/17
 */
public class Estimacion implements Comparable<Estimacion>
{
    private String numLinea;//Numero de la linea
    private String numParada; //Numero de la parada
    private String tiempoParaLlegada; // Tiempo para que llegue la linea a la parada en minutos
    private static final String MENSAJE_LLEGADA="Llegando"; //Mensaje para cuando el tiempo para la llegada es menor de 1 min

    /**
     * Metodo constructor que se encarga de inicializar los atributos de la clase
     * en base a los parametros pasados
     * @param numLinea Numero de la linea
     * @param numParada Numero de la parada
     * @param minutosParaLlegada // Tiempo para que llegue la linea a la parada en minutos
     */
    public Estimacion(String numLinea, String numParada, String minutosParaLlegada)
    {
        this.numLinea=numLinea;
        this.numParada=numParada;
        this.tiempoParaLlegada=minutosParaLlegada;
    }//Estimacion

    /**
     * Metodo observador del atributo numero de linea de TUS
     *
     * @return Numero de la linea TUS
     */
    public String getNumLinea()
    {
        return this.numLinea;
    } //getNumLinea

    /**
     * Metodo observador del atributo parada de TUS
     *
     * @return Numero de la parada TUS
     */
    public String getNumParada()
    {
        return this.numParada;
    } //getNumParada

    /**
     * Metodo observador del atributo tiempo para la llegada de la linea a la parada en minutos
     *
     * @return Tiempo en minutos para que llegue la linea a la parada
     */
    public String getTiempoParaLlegada()
    {
        return tiempoParaLlegada;
    } //getTiempoParaLlegada

    /**
     * Metodo que devuelve la cadena que se quiere mostrar al usuario
     * @return MENSAJE_LLEGADA si el tiempo que falta para que llegue la linea a la parada
     *         es inferior a 1 min o bien el tiempo en minutos en caso contrario
     */
    public String getTiempoLlegadaParaMostrar()
    {
        if(tiempoParaLlegada.equals("0"))
        {
            //Queda menos de un minuto
            return MENSAJE_LLEGADA;
        }//if
        return this.tiempoParaLlegada+" min";
    } //getTiempoLlegadaParaMostrar

    /**
     * Metodo que se encarga de comparar una estimacion con otra en base al tiempo que queda
     * para que la linea llegue a la parada
     * @param e estimacion con la que se realiza la comparacion
     * @return 0 si this=e, <0 si this<e, >0 si this>e
     */
    @Override
    public int compareTo(@NonNull Estimacion e)
    {
        return Integer.parseInt(this.tiempoParaLlegada) - Integer.parseInt(e.getTiempoParaLlegada());
    }//compareTo

    /**
     * Metodo que se encarga de dictaminar si el objeto pasado como parametro
     * es igual al objeto this
     * @param obj objeto con el que se comprueba si es igual
     * @return true si es igual, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Estimacion){
            Estimacion e = (Estimacion) obj;
            if(e.getNumLinea().equals(numLinea) && e.getNumParada().equals(numParada) && e.getTiempoParaLlegada().equals(tiempoParaLlegada)){
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
}
