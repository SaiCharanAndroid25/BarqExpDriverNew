package mersattech.barqexpdriver.DemoPackage;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;

import mersattech.barqexpdriver.R;

public class DemoActivity extends TabActivity {

    Button tab1_id, tab2_id, tab3_id, tab4_id, tab5_id, tab6_id;
 //   LinearLayout button_1,button_2,button_3,button_4,button_5,button_1;
    TabHost tabHost;
    ImageView back_icon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);

        // Buttons referencing
        tab1_id = (Button) findViewById(R.id.tab1_id);
        tab2_id = (Button) findViewById(R.id.tab2_id);
        tab3_id = (Button) findViewById(R.id.tab3_id);
        tab4_id = (Button) findViewById(R.id.tab4_id);
        tab5_id = (Button) findViewById(R.id.tab5_id);
        tab6_id = (Button) findViewById(R.id.tab6_id);
        back_icon = (ImageView) findViewById(R.id.back_icon);

        // getting TabHost
        tabHost = getTabHost();

        TabHost.TabSpec photospec = tabHost.newTabSpec("Photos");
        photospec.setIndicator("Photos");
        Intent photosIntent = new Intent(this, Tab1Activity.class);
        photospec.setContent(photosIntent);

        TabHost.TabSpec songspec = tabHost.newTabSpec("Songs");
        songspec.setIndicator("Songs");
        Intent songsIntent = new Intent(this, Tab2Activity.class);
        songspec.setContent(songsIntent);

        TabHost.TabSpec videospec = tabHost.newTabSpec("Videos");
        videospec.setIndicator("Videos");
        Intent videosIntent = new Intent(this, Tab3Activity.class);
        videospec.setContent(videosIntent);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("select4");
        tab4.setIndicator("select4");
        Intent inte = new Intent(this, Tab4Activity.class);
        tab4.setContent(inte);

        TabHost.TabSpec tab5 = tabHost.newTabSpec("select5");
        tab5.setIndicator("select5");
        Intent inte5 = new Intent(this, Tab5Activity.class);
        tab5.setContent(inte5);

        TabHost.TabSpec tab6 = tabHost.newTabSpec("select6");
        tab6.setIndicator("select6");
        Intent inte6 = new Intent(this, Tab6Activity.class);
        tab6.setContent(inte6);

        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab
        tabHost.addTab(tab4); // Adding videos tab
        tabHost.addTab(tab5); // Adding videos tab
        tabHost.addTab(tab6); // Adding videos tab


        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void tabHandler(View target) {
        tab1_id.setSelected(false);
        tab2_id.setSelected(false);
        tab3_id.setSelected(false);
        tab4_id.setSelected(false);
        tab5_id.setSelected(false);
        tab6_id.setSelected(false);
        if (target.getId() == R.id.tab1_id) {
            tabHost.setCurrentTab(0);
            tab1_id.setSelected(true);
        } else if (target.getId() == R.id.tab2_id) {
            tabHost.setCurrentTab(1);
            tab2_id.setSelected(true);
        } else if (target.getId() == R.id.tab3_id) {
            tabHost.setCurrentTab(2);
            tab3_id.setSelected(true);
        }  else if (target.getId() == R.id.tab4_id) {
            tabHost.setCurrentTab(3);
            tab4_id.setSelected(true);
        } else if (target.getId() == R.id.tab5_id) {
            tabHost.setCurrentTab(4);
            tab5_id.setSelected(true);
        } else if (target.getId() == R.id.tab6_id) {
            tabHost.setCurrentTab(5);
            tab6_id.setSelected(true);
        }
    };

}
