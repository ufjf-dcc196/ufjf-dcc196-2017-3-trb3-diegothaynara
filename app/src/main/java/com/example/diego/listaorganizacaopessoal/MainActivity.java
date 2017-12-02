package com.example.diego.listaorganizacaopessoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarTarefa;
    private Button btnCadastrarTag;
    private Button btnVisualizarTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarTarefa = (Button) findViewById(R.id.btnCadastrarTarefa);
        btnCadastrarTag = (Button) findViewById(R.id.btnCadastrarTag);
        btnVisualizarTags = (Button) findViewById(R.id.btnVisualizarTags);


        // Evento para mudar de activity ao clicar no botão de cadastro de tarefa
        btnCadastrarTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, CadastroTarefa.class);
                startActivity(intent);
            }
        });

        // Evento para mudar de activity ao clicar no botão de cadastro de tag
        btnCadastrarTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, CadastroTag.class);
                startActivity(intent);
            }
        });
    }
}
