package chapter.android.aweme.ss.com.homework;

import android.util.Log;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 myDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class Exercises1 extends AppCompatActivity {

    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";

    private static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";

    private MyApplication myApplication;//考虑用application实现
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        myApplication = (MyApplication)getApplication();
        button = findViewById(R.id.btn_reset);
        textView = findViewById(R.id.tv_content);
        myApplication.setmLifecycleDisplay(textView);

        if (savedInstanceState != null) { //当Activity重建的时候不为空
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {
                String savedContent = (String) savedInstanceState.get(LIFECYCLE_CALLBACKS_TEXT_KEY);
                Log.d("LIFECYCLE:SAVED",savedContent);
                savedContent += "onStop\nonDestroy";
                myApplication.setmLifecycleDisplayText(savedContent);
            }
        }
        myApplication.logAndAppend(ON_CREATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//清空log
                myApplication.clearmLifecycleDisplayText();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        myApplication.logAndAppend(ON_RESTART);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myApplication.logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myApplication.logAndAppend(ON_RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myApplication.logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        myApplication.logAndAppend(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        myApplication.logAndAppend(ON_DESTROY);
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        myApplication.logAndAppend(ON_SAVE_INSTANCE_STATE);
        String content = myApplication.getmLifecycleDisplay().getText().toString();
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, content);
    }


}
