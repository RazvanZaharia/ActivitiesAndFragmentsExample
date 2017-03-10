package razvan.activitiesandfragmentsexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class ActivityC extends FragmentActivity {
    private static final String FRAGMENT_B_TAG = "fragmentB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        if (savedInstanceState == null) {
            FragmentB fragmentB = FragmentB.newInstance("Message from ActivityC");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.layout_container, fragmentB, FRAGMENT_B_TAG);
            fragmentTransaction.commitNow();
//            fragmentTransaction.addToBackStack(FRAGMENT_B_TAG);
        }
    }
}
