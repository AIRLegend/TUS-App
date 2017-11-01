package com.air.mover.Presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.air.mover.DAO.DataLoader.ParserJSON;
import com.air.mover.DAO.DataLoader.RemoteFetch;
import com.air.mover.DAO.Model.Linea;
import com.air.mover.View.IListLineasView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alejandro on 11/10/17.
 */




public class ListLineasPresenter
{
    private IListLineasView listLineasView;
    private List<Linea> listaLineasBus;
    private RemoteFetch remoteFetchLineas;
    private Context context;




    public ListLineasPresenter(Context context, IListLineasView listLineasView)
    {
        this.listLineasView = listLineasView;
        this.context = context;
        this.remoteFetchLineas = new RemoteFetch();
    }// ListLineasPresenter



    private class LeerLineasInternet extends AsyncTask<Object, Boolean, Boolean>
    {
        @Override
        protected void onPreExecute()
        {
            listLineasView.showProgress(true);
        }

        @Override
        protected Boolean doInBackground(Object... l)
        {
            obtenLineas();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result)
        {
            if (result) {
                List<Linea> lineas = getListaLineasBus();
                if(lineas==null){
                    lineas=new ArrayList<Linea>();
                }
                listLineasView.showList(lineas);
                listLineasView.showProgress(false);
            }

        }
    }


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
        try {
            remoteFetchLineas.getJSON(RemoteFetch.URL_LINEAS_BUS);;
            listaLineasBus = ParserJSON.readArrayLineasBus(remoteFetchLineas.getBufferedData());
            return true;
        }catch(Exception e){
            Log.e("ERROR","Error en la obtención de las lineas de Bus: "+e.getMessage());
            e.printStackTrace();
            return false;
        }//try
    }//obtenLineas


    public List<Linea> getListaLineasBus() {
        return listaLineasBus;
    }//getListaLineasBus


    /**
     * Método para obtener un cadena de texto con todas las lineas. En esta cadena
     * se muestra unicamente el nombre de la linea
     *  @return String con todas las gasolineras separadas por un doble salto de línea
     */
    public String getTextoLineas(){
        String textoLineas="";
        if(listaLineasBus!=null)
        {
            for (int i=0; i<listaLineasBus.size(); i++){
                textoLineas=textoLineas+listaLineasBus.get(i).getIdentifier()+"\n\n";
            }//for
        }else{
            textoLineas="Sin lineas";
        }//if
        return textoLineas;
    }//getTextoLineas

}// ListLineasPresenter

