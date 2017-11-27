package com.air.mover.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.air.mover.R;
import com.air.mover.dao.model.Parada;
import com.air.mover.presenter.DetallesParadaPresenter;

public class DetallesParadaActivity extends AppCompatActivity implements ListEstimacionesAdapter.ItemClickListener
{

    ListEstimacionesAdapter adapterEstimacionesParada;
    DetallesParadaPresenter listEstimacionesParadaPresenter;
    private ProgressDialog dialog;
    private EditText comment;
    private Parada parada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_parada);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        comment = (EditText) (findViewById(R.id.editText));


        ((Button)(findViewById(R.id.button_save_comment))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveComment();
            }
        });


        String nombre = getIntent().getStringExtra("nombre");
        double px = getIntent().getDoubleExtra("posX", -1.0);
        double py = getIntent().getDoubleExtra("posY", -1.0);
        int num = getIntent().getIntExtra("numero", 0);

        parada = new Parada(nombre, px, py, num);

        getSupportActionBar().setTitle(parada.getNombre());


        dialog= new ProgressDialog(this);

        //Crear el recyclerview
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaEstimacionesParada);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterEstimacionesParada = new ListEstimacionesAdapter(this);
        adapterEstimacionesParada.setClickListener(this);
        recyclerView.setAdapter(adapterEstimacionesParada);


        listEstimacionesParadaPresenter = new DetallesParadaPresenter(this, adapterEstimacionesParada, num);
        listEstimacionesParadaPresenter.setListaEstimacionesParadaView(this);
        listEstimacionesParadaPresenter.loadComment(parada.getNumParada(), parada.getNombre());
    }



    @Override
    public void onResume()
    {
        super.onResume();
        this.listEstimacionesParadaPresenter.start();
    }//onResume


    @Override
    public void onItemClick(View view, int position)
    {
        Log.d("Estimacion pulsada =>", ""+position);
    }

    public void showProgress (boolean state)
    {
        if(state)
        {
            dialog.setMessage("Cargando datos");
            dialog.show();
        }//if
        else
        {
            dialog.cancel();
        }//else
    }//showProgress




    /**
     * Actualiza el comentario mostrado en la caja de texto.
     * @param comment texto a mostrar
     */
    public void setComment(String comment) {
        this.comment.setText(comment);
    }

    /**
     * Llama al presenter para guardar el texto que existe en la caja de texto.
     */
    public void saveComment() {
        listEstimacionesParadaPresenter.setComment(parada.getNumParada(), parada.getNombre(), comment.getText().toString());
        Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
    }
}
