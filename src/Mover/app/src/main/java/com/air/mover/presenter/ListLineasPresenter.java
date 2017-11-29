package com.air.mover.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.air.mover.dao.dataloader.ParserJSON;
import com.air.mover.dao.dataloader.RemoteFetch;
import com.air.mover.dao.model.Linea;
import com.air.mover.view.IListLineasView;

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
    private List<Linea> listaLineasBus; //Lista de las lineas


    /**
     * Metodo constructor que inicializa los atributos de
     * la clase
     *
     * @param listLineasView vista donde se mostraran las lineas del TUS
     */
    public ListLineasPresenter(IListLineasView listLineasView)
    {
        this.listLineasView = listLineasView;

    }// ListLineasPresenter

    public void setListaLineasBus(List<Linea> listaLineasBus) {
        this.listaLineasBus = listaLineasBus;
    }


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
                List<Linea> lineas = getListaLineasBus();
                if(lineas == null){
                    lineas = new ArrayList<>();
                }//if
                listLineasView.showList(lineas);
                listLineasView.showProgress(false);
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
            RemoteFetch.getJSON(RemoteFetch.URL_LINEAS_BUS);
            setListaLineasBus(ParserJSON.readArrayLineasBus(RemoteFetch.getBufferedData()));
            return true;
        }//try
        catch(Exception e){
            Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
            return false;
        }//catch
    }//obtenLineas


    public List<Linea> getListaLineasBus() {
        return listaLineasBus;
    }//getListaLineasBus


    /**
     * Metodo que actualiza la lista del adapter en funcion del texto que se manda.
     * @param query a buscar
     */
    public void filterLineas(String query) {
        listLineasView.showList(CommonUtils.filterLineas(listaLineasBus, query));
    }

}// ListLineasPresenter

