package com.air.mover.DAO.Model;

/**
 * Clase
 */

public class Linea {

    private String name;
    private int identifier;

    public Linea(String name, int identifier){
        this.name = name;
        this.identifier = identifier;
    }//Linea

    public String getName() {
        return name;
    }//getName

    public void setName(String name) {
        this.name = name;
    }//setName

    public int getIdentifier() {
        return identifier;
    }//getIdentifier

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }//setIdentifier
}