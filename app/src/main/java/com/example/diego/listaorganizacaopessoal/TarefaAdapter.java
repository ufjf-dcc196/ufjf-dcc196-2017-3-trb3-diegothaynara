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

public class TarefaAdapter extends CursorAdapter {
    private ListaTarefasDbHelper listaTarefasHelper;
    private Context context;

    public TarefaAdapter(Context context, Cursor c) {
        super(context, c, 0);
        listaTarefasHelper = new ListaTarefasDbHelper(context);
        this.context = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.activity_layout_tarefa,viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitulo = (TextView) view.findViewById(R.id.text_titulo);
        TextView txtDescricao = (TextView) view.findViewById(R.id.text_descricao);
        TextView txtDificuldade = (TextView) view.findViewById(R.id.text_grau_dificuldade);
        TextView txtEstado = (TextView) view.findViewById(R.id.text_estado);
        String titulo = cursor.getString(cursor.getColumnIndexOrThrow(ListaTarefasContract.Tarefa.COLUMN_NAME_TITULO));
        String descricao = cursor.getString(cursor.getColumnIndexOrThrow(ListaTarefasContract.Tarefa.COLUMN_NAME_DESCRICAO));
        int grau_dificuldade = cursor.getInt(cursor.getColumnIndexOrThrow(ListaTarefasContract.Tarefa.COLUMN_NAME_DIFICULDADE));
        String estado = cursor.getString(cursor.getColumnIndexOrThrow(ListaTarefasContract.Tarefa.COLUMN_NAME_ESTADO));
        txtTitulo.setText(titulo);
        txtDescricao.setText(descricao);
        txtDificuldade.setText(String.valueOf(grau_dificuldade));
        txtEstado.setText(estado);
    }

    public void atualizar(){
        try {
            SQLiteDatabase db = listaTarefasHelper.getReadableDatabase();
            String[] visao = {
                    ListaTarefasContract.Tarefa._ID,
                    ListaTarefasContract.Tarefa.COLUMN_NAME_TITULO,
                    ListaTarefasContract.Tarefa.COLUMN_NAME_DESCRICAO,
                    ListaTarefasContract.Tarefa.COLUMN_NAME_DIFICULDADE,
                    ListaTarefasContract.Tarefa.COLUMN_NAME_ESTADO,
            };
            String sort = ListaTarefasContract.Tarefa.COLUMN_NAME_ESTADO + " ASC";
            Cursor c = db.query(ListaTarefasContract.Tarefa.TABLE_NAME, visao, null, null, null, null, sort);
            this.changeCursor(c);
        } catch (Exception e) {
            Log.e("LISTA", e.getLocalizedMessage());
            Log.e("LISTA", e.getStackTrace().toString());
        }
    }

    public void inserir(String titulo, String descricao, Integer grau_dificuldade, String estado){
        try {
            SQLiteDatabase db = listaTarefasHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(ListaTarefasContract.Tarefa.COLUMN_NAME_TITULO, titulo);
            values.put(ListaTarefasContract.Tarefa.COLUMN_NAME_DESCRICAO, descricao);
            values.put(ListaTarefasContract.Tarefa.COLUMN_NAME_DIFICULDADE, grau_dificuldade);
            values.put(ListaTarefasContract.Tarefa.COLUMN_NAME_ESTADO, estado);
            long id = db.insert(ListaTarefasContract.Tarefa.TABLE_NAME, null, values);
            if(id != 1) {
                Toast.makeText(this.context, "Tarefa cadastrada com sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this.context, "Erro ao cadastrar tarefa", Toast.LENGTH_SHORT).show();
            }
            atualizar();
        } catch (Exception e) {
            Log.e("LISTA", e.getLocalizedMessage());
            Log.e("LISTA", e.getStackTrace().toString());
        }
    }
}