package com.air.mover.view;

/**
 * Interfaz que implementará la activitidad MainActivity para tener métodos que nos permitan comunicar
 * los distintos fragments de la app
 *
 * @version 29/10/17
 */
public interface DataCommunication
{
    public int getLineaIdentifier();
    public void setLineaIdentifier(int identifier);
    public int getParadaIdentifier();
    public void setParadaIdentifier(int paradaIdentifier);

}//DataCommunication
