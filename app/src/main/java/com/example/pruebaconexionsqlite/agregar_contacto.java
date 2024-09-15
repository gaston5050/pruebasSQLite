package com.example.pruebaconexionsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import OpenHelper.SQLite_OpenHelper;

public class agregar_contacto extends AppCompatActivity {


        EditText txtNom, txtTel, TxtCorr;

        SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD_contactos", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtNom = findViewById(R.id.txtNombre);
        txtTel = findViewById(R.id.txtTelefono);
        TxtCorr = findViewById(R.id.txtCorreo);


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_desplegable, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();


        if(id== R.id.item1){
            Intent intent = new Intent(this, agregar_contacto.class);
            startActivity(intent);
        }
        if(id== R.id.item2){
            Intent intent = new Intent(this, contactos.class);
            startActivity(intent);
        }
        if(id== R.id.item3){

            Toast.makeText(this, "Este es un cartel", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);

    }

    public void grabarContacto(View view){
            helper.insertar(txtNom.getText().toString(), txtTel.getText().toString(), TxtCorr.getText().toString());
            Toast.makeText(this, "Contacto guardado", Toast.LENGTH_LONG).show();


    }
}