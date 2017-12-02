package com.example.diego.listaorganizacaopessoal;

import android.provider.BaseColumns;

public class ListaTarefasContract {
    public static final String TEXT_TYPE = " TEXT";
    public static final String INT_TYPE = " INTEGER";
    public static final String SEP = ",";
    public static final String SQL_CREATE_TAREFA = "CREATE TABLE " + Tarefa.TABLE_NAME + " (" +
            Tarefa._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Tarefa.COLUMN_NAME_TITULO + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_DESCRICAO + TEXT_TYPE + SEP +
            Tarefa.COLUMN_NAME_DIFICULDADE + INT_TYPE + SEP +
            Tarefa.COLUMN_NAME_ESTADO + TEXT_TYPE +")";
    public static final String SQL_DROP_TAREFA = "DROP TABLE IF EXISTS " + Tarefa.TABLE_NAME;

    public static final String SQL_CREATE_TAG = "CREATE TABLE " + Tag.TABLE_NAME + " (" +
            Tag._ID + INT_TYPE +" PRIMARY KEY AUTOINCREMENT" + SEP +
            Tag.COLUMN_NAME_NOME + TEXT_TYPE +")";
    public static final String SQL_DROP_TAG = "DROP TABLE IF EXISTS " + Tag.TABLE_NAME;

    public static final String SQL_CREATE_TAREFA_TAG = "CREATE TABLE " + TarefaTag.TABLE_NAME + " (" +
            TarefaTag.COLUMN_NAME_TAREFA + INT_TYPE + SEP +
            TarefaTag.COLUMN_NAME_TAG + TEXT_TYPE + SEP +
            "FOREIGN KEY ("+ TarefaTag.COLUMN_NAME_TAREFA +") REFERENCES tarefa(_ID)" + SEP +
            "FOREIGN KEY ("+ TarefaTag.COLUMN_NAME_TAG +") REFERENCES tag(_ID)" + ")";
    public static final String SQL_DROP_TAREFA_TAG = "DROP TABLE IF EXISTS " + TarefaTag.TABLE_NAME;

    public ListaTarefasContract() {
    }

    public static final class Tarefa implements BaseColumns {
        public static final String TABLE_NAME = "tarefa";
        public static final String COLUMN_NAME_TITULO = "titulo";
        public static final String COLUMN_NAME_DESCRICAO = "autor";
        public static final String COLUMN_NAME_DIFICULDADE = "grau_dificuldade";
        public static final String COLUMN_NAME_ESTADO = "estado";
    }

    public static final class Tag implements BaseColumns {
        public static final String TABLE_NAME = "tag";
        public static final String COLUMN_NAME_NOME = "nome";
    }

    public static final class TarefaTag implements BaseColumns {
        public static final String TABLE_NAME = "tarefa_tag";
        public static final String COLUMN_NAME_TAREFA = "tarefa_id";
        public static final String COLUMN_NAME_TAG = "tag_id";
    }
}
