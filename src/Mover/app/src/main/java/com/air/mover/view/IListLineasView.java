package com.air.mover.view;

import com.air.mover.dao.model.Linea;

import java.util.List;

/**
 * Interfaz que implementará la vista de una lista de lineas de TUS
 * @version 29/10/17
 */
public interface IListLineasView {
    void showList(List<Linea> lineaList);
    void showProgress(boolean state);
}//IListLineasView
