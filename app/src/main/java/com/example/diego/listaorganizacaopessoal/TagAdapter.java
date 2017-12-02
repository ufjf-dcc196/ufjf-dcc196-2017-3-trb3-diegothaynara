package com.example.diego.listaorganizacaopessoal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class TagAdapter extends CursorAdapter {
    private ListaTarefasDbHelper listaTarefasHelper;
    private Context context;

    public TagAdapter(Context context, Cursor c) {
        super(context, c, 0);
        listaTarefasHelper = new ListaTarefasDbHelper(context);
        this.context = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.activity_layout_tag,viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtNome = (TextView) view.findViewById(R.id.text_nome);
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(ListaTarefasContract.Tag.COLUMN_NAME_NOME));
        txtNome.setText(nome);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = listaTarefasHelper.getReadableDatabase();
            String[] visao = {
                    ListaTarefasContract.Tag._ID,
                    ListaTarefasContract.Tag.COLUMN_NAME_NOME,
            };
            Cursor c = db.query(ListaTarefasContract.Tag.TABLE_NAME, visao, null, null, null, null, null);
            this.changeCursor(c);

        } catch (Exception e) {
            Log.e("LISTA", e.getLocalizedMessage());
            Log.e("LISTA", e.getStackTrace().toString());
        }
    }

    public void inserir(String nome){
        try {
            SQLiteDatabase db = listaTarefasHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ListaTarefasContract.Tag.COLUMN_NAME_NOME, nome);
            long id = db.insert(ListaTarefasContract.Tag.TABLE_NAME, null, values);
            if(id != -1) {
                Toast.makeText(this.context, "Tag cadastrada com sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this.context, "Erro ao cadastrar tag", Toast.LENGTH_SHORT).show();
            }
            atualizar();
        } catch (Exception e) {
            Log.e("LISTA", e.getLocalizedMessage());
            Log.e("LISTA", e.getStackTrace().toString());
        }
    }
}