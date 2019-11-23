package fi.android.projekti.gps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button nappi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nappi = (Button) findViewById(R.id.button);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);


        nappi.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                TextView mTextView = (TextView) findViewById(R.id.Text);
                if (l != null) {
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    String lat2 = String.valueOf(lat);
                    String lon2 = String.valueOf(lon);
                    mTextView.setText("Latitude" + lat2 + "Longtitude" + lon);
                }
            }
        });
    }
}