package com.air.mover.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.air.mover.R;
import com.air.mover.dao.Model.Parada;

import java.util.Collections;
import java.util.List;

/**
 * Created by air on 7/11/17.
 */

public class ListParadasLineaAdapter extends RecyclerView.Adapter<ListParadasLineaAdapter.ViewHolder> {

    private List<Parada> mData = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public ListParadasLineaAdapter(Context context, List<Parada> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }//ListParadasLineaAdapter

    /**
     * Crear viewholder (ver abajo lo que es)
     * @param parent Vista en la que se encontrara el ViewHolder
     * @param viewType tipo de la vista
     * @return viewholder creado
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_list_paradas_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }//onCreateViewHolder

    /**
     * Ligar un ViewHolder (ver abajo lo que es) a una posicion
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewNombre.setText(mData.get(position).getNombre());
        holder.textViewNumero.setText(""+mData.get(position).getNumParada()); //Forzar la conversion a String.
    }//onBindViewHolder

    /**
     * Retorna el numero de elementos de la lista.
     * @return El numero de elementos en la lista.
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<Parada> paradas)
    {
        this.mData = paradas;
        notifyDataSetChanged();
    }

    /**
     * Este metodo no es necesario, pero sirve para poder coger los elementos de la lista
     * si se requiere.
     * @param id Posicion del elemento en la lista
     * @return Parada que corresponde al elemento en la lista
     */
    public Parada getItem(int id) {
        return mData.get(id);
    }

    /**
     * Este metodo sirve para capturar los clics.
     * @param itemClickListener Listener para los clics.
     */
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }//setClickListener


    /**
     * Esta clase almacena los "items" de la lista (vistas) cuando salen de la pantalla.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewNumero;
        public TextView textViewNombre;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNumero = (TextView) itemView.findViewById(R.id.txtNumParada);
            textViewNombre = (TextView) itemView.findViewById(R.id.txtParadaName);
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



}
