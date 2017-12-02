package com.example.diego.listaorganizacaopessoal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ListaTarefasDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ListaTarefas.db";

    public ListaTarefasDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ListaTarefasContract.SQL_CREATE_TAREFA);
        sqLiteDatabase.execSQL(ListaTarefasContract.SQL_CREATE_TAG);
        sqLiteDatabase.execSQL(ListaTarefasContract.SQL_CREATE_TAREFA_TAG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(ListaTarefasContract.SQL_DROP_TAREFA);
        sqLiteDatabase.execSQL(ListaTarefasContract.SQL_DROP_TAG);
        sqLiteDatabase.execSQL(ListaTarefasContract.SQL_DROP_TAREFA_TAG);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion,newVersion);
    }
}
