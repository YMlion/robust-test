package com.ymlion.robusttest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import com.meituan.robust.patch.RobustModify;

public class ThirdActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            mTextMessage.setText(R.string.title_home);
                            return true;
                        case R.id.navigation_dashboard:
                            mTextMessage.setText(R.string.title_dashboard);
                            setP2("2");
                            return true;
                        case R.id.navigation_notifications:
                            setR1();
                            mTextMessage.setText(R.string.title_notifications);
                            return true;
                    }
                    return false;
                }
            };

    private void setP2(String p) {
        P2Listener p2l = (p1, p2) -> {
            RobustModify.modify();
            String p3 = p + p1 + p2;
            Log.d("TAG", "onP3: " + p3);
        };
        p2l.onP2("33", 3);
    }

    private void setR1() {
        RListener r = p1 -> {
            RobustModify.modify();
            if ("2333".equals(p1)) {
                return 233333;
            }
            if (p1 != null) {
                return Integer.valueOf(p1);
            }
            return -1;
        };
        int res = r.onR("2333");
        Log.d("TAG", "setR1: " + res);
    }

    private void setR2(String r) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    interface P2Listener {
        void onP2(String p1, int p2);
    }

    interface RListener {
        int onR(String p1);
    }
}
