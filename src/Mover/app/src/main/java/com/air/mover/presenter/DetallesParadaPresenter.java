package com.air.mover.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.air.mover.view.DetallesParadaActivity;
import com.air.mover.dao.database.Database;
import com.air.mover.dao.dataloader.ParserJSON;
import com.air.mover.dao.dataloader.RemoteFetch;
import com.air.mover.dao.model.Estimacion;
import com.air.mover.dao.model.Parada;
import com.air.mover.view.ListEstimacionesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by air on 22/11/17.
 */

public class DetallesParadaPresenter {

    private DetallesParadaActivity view;
    private ListEstimacionesAdapter adapter;
    private List<Estimacion> listaEstimacionesParada;
    private Context context;
    private int numParada;



    public  DetallesParadaPresenter(Context context, ListEstimacionesAdapter adapter, int numParada) {
        this.context = context;
        this.adapter=adapter;
        this.numParada= numParada;
    }

    /**
     * Carga un comentario de la base de datos y lo muestra en la vista.
     * @param name nombre de la parada
     */
    public void loadComment(int id, String name) {
        Parada loaded = Database.getCommentParada(id, name,context);
        if (loaded.getComentarios() == null) {
            view.setComment("");
        } else {
            view.setComment(loaded.getComentarios());
        }


    }

    public  void setComment(int id, String nombre, String comment) {
        Database.addComment(id,nombre,comment, context);
    }




    /**
     * Clase asincrona que permite descargar las lineas de TUS de internet
     * asi como de almacenarlas. Tambien se encarga de la gestion de la vista
     * durante el proceso entero de descarga y visualizacion
     */
    private class LeerEstimacionesInternet extends AsyncTask<Object, Boolean, Boolean>
    {
        /**
         * Metodo que se ejecuta antes de iniciar el proceso en el mismo
         * hilo de ejecucion que la aplicacion
         */
        @Override
        protected void onPreExecute()
        {
            if (context instanceof DetallesParadaActivity)
            {
                view.showProgress(true);
            }
        }//onPreExecute

        /**
         * Metodo que ejecuta la tarea en un hilo diferente al de
         * ejecucion con el fin de no bloquear la interfaz
         *
         * @param l
         * @return result
         */
        @Override
        protected Boolean doInBackground(Object... l)
        {
            obtenEstimacionesParada(numParada);
            return true;
        }//doInBackground

        /**
         * Metodo que se ejecuta cuando finaliza el metodo doInBackground
         * y recibe el resultado de dicho metodo para tratarlo y actualizar
         * la interfaz de usuario en consecuencia
         *
         * @param result resultado del metodo doInBackground
         */
        @Override
        protected void onPostExecute(Boolean result)
        {
            if (result) {
                List<Estimacion> estimacionesParada = listaEstimacionesParada;
                if (estimacionesParada == null) {
                    estimacionesParada = new ArrayList<>();
                }//if

                if (context instanceof DetallesParadaActivity) {
                    ((DetallesParadaActivity) (context)).showProgress(false);
                }
                else
                {
                    view.showProgress(false);
                }
                adapter.setListaEstimaciones(estimacionesParada);
                adapter.updateData(estimacionesParada);
            }//if
        }

    }


    /**
     *  Metodo que se encarga de poner en marcha el presenter
     *  realizando el enlace entre el modelo y la vista
     */
    public void start()
    {
        //Procedemos a la lectura de la informacion sobre las lineas proporcionadas por el ayuntamiento
        LeerEstimacionesInternet leerLineasInternet= new LeerEstimacionesInternet();
        leerLineasInternet.execute();

    }// start


    public void setListaEstimacionesParadaView(DetallesParadaActivity view)
    {
        this.view= view;
    }

    public void updateData()
    {
        adapter.updateData(listaEstimacionesParada);
    }



    public void setListaEstimacionesBus(List<Estimacion> listaEstimacionesParada)
    {
        this.listaEstimacionesParada = listaEstimacionesParada;
    }

    public boolean obtenEstimacionesParada(int identificadorParada)
    {
        try
        {
            RemoteFetch.getJSON("" + RemoteFetch.URL_ESTIMACION + ""+identificadorParada);
            setListaEstimacionesBus( ParserJSON.readArrayEstimacionesParada(RemoteFetch.getBufferedData()));
            return true;
        }//try
        catch(Exception e){
            Log.e("ERROR","Error en la obtención de las estimaciones de Bus: "+e.getMessage());
            return false;
        }//catch
    }//obtenLineas


    public List<Estimacion> getListaEstimacionesParada() {
        return this.listaEstimacionesParada;
    }//getListaLineasBus




}
