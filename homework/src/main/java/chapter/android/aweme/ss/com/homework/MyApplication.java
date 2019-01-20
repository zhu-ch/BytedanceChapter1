package chapter.android.aweme.ss.com.homework;

import android.app.Application;
import android.util.Log;
import android.widget.TextView;

public class MyApplication extends Application{

    private static final String TAG = "LIFECYCLE";
    private TextView mLifecycleDisplay;//存储log的TextView

    public void setmLifecycleDisplay(TextView mLifecycleDisplay) {
        this.mLifecycleDisplay = mLifecycleDisplay;
    }

    public void setmLifecycleDisplayText(String mLifecycleDisplay) {
        this.mLifecycleDisplay.append(mLifecycleDisplay+"\n");
    }

    public void clearmLifecycleDisplayText(){
        this.mLifecycleDisplay.setText("");
    }

    public TextView getmLifecycleDisplay() {
        return mLifecycleDisplay;
    }


    public void logAndAppend(String lifecycleEvent) {
        this.setmLifecycleDisplayText(lifecycleEvent);
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
