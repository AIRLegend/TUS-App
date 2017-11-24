package com.air.mover;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.air.mover.dao.model.Parada;
import com.air.mover.presenter.DetallesParadaPresenter;

public class DetallesParadaActivity extends AppCompatActivity {

    private DetallesParadaPresenter presenter;
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


        presenter = new DetallesParadaPresenter(this, getApplicationContext());
        presenter.loadComment(parada.getNumParada(), parada.getNombre());
    }


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
        presenter.setComment(parada.getNumParada(), parada.getNombre(), comment.getText().toString());
        Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
    }
}
