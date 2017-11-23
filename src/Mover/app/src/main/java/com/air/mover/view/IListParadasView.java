package com.air.mover.view;

import com.air.mover.dao.model.Parada;

import java.util.List;

/**
 * Interfaz que implementará la vista de una lista de paradas de TUS
 * @version 29/10/17
 */
public interface IListParadasView {
    void showList(List<Parada> paradaList);
    void showProgress(boolean state);
}//IListParadasView
