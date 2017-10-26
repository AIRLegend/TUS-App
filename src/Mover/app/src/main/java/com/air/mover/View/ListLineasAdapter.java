package com.air.mover.View;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.air.mover.DAO.Model.Linea;
import com.air.mover.R;

import java.util.List;

/**
 * Created by alejandro on 10/08/17.
 * //http://www.viralandroid.com/2016/04/custom-android-listview-example.html
 */

public class ListLineasAdapter extends ArrayAdapter {
    List<Linea> lineasBus;
    Context context;

    public ListLineasAdapter (Context context, List<Linea> lineasBus){
        super(context, R.layout.custom_list_lineas_layout,lineasBus);
        this.context = context;
        this.lineasBus = lineasBus;
    }// ListLineasAdapter




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.custom_list_lineas_layout,null,true);
        TextView textViewName = (TextView) viewRow.findViewById(R.id.textViewName);
        TextView textViewNumero = (TextView) viewRow.findViewById(R.id.textViewNumero);
        textViewName.setText(lineasBus.get(position).getName().trim());

        String numLinea=lineasBus.get(position).getNumero().trim();
        String numAlineado="";
        if(numLinea.length()==1)
        {
            numAlineado= numLinea+"      ";
        }
        else if(numLinea.length()==2)
        {
            numAlineado= numLinea+"    ";
        }
        else
        {
            numAlineado= numLinea+"  ";
        }

        SpannableStringBuilder builder= new SpannableStringBuilder();
        SpannableString s1;
        s1= new SpannableString(numAlineado);
        int color= getColor(numLinea);
        s1.setSpan(new ForegroundColorSpan(color),0,s1.length() ,0);
        builder.append(s1);
        textViewNumero.setText(builder);

        return viewRow;
    }

    public int getColor(String s)
    {
        int c=Color.BLACK;

        if(s.equals("1"))
        {
            c= Color.rgb(244,67,54);
        }
        else if(s.equals("2"))
        {
            c= Color.rgb(171,71,188);
        }
        else if(s.equals("3"))
        {
            c= Color.rgb(255,213,79);
        }
        else if(s.equals("4"))
        {
            c= Color.rgb(0,188,212);
        }
        else if(s.startsWith("5"))
        {
            c= Color.rgb(158,158,158);
        }
        else if(s.startsWith("6"))
        {
            c= Color.rgb(46,125,50);
        }
        else if(s.startsWith("7"))
        {
            c= Color.rgb(255,111,0);
        }
        else if(s.equals("11"))
        {
            c= Color.rgb(26,35,126);
        }
        else if(s.equals("12"))
        {
            c= Color.rgb(174,213,129);
        }
        else if(s.equals("13"))
        {
            c= Color.rgb(179, 157, 219);
        }
        else if(s.equals("14"))
        {
            c= Color.rgb(21, 101, 192);
        }
        else if(s.equals("16"))
        {
            c= Color.rgb(136, 14, 79);
        }
        else if(s.startsWith("17"))
        {
            c= Color.rgb(239, 154, 154);
        }
        else if(s.startsWith("18"))
        {
            c= Color.rgb(163, 228, 215);
        }
        else if(s.equals("19"))
        {
            c= Color.rgb(0, 131, 143);
        }
        else if(s.equals("20"))
        {
            c= Color.rgb(102, 255, 51);
        }
        else if(s.equals("21"))
        {
            c= Color.rgb(156, 204, 101);
        }
        else if(s.equals("23"))
        {
            c= Color.rgb(207, 216, 220);
        }
        else if(s.startsWith("N"))
        {
            c= Color.BLACK;
        }

        return c;

    }// getColor


}// ListLineasAdapter
