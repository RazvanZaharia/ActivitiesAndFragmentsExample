package razvan.activitiesandfragmentsexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityB extends BaseLogActivity {
    public final static String COLOR = "color";

    private TextView mTvOrientation;

    @Override
    String getTag() {
        return ActivityB.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mTvOrientation = (TextView) findViewById(R.id.tv_orientation);

        setOrientationLabel(getResources().getConfiguration().orientation);

        Intent startIntent = getIntent();
        int colorOfTvOrientation = startIntent.getIntExtra(COLOR, getResources().getColor(android.R.color.black));
        mTvOrientation.setTextColor(colorOfTvOrientation);

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(ActivityA.RESULT_MESSAGE, "Message from ActivityB");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        findViewById(R.id.btn_start_activity_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityB.this, ActivityC.class));
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        setOrientationLabel(newConfig.orientation);
    }

    private void setOrientationLabel(int orientation) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) { // new orientation is Landscape
            mTvOrientation.setText("LANDSCAPE");
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT) { // new orientation is Portrait
            mTvOrientation.setText("PORTRAIT");
        }
    }

}
