package com.example.diego.listaorganizacaopessoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class VisualizacaoTags extends AppCompatActivity {

    private ListView lstTags;
    private TagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacao_tags);

        lstTags = (ListView) findViewById(R.id.lstTags);
        adapter = new TagAdapter(getBaseContext(), null);

        lstTags.setAdapter(adapter);
        adapter.atualizar();
    }
}
