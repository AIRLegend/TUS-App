package com.air.mover.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.air.mover.dao.model.Linea;
import com.air.mover.R;
import java.util.List;

/**
 *  Esta clase define la vista para cada linea en el conjunto de
 *  lineas de los TUS de Santander
 *
 *  @version 29/10/17
 */
public class ListLineasAdapter extends ArrayAdapter
{
    List<Linea> lineasBus; //Lista que contiene las lineas de buses de Santander
    Context context; //Estado actual de la aplicacion

    /**
     * Metodo constructor que se encarga de inicializar los atributos e invocar al constructor
     * de la clase padre que extiende
     *
     * @param context
     * @param lineasBus
     */
    public ListLineasAdapter (Context context, List<Linea> lineasBus)
    {
        super(context, R.layout.custom_list_lineas_layout,lineasBus);
        this.context = context;
        this.lineasBus = lineasBus;
    }// ListLineasAdapter


    /**
     * Metodo que permite generar la vista de la lista de lineas de autobus.
     * Este metodo es llamado cada vez que se dibuja un elemento en la lista
     *
     * @param position posicion de la linea en la lista
     * @param convertView permite el reciclaje de la vista
     * @param parent vista que contiene la vista del elemento que este metodo genera.
     * @return view para la fila
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.custom_list_lineas_layout,null,true);


        //Enlazamos la interfaz de usuario a variables para poder manejarla
        TextView textViewName = (TextView) viewRow.findViewById(R.id.textViewName);
        TextView textViewNumero = (TextView) viewRow.findViewById(R.id.textViewNumero);

        //Escribimos el nombre de la linea del TUS
        textViewName.setText(lineasBus.get(position).getName().trim());


        //Modificacion del color del numero de la linea del TUS
        String numLinea=lineasBus.get(position).getNumero().trim();
        SpannableStringBuilder builder= new SpannableStringBuilder();
        SpannableString s1;
        s1= new SpannableString(numLinea);

        ImageView ima= (ImageView) viewRow.findViewById(R.id.imageViewBus);
        int color= getLineaColor(numLinea, ima);

        s1.setSpan(new ForegroundColorSpan(color),0,s1.length() ,0);
        builder.append(s1);

        //Escribimos el numero de la linea del TUS
        textViewNumero.setText(builder);

        return viewRow;
    }//getView

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



}// ListLineasAdapter
