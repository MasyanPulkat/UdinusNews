package id.pulkat.udinusnews.core.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.pulkat.udinusnews.helper.Config;
import id.pulkat.udinusnews.helper.Constant;
import id.pulkat.udinusnews.helper.ImageLoader;
import id.pulkat.udinusnews.helper.JSONParser;
import id.pulkat.udinusnews.R;

public class DetailBerita extends AppCompatActivity {

    public ImageLoader imageLoader;{
        imageLoader = new ImageLoader(null);
    }
    String id;
    JSONParser jsonParser = new JSONParser();
    Config config = new Config();
    private ProgressDialog progressDialog;
    JSONArray jsonArray = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent a = getIntent();
        id = a.getStringExtra(Constant.TAG_ID);
        new TampilDetailBerita().execute();
    }

    private class TampilDetailBerita extends AsyncTask<String,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog= new ProgressDialog(DetailBerita.this);
            progressDialog.setTitle("Informasi");
            progressDialog.setMessage("Sedang mengambil data");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(String... params) {
            try{
                List<NameValuePair> parampa = new ArrayList<>();
                parampa.add(new BasicNameValuePair("id_berita", id));
                JSONObject jsonObject = jsonParser.makeHttpRequest(config.URL_GET_BERITA_DETAIL, "GET", parampa);
                jsonArray = jsonObject.getJSONArray("berita");
                Log.i("Data Json : ", "" + jsonObject);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView jdl = (TextView)findViewById(R.id.txtDetailJudul);
                        ImageView img = (ImageView)findViewById(R.id.ivDetailgambar);
                        WebView isi = (WebView)findViewById(R.id.wvContent);
                        String htmlText = "<html><body style=\"text-align:justify\"> %s </body></Html>";
                        try{
                            JSONObject job = jsonArray.getJSONObject(0);
                            String judul_berita =job.getString("judul");
                            String isi_berita =job.getString("isi");
                            jdl.setText(judul_berita);
                            isi.loadData(String.format(htmlText, isi_berita), "text/html","utf-8");
                            imageLoader.DisplayImage(config.BASE_IMG+job.getString(Constant.TAG_GAMBAR), img);
                        }catch (JSONException e){

                        }
                    }
                });
            }catch (JSONException e){

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
        }
    }
}

