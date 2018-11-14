package mersattech.barqexpdriver.HomePackage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import co.ceryle.segmentedbutton.SegmentedButtonGroup;
import mersattech.barqexpdriver.Activities.BaseActivity;
import mersattech.barqexpdriver.Activities.History.HistoryActivity;
import mersattech.barqexpdriver.Activities.HomeActivity;
import mersattech.barqexpdriver.DemoPackage.DemoActivity;
import mersattech.barqexpdriver.NetworkUtils.NetworkUtils;
import mersattech.barqexpdriver.R;
import mersattech.barqexpdriver.Utils.AppPreferences;
import mersattech.barqexpdriver.databinding.ToolbarLayoutBinding;

public class HomePageOneActivity extends AppCompatActivity {

    LinearLayout linear_view_layout_1,linear_view_layout_4,linear_view_layout_5;
    Toolbar toolbar;
    TextView toolbar_title;
    ImageView back_icon;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.home_main);

        SegmentedButtonGroup sbg = (SegmentedButtonGroup) findViewById(R.id.segmentedButtonGroup);
        linear_view_layout_1 = (LinearLayout) findViewById(R.id.linear_view_layout_1);
        linear_view_layout_4 = (LinearLayout) findViewById(R.id.linear_view_layout_4);
        linear_view_layout_5 = (LinearLayout) findViewById(R.id.linear_view_layout_5);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        back_icon = (ImageView) findViewById(R.id.back_icon);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        setToolbar(toolbar, getString(R.string.current_order_title_text), true);

        sbg.setOnClickedButtonListener(new SegmentedButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(int position) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "CheckOut", Toast.LENGTH_LONG).show();
                    linear_view_layout_1.setVisibility(View.VISIBLE);
                    linear_view_layout_4.setVisibility(View.GONE);
                    linear_view_layout_5.setVisibility(View.GONE);
                    checkoutapiCall();
                } else  if (position == 1) {
                    Toast.makeText(getApplicationContext(), "Orders", Toast.LENGTH_LONG).show();
                    linear_view_layout_1.setVisibility(View.GONE);
                    linear_view_layout_4.setVisibility(View.VISIBLE);
                    linear_view_layout_5.setVisibility(View.GONE);
                } else  if (position == 2) {
                    Toast.makeText(getApplicationContext(), "COD", Toast.LENGTH_LONG).show();
                    linear_view_layout_1.setVisibility(View.GONE);
                    linear_view_layout_4.setVisibility(View.GONE);
                    linear_view_layout_5.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void setToolbar(Toolbar toolbar, String toolbarTitle, boolean b) {
            toolbar_title.setText(toolbarTitle);
            back_icon.setVisibility(View.VISIBLE);
    }


    private void checkoutapiCall() {

        if (NetworkUtils.getInstance().isNetworkAvailable(HomePageOneActivity.this)) {
           // callCheckOutApi();
        } else {
            Toast.makeText(this, getString(R.string.no_network_message), Toast.LENGTH_SHORT).show();
        }
    }

   }
