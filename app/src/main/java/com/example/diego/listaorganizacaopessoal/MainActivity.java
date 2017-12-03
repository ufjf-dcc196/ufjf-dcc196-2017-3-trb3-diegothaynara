package com.example.diego.listaorganizacaopessoal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrarTarefa;
    private Button btnCadastrarTag;
    private Button btnVisualizarTags;
    private ListView lstTarefas;
    private TarefaAdapter adapter;
    private ListaTarefasDbHelper listaTarefasDbHelper;
    private ArrayList<Long> ids = new ArrayList<Long>();
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarTarefa = (Button) findViewById(R.id.btnCadastrarTarefa);
        btnCadastrarTag = (Button) findViewById(R.id.btnCadastrarTag);
        btnVisualizarTags = (Button) findViewById(R.id.btnVisualizarTags);
        lstTarefas = (ListView) findViewById(R.id.lstTarefas);
        adapter = new TarefaAdapter(getBaseContext(), null);
        listaTarefasDbHelper = new ListaTarefasDbHelper(getApplicationContext());
        db = listaTarefasDbHelper.getReadableDatabase();


        lstTarefas.setAdapter(adapter);
        adapter.atualizar();

        lstTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                db.execSQL("DELETE FROM " + ListaTarefasContract.Tarefa.TABLE_NAME + " WHERE _ID = " + adapter.getItemId(i));
                adapter.atualizar();
                return true;
            }
        });

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

        // Evento para mudar de activity ao clicar no botão de visualizar tags
        btnVisualizarTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, VisualizacaoTags.class);
                startActivity(intent);
            }
        });


    }
}
