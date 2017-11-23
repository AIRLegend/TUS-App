package com.air.mover.dao.model;

/**
 * Clase que almacena la información referente a una parada de TUS
 *
 * @version 06/11/17
 */

public class Parada
{

    private String nombre;//Nombre de la parada
    private String comentarios; //Comentarios de usuario de la parada
    private double posX; //Posicion x de la parada en un mapa (visto como un eje de coordenadas xy)
    private double posY; //Posicion y de la parada en un mapa (visto como un eje de coordenadas xy)
    private int numParada; //Numero de la parada

    /**
     * Metodo constructor que se encarga de inicializar los atributos de la clase
     * en base a los parametros pasado.
     *
     * @param nombre Nombre de la parada de TUS
     * @param posX //Posicion x de la parada en un mapa (visto como un eje de coordenadas xy)
     * @param posY Posicion y de la parada en un mapa (visto como un eje de coordenadas xy)
     * @param numParada Numero de la parada
     */
    public Parada(String nombre, double posX, double posY, int numParada)
    {
        this.setNombre(nombre);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setNumParada(numParada);

    }//Parada

    /**
     * Metodo observador del atributo nombre
     *
     * @return Nombre de la parada de TUS
     */
    public String getNombre() {
        return nombre;
    } //getNombre

    /**
     * Metodo que se encarga de modificar el nombre de la parada de TUS
     *
     * @param nombre Nombre nuevo de la parada de TUS
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } //setNombre


    /**
     * Metodo observador del atributo posX
     *
     * @return Posicion x en el mapa de la parada de TUS
     */
    public double getPosX() {
        return posX;
    } //getPosX

    /**
     * Metodo que se encarga de modificar la posicion x en el mapa de la parada de TUS
     *
     * @param posX nueva posicion x de la parada en el mapa
     */
    public void setPosX(double posX) {
        this.posX = posX;
    } //setPosX

    /**
     * Metodo observador del atributo posY
     *
     * @return Posicion y en el mapa de la parada de TUS
     */
    public double getPosY() {
        return posY;
    } //getPosY

    /**
     * Metodo que se encarga de modificar la posicion y en el mapa de la parada de TUS
     *
     * @param posY nueva posicion y de la parada en el mapa
     */
    public void setPosY(double posY) {
        this.posY = posY;
    } //setPosY

    /**
     * Metodo observador del atributo numParada
     *
     * @return Numero de la parada de TUS
     */
    public int getNumParada() {
        return numParada;
    } //getNumParada

    /**
     * Metodo que se encarga de modificar el numero de la parada de TUS
     *
     * @param numParada Numero nuevo a asignar a la parada
     */
    public void setNumParada(int numParada) {
        this.numParada = numParada;
    } //setNumParada

    public String getComentarios() {return comentarios;}

    public void setComentarios(String comentarios) {this.comentarios = comentarios;}

    @Override
    public String toString()
    {
        return (numParada+" "+ nombre);
    }
}