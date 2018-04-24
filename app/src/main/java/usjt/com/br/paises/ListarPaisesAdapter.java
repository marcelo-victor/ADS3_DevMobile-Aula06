package usjt.com.br.paises;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static android.content.ContentValues.TAG;
/**
 * Marcelo Victor da Silva
 * RA: 816119006
 * ADSMCA3
 */

public class ListarPaisesAdapter<T> extends BaseAdapter {

    private List<T> paises;
    private Activity context;

    public ListarPaisesAdapter(Activity context, List<T> paises) {
        super();
        this.paises = paises;
        this.context = context;
    }


    @Override
    public int getCount() {
        return this.paises.size();
    }

    @Override
    public T getItem(int i) {

        return this.paises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view;
        T pais = getItem(i);

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_listar_paises, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.nome.setText(((Pais) pais).getNome());
        viewHolder.capital.setText("Capital: " + ((Pais) pais).getCapital());
        viewHolder.regiao.setText("Região: " + ((Pais) pais).getRegiao());
        viewHolder.bandeira.setImageBitmap(((Pais) pais).getBandeiraBitMap());


        return view;
    }

    private class ViewHolder {
        final ImageView bandeira;
        final TextView nome;
        final TextView capital;
        final TextView regiao;


        public ViewHolder(View view) {
            bandeira = view.findViewById(R.id.bandeiraImageView);
            nome = view.findViewById(R.id.nomeTextView);
            capital = view.findViewById(R.id.regiaoTextView);
            regiao = view.findViewById(R.id.capitalTextView);
        }
    }

    private class DownloadFilesTask extends AsyncTask<String , Void, Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... url) {
            try {
                URL aURL = new URL(url[0]);
                URLConnection conn = aURL.openConnection();
                conn.connect();
                InputStream is = conn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                Bitmap bm = BitmapFactory.decodeStream(bis);
                bis.close();
                is.close();
                return bm;
            } catch (IOException e) {
                Log.e(TAG, "Error getting bitmap", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap result) {

        }
    }
}
