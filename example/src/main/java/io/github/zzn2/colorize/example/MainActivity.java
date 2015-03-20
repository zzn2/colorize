package io.github.zzn2.colorize.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.github.zzn2.colorize.Colorize;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Apply to root view to enable whole view hierarchy
        LinearLayout rootView = (LinearLayout) findViewById(R.id.root);
        Colorize.applyTo(rootView);

        // Apply to single view which added or changed dynamically
        TextView textView = new TextView(this);
        textView.setText("And also Views created from java code");
        textView.setTextColor(getResources().getColor(R.color.orange));
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_info, 0, 0, 0);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        rootView.addView(textView);
        Colorize.applyTo(textView);
    }

}
