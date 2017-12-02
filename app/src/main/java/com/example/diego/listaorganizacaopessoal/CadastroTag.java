package com.example.diego.listaorganizacaopessoal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CadastroTag extends AppCompatActivity {

    private TextView txtNomeTag;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tag);

        txtNomeTag = (TextView) findViewById(R.id.txtNomeTag);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
    }
}
