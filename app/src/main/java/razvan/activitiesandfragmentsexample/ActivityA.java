package razvan.activitiesandfragmentsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import static razvan.activitiesandfragmentsexample.ActivityB.COLOR;

public class ActivityA extends BaseLogActivity {

    private final static int ACTIVITYB_REQUEST_CODE = 1243;//random int number
    public final static String RESULT_MESSAGE = "resultMessage";

    private final static String NUMBER_ONE = "numberOne";
    private final static String NUMBER_TWO = "numberTwo";
    private final static String SUM = "sum";

    private TextView mTvSum;
    private int number1 = 0, number2 = 0, sum = 0;

    @Override
    String getTag() {
        return ActivityA.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_a);
        mTvSum = (TextView) findViewById(R.id.tv_sum);

        if (savedInstanceState != null) {
            number1 = savedInstanceState.getInt(NUMBER_ONE, 0);
            number2 = savedInstanceState.getInt(NUMBER_TWO, 0);
            sum = savedInstanceState.getInt(SUM, 0);
        }

        number1 += 1;
        number2 += 2;
        sum = sum + number1 + number2;

        mTvSum.setText(String.valueOf(sum));

        findViewById(R.id.btn_start_activity_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activitybIntent = new Intent(ActivityA.this, ActivityB.class);
                activitybIntent.putExtra(COLOR, ContextCompat.getColor(ActivityA.this, android.R.color.holo_green_light));
                startActivityForResult(activitybIntent, ACTIVITYB_REQUEST_CODE);
            }
        });

        findViewById(R.id.btn_start_activity_transparent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this, ActivityTransparent.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITYB_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String newMessage = data.getStringExtra(RESULT_MESSAGE);
                mTvSum.setText(newMessage);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(NUMBER_ONE, number1);
        outState.putInt(NUMBER_TWO, number2);
        outState.putInt(SUM, sum);
        super.onSaveInstanceState(outState);
    }

}
