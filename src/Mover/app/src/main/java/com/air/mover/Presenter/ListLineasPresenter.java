package com.air.mover.Presenter;

import android.app.*;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.air.mover.DAO.DataLoader.ParserJSON;
import com.air.mover.DAO.DataLoader.RemoteFetch;
import com.air.mover.DAO.Model.Linea;
import com.air.mover.R;
import com.air.mover.View.IListLineasView;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase forma el enlace entre el modelo de datos de lineas de TUS y
 * la vista correspondiente a las lineas de TUS de la aplicacion
 *
 * @version 30/10/17
 */

public class ListLineasPresenter
{
    private IListLineasView listLineasView; //Vista de las lineas de TUS
    private List<Linea> listaLineasBus;
    private RemoteFetch remoteFetchLineas; //Modelo de datos lineas de TUS
    private Context context;


    /**
     * Metodo constructor que inicializa los atributos de
     * la clase
     *
     * @param context contexto de la aplicacion
     * @param listLineasView vista donde se mostraran las lineas del TUS
     */
    public ListLineasPresenter(Context context, IListLineasView listLineasView)
    {
        this.listLineasView = listLineasView;
        this.context = context;
        this.remoteFetchLineas = new RemoteFetch();
    }// ListLineasPresenter


    /**
     * Clase asincrona que permite descargar las lineas de TUS de internet
     * asi como de almacenarlas. Tambien se encarga de la gestion de la vista
     * durante el proceso entero de descarga y visualizacion
     */
    private class LeerLineasInternet extends AsyncTask<Object, Boolean, Boolean>
    {
        /**
         * Metodo que se ejecuta antes de iniciar el proceso en el mismo
         * hilo de ejecucion que la aplicacion
         */
        @Override
        protected void onPreExecute()
        {
            listLineasView.showProgress(true);
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
            obtenLineas();
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
                listLineasView.showList(getListaLineasBus());
                listLineasView.showProgress(false);
            }//if
        }//onPostExecute
    }


    /**
     *  Metodo que se encarga de poner en marcha el presenter
     *  realizando el enlace entre el modelo y la vista
     */
    public void start()
    {
        //Procedemos a la lectura de la informacion sobre las lineas proporcionadas por el ayuntamiento
         LeerLineasInternet leerLineasInternet= new LeerLineasInternet();
         leerLineasInternet.execute();

    }// start


    /**
     * Método a través del cual se almacenan las lineas de buses en el atributo listaLineasBus
     * de esta clase. Para realizar esto internamente realiza una llamada a la función
     * getJSON (RemoteFetch) para seguidamente parsear el JSON obtenido con la llamada
     * a readArrayLineasBus (ParserJSON)
     * @return
     */
    public boolean obtenLineas(){
        try
        {
            remoteFetchLineas.getJSON(RemoteFetch.URL_LINEAS_BUS);;
            listaLineasBus = ParserJSON.readArrayLineasBus(remoteFetchLineas.getBufferedData());
            return true;
        }//try
        catch(Exception e){
            Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
            e.printStackTrace();
            return false;
        }//catch
    }//obtenLineas


    public List<Linea> getListaLineasBus() {
        return listaLineasBus;
    }//getListaLineasBus


}// ListLineasPresenter

