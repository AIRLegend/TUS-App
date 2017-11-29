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
 * Esta clase forma el enlace entre el modelo de datos de los detalles de una parada y
 * la vista correspondiente a los detalles de una parada de la aplicacion
 *
 * @version 22/11/17
 */
public class DetallesParadaPresenter {

    private DetallesParadaActivity view; //Vista de los detalles de una parada
    private ListEstimacionesAdapter adapter; //Adaptador utilizado para mostrar las estimaciones asociados a la parada
    private List<Estimacion> listaEstimacionesParada; //Lista de estimaciones para la parada
    private Context context; //Estado actual de la aplicacion
    private int numParada;//Numero de la parada sobre la cual se consulta informacion

    /**
     * Metodo constructor que inicializa los atributos de la clase
     *
     * @param context estado actual de la aplicacion
     * @param adapter Adaptador utilizado para mostrar las estimaciones de la parada
     * @param numParada Numero de la parada sobre la cual se consultan sus detalles
     */
    public  DetallesParadaPresenter(Context context, ListEstimacionesAdapter adapter, int numParada) {
        this.context = context;
        this.adapter=adapter;
        this.numParada= numParada;
    }

    /**
     * Carga un comentario de la base de datos y lo muestra en la vista.
     * @param name nombre de la parada
     */
    public void loadComment(int id, String name)
    {
        Parada loaded = Database.getCommentParada(id, name,context);
        if (loaded.getComentarios() == null) {
            view.setComment("");
        }//if
        else {
            view.setComment(loaded.getComentarios());
        }//else
    }//loadComment

    /**
     * Modifica un comentario de la base de datos
     * @param id id del comentario
     * @param nombre nombre de la parada
     * @param comment comentario asociado
     */
    public  void setComment(int id, String nombre, String comment) {
        Database.addComment(id,nombre,comment, context);
    }




    /**
     * Clase asincrona que permite descargar las estimaciones para una parada
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
                //Indicamos al usuario que se estan descargando las estimaciones
                view.showProgress(true);
            }//if
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
                }//if
                else
                {
                    view.showProgress(false);
                }//else

                //Actualizamos el adapter de estimaciones para que se muestren por pantalla
                adapter.setListaEstimaciones(estimacionesParada);
                adapter.updateData(estimacionesParada);
            }//if
        } //onPostExecute

    } //LeerEstimacionesInternet


    /**
     *  Metodo que se encarga de poner en marcha el presenter
     *  realizando el enlace entre el modelo y la vista
     */
    public void start()
    {
        //Procedemos a la lectura de la informacion sobre las estimaciones de la parada proporcionadas por el ayuntamiento
        LeerEstimacionesInternet leerLineasInternet= new LeerEstimacionesInternet();
        leerLineasInternet.execute();

    }// start

    /**
     * Metodo que asigna la view para mostrar todas las estimaciones de TUS
     *
     * @param view view para mostrar todas las estimaciones de TUS
     */
    public void setListaEstimacionesParadaView(DetallesParadaActivity view)
    {
        this.view= view;
    }

    /**
     * Metodo que se encarga de actualizar los datos del adapter correspondiente
     * a los detalles de la parada
     */
    public void updateData()
    {
        adapter.updateData(listaEstimacionesParada);
    }


    /**
     * Metodo que asigna una lista de estimaciones a la parada
     *
     * @param listaEstimacionesParada lista de estimaciones
     */
    public void setListaEstimacionesBus(List<Estimacion> listaEstimacionesParada)
    {
        this.listaEstimacionesParada = listaEstimacionesParada;
    }

    /**
     * Metodo a través del cual se almacenan las estimaciones para la parada.
     * Para realizar esto internamente realiza una llamada a la función
     * getJSON (RemoteFetch) para seguidamente parsear el JSON
     * @return true si se han podido almacenar las estimaciones
     * @throws Exception si ha habido problemas para descargar las estimaciones
     */
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
    }//obtenEstimacionesParada


    /**
     * Metodo observador de la lista de estimaciones almacenada
     *
     * @return lista de estimaciones para la parada
     */
    public List<Estimacion> getListaEstimacionesParada() {
        return this.listaEstimacionesParada;
    }//getListaEstimacionesParada

}//DetallesParadaPresenter
