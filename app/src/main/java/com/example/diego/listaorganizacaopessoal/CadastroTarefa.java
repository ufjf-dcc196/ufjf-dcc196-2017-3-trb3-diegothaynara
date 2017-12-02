package com.example.diego.listaorganizacaopessoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroTarefa extends AppCompatActivity {

    private TextView txtTituloTarefa;
    private TextView txtDescricaoTarefa;
    private Button btnCadastrar;
    private Spinner spinnerGrauDificuldadeTarefa;
    private Spinner spinnerEstadoTarefa;
    ArrayList<String> spinnerGrauDificuldadeTarefaArray = new ArrayList<String>();
    ArrayList<String> spinnerEstadoTarefaArray = new ArrayList<String>();
    private TarefaAdapter tarefaAdapter;


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
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        spinnerGrauDificuldadeTarefa = (Spinner) findViewById(R.id.spinnerGrauDificuldadeTarefa);
        spinnerEstadoTarefa = (Spinner) findViewById(R.id.spinnerEstadoTarefa);
        tarefaAdapter = new TarefaAdapter(getBaseContext(), null);

        // Foco no primeiro campo a ser digitado
        txtTituloTarefa.requestFocus();

        popularSpinnerGrauDificuldadeTarefa();
        popularSpinnerEstadoTarefa();

        // Adaptador do spinner do grau de dificuldade
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerGrauDificuldadeTarefaArray
        );

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems1 = (Spinner) findViewById(R.id.spinnerGrauDificuldadeTarefa);
        sItems1.setAdapter(adapter1);

        // Adaptador do spinner de estado
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerEstadoTarefaArray
        );

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner sItems2 = (Spinner) findViewById(R.id.spinnerEstadoTarefa);
        sItems2.setAdapter(adapter2);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = txtTituloTarefa.getText().toString();
                String descricao = txtDescricaoTarefa.getText().toString();
                Integer grauDificuldade = Integer.parseInt(sItems1.getSelectedItem().toString());
                String estado = sItems2.getSelectedItem().toString();

                // Checa se nenhum dos dois campos está vazio
                if(titulo.trim().equals("") || descricao.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Dado(s) inválido(s)", Toast.LENGTH_SHORT).show();
                    return;
                }

                tarefaAdapter.inserir(titulo, descricao, grauDificuldade, estado);

                Intent intent = new Intent (CadastroTarefa.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
