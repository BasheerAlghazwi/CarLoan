package com.example.android.carloan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText cc;
    private EditText dp;
    private EditText ap;
    private EditText month;
    private RadioGroup RadioGB;
    private RadioButton l;
    private RadioButton lea;
    private SeekBar seekBar;
    private Button button;
    private TextView sekpersntage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addlistenerOnButton();

        cc=findViewById(R.id.ECC);
        dp=findViewById(R.id.ED);
        ap=findViewById(R.id.Eapr);
        month=findViewById(R.id.EMp);
        RadioGB=findViewById(R.id.RG);
        l=findViewById(R.id.loan);
        lea=findViewById(R.id.lease);
        seekBar=findViewById(R.id.sek);
        button=findViewById(R.id.cal);
        sekpersntage=findViewById(R.id.seekPersntage);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {}

    public void onStopTrackingTouch(SeekBar seekBar) {}
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.lease:
                if (checked)
                  break;
            case R.id.loan:
                if (checked)
                    break;
        }
    }

    public void addlistenerOnButton(){
        RadioGB = (RadioGroup) findViewById(R.id.RG);
        button = (Button)findViewById(R.id.cal);
    }

    public void calcu(View v){
        String input = cc.getText().toString();
        String input2 = dp.getText().toString();
        String input3 = ap.getText().toString();
        float cc = Float.parseFloat(input);
        float dp = Float.parseFloat(input2);
        float ap = Float.parseFloat(input3)/100;
        float mr = ap/12;
        seekBar.getProgress();
      //  sekpersntage
        float n = seekBar.getProgress();
        //int n = 36;
        if(l.isChecked()){
            float L = cc-dp;
            double P = mr*L/(1-Math.pow(1+mr,-n));
            // P=Math.round(P*100.00)/100.0;
            month.setText("$$        "+String.format("%.2f",P )+"        $$");
        }else if (lea.isChecked()) {
            float L = (cc - dp) / 3;
            double P = mr * L / (1 - Math.pow(1 + mr, -n));
            // P=Math.round(P*100.00)/100.0;
            month.setText("$"+String.format("%.2f",P ));
        }
    }
}
