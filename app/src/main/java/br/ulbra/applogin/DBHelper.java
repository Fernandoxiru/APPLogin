package br.ulbra.applogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BancoDados.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_UTILIZADOR = "utilizador";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_UTILIZADOR + " (" +
                COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTILIZADOR);
        onCreate(db);
    }

    public long criarUtilizador(String userName, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERNAME, userName);
        cv.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_UTILIZADOR, null, cv);
        db.close();
        return result;
    }

    public String validarLogin(String userName, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT * FROM " + TABLE_UTILIZADOR + " WHERE " +
                        COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?",
                new String[] {userName, password}
        );

        String result = (c.getCount() > 0) ? "OK" : "ERRO";
        c.close();
        db.close();

        return result;
    }
}

