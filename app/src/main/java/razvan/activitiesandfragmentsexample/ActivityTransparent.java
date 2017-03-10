package razvan.activitiesandfragmentsexample;

import android.os.Bundle;

public class ActivityTransparent extends BaseLogActivity {

    @Override
    String getTag() {
        return ActivityTransparent.class.getSimpleName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
    }
}
