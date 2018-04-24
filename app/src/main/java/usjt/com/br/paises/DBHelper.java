package usjt.com.br.paises;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Marcelo Victor da Silva
 * RA: 816119006
 * ADSMCA3
 */

public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    public DBHelper (Context context){
        super(context, "paises.db",null ,1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE pais (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR(200) , " +
                "codigo3 VARCHAR(200) , " +
                "capital VARCHAR(200) , " +
                "regiao VARCHAR(200) , " +
                "subregiao VARCHAR(200) , " +
                "demonimo VARCHAR(200) , " +
                "populacao VARCHAR(200) , " +
                "area VARCHAR(200) , " +
                "bandeira VARCHAR(200) , " +
                "gini VARCHAR(200) , " +
                "idioma VARCHAR(200) , " +
                "moeda VARCHAR(200) , " +
                "dominios VARCHAR(200) , " +
                "fusohorario VARCHAR(200) , " +
                "fronteira VARCHAR(200) , " +
                "latitude VARCHAR(200) , " +
                "longitude VARCHAR(200))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
