package com.example.fds.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Button button;

    private Integer count = 0;

    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        aSwitch = findViewById(R.id.switch1);

        ButtonListener buttonListener = new ButtonListener();
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switch (compoundButton.getId()){
                    case R.id.switch1:
                        if(compoundButton.isChecked()) Toast.makeText(MainActivity.this,"匿名内部类开关:ON",Toast.LENGTH_SHORT).show();
                        else Toast.makeText(MainActivity.this,"匿名内部类开关:OFF",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        button.setOnClickListener(buttonListener);
    }

    /*@Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.switch1:
                if(compoundButton.isChecked()) Toast.makeText(this,"开关:ON",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"开关:OFF",Toast.LENGTH_SHORT).show();
                break;

        }
    }*/

    /**
     * 内部类
     */
    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            count++;
            textView.setText("count：" + count);
        }
    }
}
