package com.air.mover.View;

import com.air.mover.DAO.Model.Linea;

import java.util.List;

/**
 * Created by alejandro on 11/10/17.
 */

public interface IListLineasView {
    void showList(List<Linea> lineaList);
    void showProgress(boolean state);
}//IListLineasView
