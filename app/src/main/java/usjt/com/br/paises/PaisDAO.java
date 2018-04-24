package usjt.com.br.paises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
/**
 * Marcelo Victor da Silva
 * RA: 816119006
 * ADSMCA3
 */

public class PaisDAO {

    private Context context;
    public PaisDAO (Context context){
        this.context = context;
    }

    public long inserirSimples(Pais pais){

        ContentValues cv = new ContentValues ();
        cv.put("nome", pais.getNome());
        cv.put("bandeira", pais.getBandeira());
        cv.put ("regiao", pais.getRegiao());
        cv.put ("capital", pais.getCapital());
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert("pais", null, cv);
        db.close();
        return id;

    }


    //public long updateDetalhes (Pais pais){
    //    ContentValues cv = new ContentValues ();
    //    cv.put("cidade", previsao.getCidade());
    //    cv.put("min", previsao.getMin());
    //    cv.put ("max", previsao.getMax());
    //    cv.put ("descricao", previsao.getDescricao());
    //    DBHelper dbHelper = new DBHelper(context);
    //    SQLiteDatabase db = dbHelper.getWritableDatabase();
    //    long id = db.insert("previsao", null, cv);
    //    db.close();
    //    return id;
    //}

    public List<Pais> listarPaisesAll(){
        List<Pais> paises = new ArrayList<>();
        try {

            DBHelper helper = new DBHelper(context);
            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor = db.query("pais", null, null, null, null, null, null);

            while (cursor.moveToNext()) {

                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));

                String bandeira = cursor.getString(cursor.getColumnIndexOrThrow("bandeira"));

                String regiao = cursor.getString(cursor.getColumnIndexOrThrow("regiao"));

                String capital = cursor.getString(cursor.getColumnIndexOrThrow("capital"));

                Pais p = new Pais(nome, regiao, bandeira, capital);
                paises.add(p);
            }
            cursor.close();
            db.close();
            helper.close();
            return paises;
        }catch(Exception e){
            return paises;
        }
    }

    public List<Pais> listarPaisesRegiao(String region){
        List<Pais> paises = new ArrayList<>();
        try {

            DBHelper helper = new DBHelper(context);
            SQLiteDatabase db = helper.getReadableDatabase();

            String [] parametros = new String [1];
            parametros[0] = region;

            Cursor cursor = db.query("pais", null, "regiao=?", parametros, null, null, null);

            while (cursor.moveToNext()) {

                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome"));

                String bandeira = cursor.getString(cursor.getColumnIndexOrThrow("bandeira"));

                String regiao = cursor.getString(cursor.getColumnIndexOrThrow("regiao"));

                String capital = cursor.getString(cursor.getColumnIndexOrThrow("capital"));

                Pais p = new Pais(nome, regiao, bandeira, capital);
                paises.add(p);
            }
            cursor.close();
            db.close();
            helper.close();
            return paises;
        }catch(Exception e){
            return paises;
        }
    }
}
