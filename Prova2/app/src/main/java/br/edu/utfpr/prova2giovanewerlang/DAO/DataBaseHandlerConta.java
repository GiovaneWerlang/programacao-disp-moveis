package br.edu.utfpr.prova2giovanewerlang.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import br.edu.utfpr.prova2giovanewerlang.Entidades.Conta;

public class DataBaseHandlerConta extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gastos";
    private static final String TABLE_NAME = "conta";
    private static final int VERSION = 1;

    public DataBaseHandlerConta(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, data BLOB, descricao TEXT, tipo TEXT, valor REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean incluir(Conta conta){
        SQLiteDatabase banco = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("data", conta.getData().toString());
        registro.put("descricao", conta.getDescricao());
        registro.put("tipo", conta.getTipo().toString());
        registro.put("valor", conta.getValor());

        if(banco.insert(TABLE_NAME, null, registro) != -1){
            return true;
        }

        return false;
    }

    public float totalPagar(){
        SQLiteDatabase banco = this.getReadableDatabase();

        float totalPagar = 0;

        Cursor registros = banco.query(TABLE_NAME, new String[]{"valor"}, "tipo = ?", new String[]{"DEBITO"}, null, null, null);

        while(registros.moveToNext()){
            totalPagar += registros.getFloat(registros.getColumnIndexOrThrow("valor"));
        }

        return totalPagar;
    }

    public float totalReceber(){
        SQLiteDatabase banco = this.getReadableDatabase();

        float totalReceber = 0;

        Cursor registros = banco.query(TABLE_NAME, new String[]{"valor"}, "tipo = ?", new String[]{"CREDITO"}, null, null, null);

        while(registros.moveToNext()){
            totalReceber += registros.getFloat(registros.getColumnIndexOrThrow("valor"));
        }

        return totalReceber;
    }

    public float SaldoFluxo(){
        SQLiteDatabase banco = this.getReadableDatabase();

        float totalPagar = 0;

        Cursor registros = banco.query(TABLE_NAME, new String[]{"valor"}, "tipo = ?", new String[]{"DEBITO"}, null, null, null);

        while(registros.moveToNext()){
            totalPagar += registros.getFloat(registros.getColumnIndexOrThrow("valor"));
        }

        float totalReceber = 0;

        registros = banco.query(TABLE_NAME, new String[]{"valor"}, "tipo = ?", new String[]{"CREDITO"}, null, null, null);

        while(registros.moveToNext()){
            totalReceber += registros.getFloat(registros.getColumnIndexOrThrow("valor"));
        }

        return totalReceber - totalPagar;

    }
}
