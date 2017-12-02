package com.example.diego.listaorganizacaopessoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class CadastroTarefa extends AppCompatActivity {

    private TextView txtTituloTarefa;
    private TextView txtDescricaoTarefa;
    private Spinner spinnerGrauDificuldadeTarefa;
    private Spinner spinnerEstadoTarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefa);

        txtTituloTarefa = (TextView) findViewById(R.id.txtTituloTarefa);
        txtDescricaoTarefa = (TextView) findViewById(R.id.txtDescricaoTarefa);
        spinnerGrauDificuldadeTarefa = (Spinner) findViewById(R.id.spinnerGrauDificuldadeTarefa);
        spinnerEstadoTarefa = (Spinner) findViewById(R.id.spinnerEstadoTarefa);

        // Foco no primeiro campo a ser digitado
        txtTituloTarefa.requestFocus();
    }


}
