package neveen.samih.samihtasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SpalshScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        //Thread: 1
        Thread th=new Thread(){
            //Thread: 2
            @Override
            public void run() {
                //هنا المقطع الذي سيعمل بالتزامن مع مقاطع اخرى
                //Thread:3
                int ms=3*1000;//milliseconds
                try {
                    sleep(ms);
                    startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //Thread: 4
        th.start();


    }
}