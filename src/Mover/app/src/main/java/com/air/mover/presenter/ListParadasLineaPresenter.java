package com.air.mover.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.air.mover.dao.model.Parada;
import com.air.mover.dao.dataloader.ParserJSON;
import com.air.mover.dao.dataloader.RemoteFetch;
import com.air.mover.view.DetallesLineaActivity;
import com.air.mover.view.IListParadasView;
import com.air.mover.view.ListParadasLineaAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase forma el enlace entre el modelo de datos de paradas de linea de TUS o paradas en general y
 * la vista correspondiente a las paradas de linea de TUS o paradas en general de la aplicacion
 *
 * @version 8/11/17
 */
public class ListParadasLineaPresenter
{
    private IListParadasView listParadasTodasView; //Vista de las paradas de TUS
    private ListParadasLineaAdapter adapter; //Adaptador utilizado para mostrar paradas
    private List<Parada> listaParadasLinea; //Lista de paradas
    private Context context; //Estado actual de la aplicacion
    private int numLinea; //Numero de la linea sobre la cual se consulta la secuancia de paradas

    /**
     * Metodo constructor que inicializa los atributos de
     * la clase. Sera utilizado para mostrar la secuencia de paradas para una linea
     *
     * @param context estado actual de la aplicacion
     * @param adapter Adaptador utilizado para mostrar paradas
     * @param numLinea Numero de la linea sobre la cual se consulta la secuancia de paradas
     */
    public ListParadasLineaPresenter(Context context, ListParadasLineaAdapter adapter, int numLinea)
    {
        this.context= context;
        this.adapter= adapter;
        this.numLinea=numLinea;
    }

    /**
     * Metodo constructor que inicializa los atributos de
     * la clase. Sera utilizado para mostrar las paradas totales
     *
     * @param context estado actual de la aplicacion
     * @param adapter Adaptador utilizado para mostrar paradas
     */
    public ListParadasLineaPresenter(Context context, ListParadasLineaAdapter adapter)
    {
        this.context= context;
        this.adapter= adapter;
        this.numLinea= -10;
    }

    /**
     * Metodo que asigna una secuencia de paradas para una linea
     *
     * @param listaLineasBus secuencia de paradas para la linea
     */
    public void setListaLineasBus(List<Parada> listaLineasBus)
    {
        this.listaParadasLinea = listaLineasBus;
    }

    /**
     * Metodo que asigna la view para mostrar todas las paradas de TUS
     *
     * @param listaParadasTodasView view para mostrar todas las paradas de TUS
     */
    public void setListParadasTodasView(IListParadasView listaParadasTodasView)
    {
        this.listParadasTodasView=listaParadasTodasView;
    }

    /**
     * Metodo que se encarga de actualizar los datos del adapter correspondiente
     * a la secuencia de paradas para una linea
     */
    public void updateData() {
        adapter.updateData(listaParadasLinea);
    }

    /**
     * Clase asincrona que permite descargar las paradas de TUS de internet
     * asi como de almacenarlas. Tambien se encarga de la gestion de la vista
     * durante el proceso entero de descarga y visualizacion
     */
    private class LeerParadasLineaInternet extends AsyncTask<Object, Boolean, Boolean> {
        /**
         * Metodo que se ejecuta antes de iniciar el proceso en el mismo
         * hilo de ejecucion que la aplicacion
         */
        @Override
        protected void onPreExecute() {
            if (context instanceof DetallesLineaActivity)
            {
                //Nos encontramos con la gestion de la secuencia de paradas para una linea
                ((DetallesLineaActivity) (context)).showProgress(true);
            }
            else
            {
                //Nos encontramos con la gestion de todas las paradas de tus existentes
                listParadasTodasView.showProgress(true);
            }

        }//onPreExecute

        /**
         * Metodo que ejecuta la tarea en un hilo diferente al de
         * ejecucion con el fin de no bloquear la interfaz. Se encarga de obtener todas
         * las paradas.
         *
         * @param l
         * @return result true si se ha podido realizar con exito
         */
        @Override
        protected Boolean doInBackground(Object... l) {
            obtenParadasLineas(numLinea);
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
        protected void onPostExecute(Boolean result) {
            if (result)
            {
                List<Parada> paradasLinea = getListaParadasLineaBus();
                if (paradasLinea == null) {
                    paradasLinea = new ArrayList<>();
                }//if

                if (context instanceof DetallesLineaActivity)
                {
                    //Nos encontramos con la gestion de la secuencia de paradas para una linea
                    ((DetallesLineaActivity) (context)).showProgress(false);
                }//if
                else
                {
                    //Nos encontramos con la gestion de todas las paradas de tus existentes
                    listParadasTodasView.showProgress(false);
                }//else

                //Actualizamos el adapter de paradas para que se muestren por pantalla
                adapter.setListaOrginal(paradasLinea);
                adapter.updateData(paradasLinea);
            }//if
        }//onPostExecute

    }//LeerParadasLineaInternet

        /**
         *  Metodo que se encarga de poner en marcha el presenter
         *  realizando el enlace entre el modelo y la vista
         */
        public void start()
        {
            //Procedemos a la lectura de la informacion sobre las paradas proporcionadas por el ayuntamiento
            LeerParadasLineaInternet leerParadasLineaInternet= new LeerParadasLineaInternet();
            leerParadasLineaInternet.execute();

        }// start


        /**
         * Metodo a través del cual se almacenan las paradas. Para realizar esto internamente realiza una llamada a la función
         * getJSON (RemoteFetch) para seguidamente parsear el JSON
         * @return true si se han podido almacenar las paradas
         * @throws Exception si ha habido problemas para descargar las paradas
         */
        public boolean obtenParadasLineas(int identificadorLinea){
            try {
                if (identificadorLinea == -10)
                {
                    //Se obtienen todas las paradas
                    RemoteFetch.getJSON("" + RemoteFetch.URL_PARADAS_BUS);
                    setListaLineasBus(ParserJSON.readParadasTodasList(RemoteFetch.getBufferedData()));
                }//if
                else
                {
                    //Se obtienen todas las paradas de la linea almacenada
                    RemoteFetch.getJSON("" + RemoteFetch.URL_SECUENCIA_PARADAS + identificadorLinea);
                    setListaLineasBus(ParserJSON.readParadasList(RemoteFetch.getBufferedData()));
                }//else
                return true;
            }//try
            catch(Exception e){
                Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
                return false;
            }//catch
        }//obtenParadasLineas

    /**
     * Metodo observador de la lista de paradas almacenada
     *
     * @return lista de paradas almacenadas
     */
    public List<Parada> getListaParadasLineaBus()
        {
            return listaParadasLinea;
        }//getListaParadasLineaBus

    }//ListParadasLineaPresenter

