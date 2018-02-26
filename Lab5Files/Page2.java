package com.example.flavin.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity{

    TextView title;
    TextView description;
    ImageView picture;
    String time;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picturepage);

        Bundle b = getIntent().getExtras();
        time = b.getString("howlong");

        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.desc);
        picture = (ImageView) findViewById(R.id.pic);

        myHandler.postDelayed(myRunnable, 0);
    }

    private Handler myHandler = new Handler();
    String a[] = {"Beagle", "Border Collie", "Dachshund", "Great Dane", "Siberian Husky", "Labrador Retriever",
    "Shetland Sheepdog", "Pug", "German Shepard", "Shiba Inu"};
    String b[] = {"Small Hound", "Header Dog", "Chases Scents", "Huge Dog", "Snow Dog", "Aids the blind", "Big and Fluffy",
            "Short Faced", "Police Dogs", "Dancing Dog"};
    int c[] = {R.drawable.beagle, R.drawable.collie, R.drawable.dachshund, R.drawable.dane, R.drawable.husky, R.drawable.lab,
            R.drawable.nella, R.drawable.pug, R.drawable.shepard, R.drawable.shiba};
    int n;

    private Runnable myRunnable = new Runnable() {
        public void run() {
            if (n+1 > a.length) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                myHandler.removeCallbacks(myRunnable);
            }
            else {
                int t = Integer.parseInt(time) * 1000;

                Toast.makeText(Page2.this, "Index -> " + (n+1) + "",
                        Toast.LENGTH_SHORT).show();

                title.setText(a[n]);
                description.setText(b[n]);
                picture.setImageResource(c[n]);

                n++;
                myHandler.postDelayed(this, t);
            }
        }
    };
}


