package com.air.mover.view.callbacks;

import com.air.mover.dao.model.Linea;
import com.air.mover.dao.model.Parada;

/**
 * Created by air on 7/11/17.
 */

public interface CallbackParadasLinea {

    void callback(Linea linea);
    void callbackParada(Parada parada);
}
