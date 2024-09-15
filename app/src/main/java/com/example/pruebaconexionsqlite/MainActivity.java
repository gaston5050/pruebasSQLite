package com.example.pruebaconexionsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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

    public void irContactos(View view){

        Intent intent = new Intent(this, contactos.class);
        startActivity(intent);

    }
}