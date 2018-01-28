package com.fxn.cuesample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;

import com.fxn.cue.Cue;
import com.fxn.cue.enums.Type;
import com.fxn.fragments.SampleFragment;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private Type type = Type.PRIMARY;
    private int gravity = Gravity.BOTTOM;
    private RadioGroup rg1, rg2;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
    }


    public void typeClick(View view) {
        switch (view.getId()) {
            case R.id.primary:
                type = Type.PRIMARY;
                rg2.clearCheck();
                break;
            case R.id.secondary:
                type = Type.SECONDARY;
                rg1.clearCheck();
                break;
            case R.id.success:
                type = Type.SUCCESS;
                rg2.clearCheck();
                break;
            case R.id.danger:
                type = Type.DANGER;
                rg1.clearCheck();
                break;
            case R.id.warning:
                type = Type.WARNING;
                rg2.clearCheck();
                break;
            case R.id.info:
                type = Type.INFO;
                rg2.clearCheck();
                break;
            case R.id.light:
                type = Type.LIGHT;
                rg1.clearCheck();
                break;
            case R.id.dark:
                type = Type.DARK;
                rg1.clearCheck();
                break;
        }
    }

    public void gravityClick(View view) {
        switch (view.getId()) {
            case R.id.top:
                gravity = Gravity.TOP;
                break;
            case R.id.center:
                gravity = Gravity.CENTER;
                break;
            case R.id.bottom:
                gravity = Gravity.BOTTOM;
                break;
        }
    }

    public void generate(View view) {
        Cue.init()
                .with(MainActivity.this)
                .setMessage("This is a sample Toast - Check it out")
                .setGravity(gravity)
                .setType(type)
                .show();
    }

    public void samplesClick(View view) {
        fragmentManager.beginTransaction().replace(R.id.container, SampleFragment.newInstance()).addToBackStack(SampleFragment.class.getName()).commit();
    }

    @Override
    public void onBackStackChanged() {
    }
}
