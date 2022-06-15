package edu.val.primeravez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 obtener fichero (se crea si no existe)
        SharedPreferences ficheroPreferencias = getSharedPreferences("prefs", MODE_PRIVATE);
        //si no existe, me lo crea
        //2 leer fichero
        int nveces = ficheroPreferencias.getInt("numero_veces", 0);
        if (nveces==0)
        {
            Log.d("ETIQUETA_LOG", "Primera vez");
            Intent intent_ayuda = new Intent(this, AyudaActivity.class);
            startActivity(intent_ayuda);

        } else {
            Log.d("ETIQUETA_LOG", "NO es la Primera vez");
        }
        nveces = nveces + 1;
        //actualizo en el fichero
        //3 escribir fichero
        SharedPreferences.Editor editor = ficheroPreferencias.edit();
        editor.putInt("numero_veces", nveces);
        editor.commit();//confirmo los cambios, guardo, los hago efectivos
        /**
         * TODO
         * usando las SharedPreferences,
         * haced que el juego de Palabrick
         * "recuerde" si el usuario le dio a
         * saltar el video de la actividad inicial
         * y no vuelva a mostrarlo si marcó esa opción
         *
         * avisad si tenéis dudas o cualquier cosa
         * os dejo hasta y media para corregirlo
         *
         *
         */
    }
}