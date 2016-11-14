package todoapp.com.example.carlinhos.todoapp.constantes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import todoapp.com.example.carlinhos.todoapp.LoginActivity;

/**
 * Created by carlinhos on 11/12/16.
 */

public class App {

    public static final String SHARED_PREFERENCES = "todo.app";
    public static final String SHARED_KEY_LEMBRAR = "todo.app.LEMBRAR";

    public static SharedPreferences getSharedPreferences(Context context) {

        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

    }

    public static void logout(Context context) {

        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean(SHARED_KEY_LEMBRAR, false);
        editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);

    }

}
