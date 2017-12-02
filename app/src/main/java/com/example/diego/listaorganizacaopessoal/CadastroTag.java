package com.example.diego.listaorganizacaopessoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroTag extends AppCompatActivity {

    private TextView txtNomeTag;
    private Button btnCadastrar;
    private TagAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tag);

        txtNomeTag = (TextView) findViewById(R.id.txtNomeTag);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        adapter = new TagAdapter(getBaseContext(), null);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = txtNomeTag.getText().toString();

                // Checa se campo não está vazio
                if(nome.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Dado(s) inválido(s)", Toast.LENGTH_SHORT).show();
                    return;
                }

                adapter.inserir(nome);

                Intent intent = new Intent (CadastroTag.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
