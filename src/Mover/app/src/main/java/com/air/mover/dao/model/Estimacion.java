package com.air.mover.dao.model;

import android.support.annotation.NonNull;

/**
 * Created by Adribece on 24/11/2017.
 */

public class Estimacion implements Comparable<Estimacion>
{
    private String numLinea;
    private String numParada;
    private String tiempoParaLlegada;
    private static String MENSAJE_LLEGADA="Llegando";

    public Estimacion(String numLinea, String numParada, String segundosParaLlegada)
    {
        this.numLinea=numLinea;
        this.numParada=numParada;
        this.tiempoParaLlegada=segundosParaLlegada;
    }

    public String getNumLinea()
    {
        return this.numLinea;
    }

    public String getNumParada()
    {
        return this.numParada;
    }

    public String getTiempoParaLlegada()
    {
        return tiempoParaLlegada;
    }

    public String getTiempoLlegadaParaMostrar()
    {
        if(tiempoParaLlegada.equals("0"))
        {
            return MENSAJE_LLEGADA;
        }
        return this.tiempoParaLlegada+" min";
    }

    @Override
    public int compareTo(@NonNull Estimacion e)
    {
        return Integer.parseInt(this.tiempoParaLlegada) - Integer.parseInt(e.getTiempoParaLlegada());
    }//compareTo




}
