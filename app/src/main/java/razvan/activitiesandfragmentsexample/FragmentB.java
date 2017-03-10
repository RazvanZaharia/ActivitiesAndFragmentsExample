package razvan.activitiesandfragmentsexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private static final String TAG = "FragmentB";

    private static final String MESSAGE = "message";

    public static FragmentB newInstance(@Nullable String message) {
        FragmentB fragmentB = new FragmentB();
        if (!TextUtils.isEmpty(message)) {
            Bundle args = new Bundle();
            args.putString(MESSAGE, message);
            fragmentB.setArguments(args);
        }
        return fragmentB;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        View contentView = inflater.inflate(R.layout.fragment_b, container, false);
        Bundle args = getArguments();
        if (args != null) {
            String message = args.getString(MESSAGE, "FragmentB");
            ((TextView) contentView.findViewById(R.id.tv_label)).setText(message);
        }
        return contentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView() called");
    }
}
