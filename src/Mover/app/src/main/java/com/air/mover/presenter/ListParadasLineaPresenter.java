package com.air.mover.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;

import com.air.mover.dao.model.Parada;
import com.air.mover.dao.dataloader.ParserJSON;
import com.air.mover.dao.dataloader.RemoteFetch;
import com.air.mover.view.DetallesLineaActivity;
import com.air.mover.view.IListParadasView;
import com.air.mover.view.ListParadasLineaAdapter;
import com.air.mover.view.paradasfragments.ParadasTodasFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adribece on 08/11/2017.
 */

public class ListParadasLineaPresenter
{
    private IListParadasView listParadasTodasView; //Vista de las paradas de TUS
    private ListParadasLineaAdapter adapter;
    private List<Parada> listaParadasLinea;
    private Context context;
    private int numLinea;


    public ListParadasLineaPresenter(Context context, ListParadasLineaAdapter adapter, int numLinea)
    {
        this.context= context;
        this.adapter= adapter;
        this.numLinea=numLinea;
    }

    public ListParadasLineaPresenter(Context context, ListParadasLineaAdapter adapter)
    {
        this.context= context;
        this.adapter= adapter;
        this.numLinea= -10;
    }

    public void setListaLineasBus(List<Parada> listaLineasBus)
    {
        this.listaParadasLinea = listaLineasBus;
    }

    public void setListParadasTodasView(IListParadasView listaParadasTodasView)
    {
        this.listParadasTodasView=listaParadasTodasView;
    }

    public void updateData() {
        adapter.updateData(listaParadasLinea);
    }

    /**
     * Clase asincrona que permite descargar las lineas de TUS de internet
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
                ((DetallesLineaActivity) (context)).showProgress(true);
            else
            {
                listParadasTodasView.showProgress(true);
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
            if (result) {
                List<Parada> paradasLinea = getListaParadasLineaBus();
                if (paradasLinea == null) {
                    paradasLinea = new ArrayList<>();
                }//if

                if (context instanceof DetallesLineaActivity) {
                    ((DetallesLineaActivity) (context)).showProgress(false);
                }
                else
                {
                    listParadasTodasView.showProgress(false);
                }
                adapter.setListaOrginal(paradasLinea);
                adapter.updateData(paradasLinea);
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
            LeerParadasLineaInternet leerParadasLineaInternet= new LeerParadasLineaInternet();
            leerParadasLineaInternet.execute();

        }// start


        /**
         * Método a través del cual se almacenan las lineas de buses en el atributo listaLineasBus
         * de esta clase. Para realizar esto internamente realiza una llamada a la función
         * getJSON (RemoteFetch) para seguidamente parsear el JSON obtenido con la llamada
         * a readArrayLineasBus (ParserJSON)
         * @return
         */
        public boolean obtenParadasLineas(int identificadorLinea){
            try {
                if (identificadorLinea == -10) {  //Se obtienen todas las paradas
                    RemoteFetch.getJSON("" + RemoteFetch.URL_PARADAS_BUS);
                    setListaLineasBus(ParserJSON.readParadasTodasList(RemoteFetch.getBufferedData()));
                } else {
                    RemoteFetch.getJSON("" + RemoteFetch.URL_SECUENCIA_PARADAS + identificadorLinea);
                    setListaLineasBus(ParserJSON.readParadasList(RemoteFetch.getBufferedData()));
                }

                return true;
            }//try
            catch(Exception e){
                Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
                return false;
            }//catch
        }//obtenLineas


        public List<Parada> getListaParadasLineaBus() {
            return listaParadasLinea;
        }//getListaLineasBus

    }

