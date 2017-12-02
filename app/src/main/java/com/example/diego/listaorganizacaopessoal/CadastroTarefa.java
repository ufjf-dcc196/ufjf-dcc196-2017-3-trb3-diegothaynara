package com.example.diego.listaorganizacaopessoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CadastroTarefa extends AppCompatActivity {

    private TextView txtTituloTarefa;
    private TextView txtDescricaoTarefa;
    private Spinner spinnerGrauDificuldadeTarefa;
    private Spinner spinnerEstadoTarefa;
    ArrayList<String> spinnerGrauDificuldadeTarefaArray = new ArrayList<String>();
    ArrayList<String> spinnerEstadoTarefaArray = new ArrayList<String>();


    private void popularSpinnerGrauDificuldadeTarefa() {
        for(int i = 1; i <= 5; i++) {
            spinnerGrauDificuldadeTarefaArray.add(String.valueOf(i));
        }
    }

    private void popularSpinnerEstadoTarefa() {
        spinnerEstadoTarefaArray.add("A fazer");
        spinnerEstadoTarefaArray.add("Em execução");
        spinnerEstadoTarefaArray.add("Bloqueada");
        spinnerEstadoTarefaArray.add("Concluida");
    }


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

        popularSpinnerGrauDificuldadeTarefa();
        popularSpinnerEstadoTarefa();

        // Adaptador do spinner do grau de dificuldade
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerGrauDificuldadeTarefaArray
        );

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems1 = (Spinner) findViewById(R.id.spinnerGrauDificuldadeTarefa);
        sItems1.setAdapter(adapter1);

        // Adaptador do spinner de estado
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerEstadoTarefaArray
        );

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems2 = (Spinner) findViewById(R.id.spinnerEstadoTarefa);
        sItems2.setAdapter(adapter2);







    }


}
