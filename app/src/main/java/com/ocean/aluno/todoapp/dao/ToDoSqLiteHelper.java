package com.ocean.aluno.todoapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aluno on 08/11/2016.
 */
public class ToDoSqLiteHelper extends SQLiteOpenHelper {

    public ToDoSqLiteHelper(Context context) {
        super(context, "todo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE todos (_id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT NOT NULL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
