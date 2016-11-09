package com.ocean.aluno.todoapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ocean.aluno.todoapp.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 08/11/2016.
 */
public class ToDoDAO {

    private ToDoSqLiteHelper dbHelper;

    public ToDoDAO(Context context) {

        dbHelper = new ToDoSqLiteHelper(context);

    }

    public void criar(Todo todo) {

        ContentValues valores = new ContentValues();
        valores.put("descricao", todo.getDescricao());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("todos", null, valores);
        db.close();

    }

    public List<Todo> listarTodos() {

        List<Todo> todos = new ArrayList<>();

        //Nome das colunas que iremos selecionar
        String[] colunas = new String[] {"_id", "descricao"};

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("todos", colunas, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Todo todo = new Todo();
            todo.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            todo.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));

            todos.add(todo);

            cursor.moveToNext();

        }

        db.close();

        return todos;

    }

}
