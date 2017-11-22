package com.air.mover.presenter;

import android.content.Context;
import android.provider.ContactsContract;

import com.air.mover.DetallesParadaActivity;
import com.air.mover.dao.database.Database;
import com.air.mover.dao.model.Parada;

/**
 * Created by air on 22/11/17.
 */

public class DetallesParadaPresenter {

    private Context context;
    private DetallesParadaActivity view;

    public  DetallesParadaPresenter(DetallesParadaActivity detalles, Context context) {
        this.context = context;
        this.view = detalles;
    }

    /**
     * Carga un comentario de la base de datos y lo muestra en la vista.
     * @param name nombre de la parada
     */
    public void loadComment(String name) {
        Parada loaded = Database.getCommentParada(name,context);
        if (loaded.getComentarios() == null) {
            view.setComment("");
        } else {
            view.setComment(loaded.getComentarios());
        }


    }

    public  void setComment(int id, String nombre, String comment) {
        Database.addComment(id,nombre,comment, context);
    }

}
