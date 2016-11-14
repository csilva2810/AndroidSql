package todoapp.com.example.carlinhos.todoapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static todoapp.com.example.carlinhos.todoapp.database.TodoContract.TodoEntry.SQL_CREATE_ENTRIES;

/**
 * Created by carlinhos on 11/14/16.
 */

public final class TodoContract {

    private TodoContract() {}

    public static class TodoEntry implements BaseColumns {

        public static final String TABLE_NAME = "todos";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESC = "desc";

    }

    public static class TodoDbHelper extends SQLiteOpenHelper {

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Todo.db";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TodoEntry.TABLE_NAME + " (" +
                        TodoEntry._ID + " INTEGER PRIMARY KEY," +
                        TodoEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                        TodoEntry.COLUMN_NAME_DESC + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TodoEntry.TABLE_NAME;

        public TodoDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

    }

}
