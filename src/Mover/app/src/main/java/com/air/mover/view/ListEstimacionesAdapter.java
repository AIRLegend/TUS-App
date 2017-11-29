package com.air.mover.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.air.mover.R;
import com.air.mover.dao.model.Estimacion;
import java.util.Collections;
import java.util.List;

/**
 * Adaptador de la lista de estimaciones de autobuses.
 * Created by Adribece on 24/11/2017.
 */

public class ListEstimacionesAdapter extends RecyclerView.Adapter<ListEstimacionesAdapter.ViewHolderEstimacionesParada>
{
    Context context; //Estado actual de la aplicacion
    private List<Estimacion> mData = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private View viewRow;


    public ListEstimacionesAdapter(Context context)
    {
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
    }//ListParadasLineaAdapter

    @Override
    public ViewHolderEstimacionesParada onCreateViewHolder(ViewGroup parent, int viewType) {
        viewRow= mInflater.inflate(R.layout.custom_list_estimaciones_layout, parent, false);
        return  new ViewHolderEstimacionesParada(viewRow);
    }//onCreateViewHolder

    /**
     * Metodo que se ejecuta al "acoplar" el ViewHolder a la view padre.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolderEstimacionesParada holder, int position) {

        //Modificacion del color del numero de la linea del TUS
        String numLinea=mData.get(position).getNumLinea();
        SpannableStringBuilder builder= new SpannableStringBuilder();
        SpannableString s1;
        s1= new SpannableString(numLinea);

        ImageView ima= (ImageView) viewRow.findViewById(R.id.imageViewBusEstimaciones);
        int color= getLineaColor(numLinea, ima);

        s1.setSpan(new ForegroundColorSpan(color),0,s1.length() ,0);
        builder.append(s1);

        //Escribimos el numero de la linea del TUS
        holder.textViewNumeroLinea.setText(builder);
        holder.textViewEstimacionSegundos.setText(mData.get(position).getTiempoLlegadaParaMostrar()); //Forzar la conversion a String.

    }//onBindViewHolder


    public void setListaEstimaciones(List<Estimacion> lista)
    {
        this.mData= lista;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public void updateData(List<Estimacion> estimaciones)
    {
        this.mData = estimaciones;
        notifyDataSetChanged();
    }

    public Estimacion getItem(int id)
    {
        return mData.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }//setClickListener



    /**
     * Esta clase almacena los "items" de la lista (vistas) cuando salen de la pantalla.
     */
    public class ViewHolderEstimacionesParada extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewNumeroLinea;
        private TextView textViewEstimacionSegundos;

        public ViewHolderEstimacionesParada(View itemView) {
            super(itemView);
            textViewNumeroLinea = (TextView) itemView.findViewById(R.id.txtNumLinea);
            textViewEstimacionSegundos = (TextView) itemView.findViewById(R.id.txtEstimacionSegundos);
            itemView.setOnClickListener(this);
        }//ViewHolder

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }//onClick
    }//ViewHolder (class)


    /**
     * La activity padre debe implementar esta interfaz si quiere manejar los clics en los items.
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }//ItemClickListener

    /**
     * Metodo que se encarga de retornar el color de linea asociada a la linea pasada por parametro
     * y de asignar dicho color a la imagen pasada por parametro
     *
     * @param s Linea de la cual se quiere calcular su color
     * @return
     */
    @SuppressLint("ResourceType")
    public int getLineaColor(String s, ImageView imagen)
    {
        Resources r= context.getResources();

        //Las lineas no registradas pooseran todas un color por defecto
        int c= r.getColor(R.color.LineaPorDefecto);
        imagen.setColorFilter(ContextCompat.getColor(context, R.color.LineaPorDefecto));

        if(s.equals("1"))
        {
            //Color correspondiente a la Linea 1
            c= r.getColor(R.color.Linea1);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea1));
        }//if
        else if(s.equals("2"))
        {
            //Color correspondiente a las Lineas 2
            c= context.getResources().getColor(R.color.Linea2);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea2));
        }//else if
        else if(s.equals("3"))
        {
            //Color correspondiente a las Lineas 3
            c= r.getColor(R.color.Linea3);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea3));
        }//else if
        else if(s.equals("4"))
        {
            //Color correspondiente a las Lineas 4
            c= r.getColor(R.color.Linea4);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea4));
        }//else if
        else if(s.startsWith("5"))
        {
            //Color correspondiente a las Lineas 5
            c= r.getColor(R.color.Linea5);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea5));
        }//else if
        else if(s.startsWith("6"))
        {
            //Color correspondiente a las Lineas 6
            c= r.getColor(R.color.Linea6);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea6));
        }//else if
        else if(s.startsWith("7"))
        {
            //Color correspondiente a las Lineas 7
            c= r.getColor(R.color.Linea7);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea7));
        }//else if
        else if(s.equals("11"))
        {
            //Color correspondiente a las Lineas 11
            c= r.getColor(R.color.Linea11);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea11));
        }//else if
        else if(s.equals("12"))
        {
            //Color correspondiente a las Lineas 12
            c= r.getColor(R.color.Linea12);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea12));
        }//else if
        else if(s.equals("13"))
        {
            //Color correspondiente a las Lineas 13
            c= r.getColor(R.color.Linea13);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea13));
        }//else if
        else if(s.equals("14"))
        {
            //Color correspondiente a las Lineas 14
            c= r.getColor(R.color.Linea14);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea14));
        }//else if
        else if(s.equals("16"))
        {
            //Color correspondiente a las Lineas 16
            c= context.getResources().getColor(R.color.Linea16);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea16));
        }//else if
        else if(s.startsWith("17"))
        {
            //Color correspondiente a las Lineas 17
            c= r.getColor(R.color.Linea17);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea17));
        }//else if
        else if(s.startsWith("18"))
        {
            //Color correspondiente a las Lineas 18
            c= r.getColor(R.color.Linea18);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea18 ));
        }//else if
        else if(s.equals("19"))
        {
            //Color correspondiente a las Lineas 19
            c= r.getColor(R.color.Linea19);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea19));
        }//else if
        else if(s.equals("20"))
        {
            //Color correspondiente a las Lineas 20
            c= r.getColor(R.color.Linea20);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea20));
        }//else if
        else if(s.equals("21"))
        {
            //Color correspondiente a las Lineas 21
            c= r.getColor(R.color.Linea21);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea21));
        }//else if
        else if(s.equals("23"))
        {
            //Color correspondiente a las Lineas 23
            c= r.getColor(R.color.Linea23);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.Linea23));
        }//else if
        else if(s.startsWith("N"))
        {
            //Color correspondiente a las Lineas de noche
            c= r.getColor(R.color.LineaN);
            imagen.setColorFilter(ContextCompat.getColor(context, R.color.LineaN));
        }//else if

        return c;
    }// getColor

}
