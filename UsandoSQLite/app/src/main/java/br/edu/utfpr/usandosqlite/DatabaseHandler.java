package br.edu.utfpr.usandosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "banco";

    private SQLiteDatabase bd;

    private Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context = context;
        bd = this.getWritableDatabase();

        bd.execSQL("CREATE TABLE IF NOT EXISTS aluno (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade NUMERIC)");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        bd = this.getWritableDatabase();
//
//        bd.execSQL("CREATE TABLE IF NOT EXISTS aluno (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade NUMERIC)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        bd.execSQL("DROP TABLE aluno");
        onCreate(bd);
    }

    public void incluir(Aluno aluno){
        ContentValues registro = new ContentValues();
        registro.put("nome", aluno.getNome());
        registro.put("idade", aluno.getIdade());

        bd.insert("aluno", null, registro);
    }

    public void alterar(Aluno aluno){
        ContentValues registro = new ContentValues();
        registro.put("cod", aluno.getCod());
        registro.put("nome", aluno.getNome());
        registro.put("idade", aluno.getIdade());

        bd.update("aluno", registro, "cod = " + aluno.getCod(), null);
    }

    public void excluir(int cod){
        bd.delete("aluno", "cod = " + cod, null);

    }

    public String pesquisar(int cod){
        Cursor registros = bd.query("aluno", null, "cod=?", new String[]{String.valueOf(cod)}, null, null, null);

        String msg = "";

        if(registros.moveToNext()){
            msg = registros.getString( registros.getColumnIndexOrThrow("nome")) + " - " + registros.getInt( registros.getColumnIndexOrThrow("idade"));

        }else{
            msg = "Registro não Encontrado!";

        }

        return msg;
    }

    public String listar(){
        Cursor registros = bd.query("aluno", null, "cod=?", null, null, null, null);

        String msg = "";

        while(registros.moveToNext()){
            msg = registros.getString( registros.getColumnIndexOrThrow("nome")) + " - " + registros.getInt( registros.getColumnIndexOrThrow("idade"));

        }

        return msg;
    }
}
