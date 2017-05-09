package id.pulkat.udinusnews;

/**
 * Created by masyan on 5/8/17.
 *
 * @Author Yanuar Eko Setyanto
 * @Email yanuarekosetyanto@gmail.com
 * @Github https://github.com/MasyanPulkat/
 * @Web http://masyan.web.id
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import id.pulkat.udinusnews.core.home.DetailBerita;
import id.pulkat.udinusnews.helper.Config;
import id.pulkat.udinusnews.helper.Constant;
import id.pulkat.udinusnews.helper.JSONParser;
import id.pulkat.udinusnews.helper.LazyAdapter;

public class MainActivity extends AppCompatActivity {

    JSONParser jsonParser = new JSONParser();
    Config config = new Config();
    ArrayList<HashMap<String, String>> DaftarBerita = new ArrayList<>();
    private ProgressDialog progressDialog;
    JSONArray jsonArray = null;
    ListView ls;
    LazyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), GridViewActivity.class));
//            }
//        });

        ls = (ListView) findViewById(R.id.lvData);
        DaftarBerita = new ArrayList<HashMap<String, String>>();
        new TampilBerita().execute();
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = DaftarBerita.get(position);
                Intent a = new Intent(getApplicationContext(), DetailBerita.class);
                a.putExtra(Constant.TAG_ID, map.get(Constant.TAG_ID));
                startActivity(a);
            }
        });
    }

    private class TampilBerita extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Informasi");
            progressDialog.setMessage("Sedang mengambil data");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            List<NameValuePair> parampa = new ArrayList<>();
            JSONObject jsonObject = jsonParser.makeHttpRequest(config.URL_GET_BERITA, "GET", parampa);
            Log.i("Data Json : ", " " + jsonObject);
            try {
                jsonArray = jsonObject.getJSONArray("berita");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    String id_berita = c.getString(Constant.TAG_ID);
                    String judul = c.getString(Constant.TAG_JUDUL);
                    String gambar = config.BASE_IMG + c.getString(Constant.TAG_GAMBAR);
                    HashMap<String, String> map = new HashMap<>();
                    map.put(Constant.TAG_ID, id_berita);
                    map.put(Constant.TAG_JUDUL, judul);
                    map.put(Constant.TAG_GAMBAR, gambar);
                    DaftarBerita.add(map);
                }
            } catch (JSONException e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    SetListAdapter(DaftarBerita);
                }
            });
        }
    }

    private void SetListAdapter(ArrayList<HashMap<String, String>> daftarBerita) {
        adapter = new LazyAdapter(this, daftarBerita);
        ls.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
