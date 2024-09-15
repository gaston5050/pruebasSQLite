package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {


    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="Create table contactos(id integer primary key autoincrement, nombre text, telefono text, correo text);";


        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void abrir(){
        this.getReadableDatabase();
    }

    public void cerrar(){
        this.close();
    }

    public void insertar(String nombre, String telefono, String correo){
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("telefono", telefono);
        valores.put("correo", correo);
        this.getWritableDatabase().insert("contactos",null, valores);
    }
}
