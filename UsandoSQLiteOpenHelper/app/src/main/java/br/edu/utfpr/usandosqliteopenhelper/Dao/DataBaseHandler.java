package br.edu.utfpr.usandosqliteopenhelper.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import br.edu.utfpr.usandosqliteopenhelper.Entidade.Aluno;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "openBanco";
    private static final String TABLE_NAME = "aluno";
    private static final int VERSION = 1;

    public DataBaseHandler(@Nullable Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void incluir(Aluno aluno){
        SQLiteDatabase banco = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nome", aluno.getNome());
        registro.put("idade", aluno.getIdade());

        banco.insert(TABLE_NAME, null, registro);
    }

    public void alterar(Aluno aluno){
        SQLiteDatabase banco = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nome", aluno.getNome());
        registro.put("idade", aluno.getIdade());

        banco.update(TABLE_NAME, registro, "cod = " + aluno.getCod(),null);
    }

    public void excluir(int cod){
        SQLiteDatabase banco = this.getWritableDatabase();

        banco.delete(TABLE_NAME, "cod = ?", new String[]{String.valueOf(cod)});
    }

    public String pesquisar(int cod){

        SQLiteDatabase banco = this.getWritableDatabase();

        Cursor registros = banco.query("aluno", new String[]{"nome", "idade"}, "cod = " + cod,null,null,null,null);

        String msg = "";

        if(registros.moveToNext()){
            msg = registros.getString(registros.getColumnIndexOrThrow("nome"))
                    + " - " + registros.getInt(registros.getColumnIndexOrThrow("idade"));
        }else{
            msg = "Registro não encontrado.";
        }

        registros.close();


        return msg;
    }

    public String listar(){
        SQLiteDatabase banco = this.getReadableDatabase();

        Cursor registros = banco.query("aluno", new String[]{"nome", "idade"}, null,null,null,null,null);

        String msg = "";

        while(registros.moveToNext()){
            msg = registros.getString(registros.getColumnIndexOrThrow("nome"))
                    + " - " + registros.getInt(registros.getColumnIndexOrThrow("idade")) + "\n";
        }

        registros.close();

        if(msg.equals("")){
            msg = "Nenhum registro encontrado.";
        }

        return msg;

    }
}
