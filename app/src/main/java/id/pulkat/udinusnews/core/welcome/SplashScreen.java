package id.pulkat.udinusnews.core.welcome;

/**
 * Created by masyan on 5/8/17.
 *
 * @Author Yanuar Eko Setyanto
 * @Email yanuarekosetyanto@gmail.com
 * @Github https://github.com/MasyanPulkat/
 * @Web http://masyan.web.id
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.pulkat.udinusnews.MainActivity;
import id.pulkat.udinusnews.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Splashscreen
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent a = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(a);
                finish();
            }
        },5000L);
    }
}
