package mersattech.barqexpdriver.DemoPackage;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v13.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mersattech.barqexpdriver.R;

public class Tab1Activity extends Activity {

    TextView snder_call1,rec_call2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1_view);

        snder_call1 = (TextView) findViewById(R.id.sndr_phn_val_tv);
        rec_call2 = (TextView) findViewById(R.id.conatct_title);

        snder_call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+971 4 2215587"));

                if (ActivityCompat.checkSelfPermission(Tab1Activity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

        rec_call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+971 4 8965555"));

                if (ActivityCompat.checkSelfPermission(Tab1Activity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }

}