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

/**
 * Activity correspondiente a los detalles de una parada. Aqui se muestra el nombre de la parada,
 * las estimaciones de los próximos autobuses y un campo para editar las notas de la parada.
 */
public class DetallesParadaActivity extends AppCompatActivity implements ListEstimacionesAdapter.ItemClickListener
{

    private ListEstimacionesAdapter adapterEstimacionesParada;
    private DetallesParadaPresenter listEstimacionesParadaPresenter;
    private ProgressDialog dialog;
    private EditText comment;
    private Parada parada;

    /**
     * Metodo que se ejecuta cuando se crea la activity. Se encarga
     * de asociar la activity con su vista asi como de la gestion de esta
     *
     * @param savedInstanceState estado mas reciente de la activity
     */
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


    /**
     * Metodo que se ejecuta cuando se rescata una actividad de memoria (al volver a la app,
     * de otra activity...)
     */
    @Override
    public void onResume()
    {
        super.onResume();
        this.listEstimacionesParadaPresenter.start();
    }//onResume


    /**
     * Metodo que recoge el evento de click en un elemento de la lista.
     * De momento pulsar estimaciones no hace nada.
     * @param view View pulsada
     * @param position Posicion de la lista pulsada
     */
    @Override
    public void onItemClick(View view, int position)
    {
        Log.d("Estimacion pulsada =>", ""+position);
    }

    /**
     * Metodo que muestra un cuadro de carga si se llama con "true".
     * @param state true => muestra el cuadro, false => no lo muestra.
     */
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
