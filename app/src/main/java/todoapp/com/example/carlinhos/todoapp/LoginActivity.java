package todoapp.com.example.carlinhos.todoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import todoapp.com.example.carlinhos.todoapp.constantes.App;

public class LoginActivity extends Activity {

    TextInputLayout tilUser;
    TextInputLayout tilPassword;
    SwitchCompat swLembrar;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        swLembrar = (SwitchCompat) findViewById(R.id.swLembrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        if (mustRemember()) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }

    public void attemptLogin(View v) {

        String userName = tilUser.getEditText().getText().toString();
        String password = tilPassword.getEditText().getText().toString();
        boolean lembrar = swLembrar.isChecked();

        if (userName.equals("admin") && password.equals("12345")) {

            tilUser.setError("");
            tilPassword.setError("");

            SharedPreferences prefs = App.getSharedPreferences(this);

            SharedPreferences.Editor editor = prefs.edit();

            editor.putBoolean(App.SHARED_KEY_LEMBRAR, lembrar);
            editor.commit();

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        } else {

            tilPassword.setError("Usuário ou Senhas Inválidos");

        }

    }

    public boolean mustRemember() {

        return App.getSharedPreferences(this).getBoolean(App.SHARED_KEY_LEMBRAR, false);

    }

}
