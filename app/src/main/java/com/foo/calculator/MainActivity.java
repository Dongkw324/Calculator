package com.foo.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity  {
    private EditText resultValue;
    private String number="";
    int enterCnt = 0;
    int option;
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int MULTI = 2;
    public static final int DIVIDE = 3;
    public static final int PERCENT = 4;
    public static final int DEFAULT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultValue = findViewById(R.id.result_value);
    }

    public void function(View view){
        switch(view.getId()){
            case R.id.remove_all:
                number = "";
                resultValue.setText("0");
                enterCnt = 0;
                break;
            case R.id.plus_minus:
                number = resultValue.getText().toString();
                resultValue.setText(""+Double.parseDouble(number)*-1);
                break;
            case R.id.percent100:
                number = resultValue.getText().toString();
                BigDecimal num = new BigDecimal(number);
                BigDecimal number100 = new BigDecimal(100);
                double temp = Double.parseDouble(String.valueOf(num.divide(number100)));
                if(resultValue.length()<=12){
                    resultValue.setText(""+num.divide(number100));
                } else{
                    resultValue.setText(""+temp);
                }
                option = PERCENT;
                break;
        }
    }

    public void num(View view){
        if(enterCnt == 0){
            resultValue.setText("");
        }

        if(resultValue.getText().toString().contains("E") || option == PERCENT){
            resultValue.setText("");
            option = DEFAULT;
        }

        switch(view.getId()){
            case R.id.one:

                resultValue.setText(resultValue.getText().toString()+"1");
                break;
            case R.id.two:
                resultValue.setText(resultValue.getText().toString()+"2");
                break;
            case R.id.three:
                resultValue.setText(resultValue.getText().toString()+"3");
                break;
            case R.id.four:
                resultValue.setText(resultValue.getText().toString()+"4");
                break;
            case R.id.five:
                resultValue.setText(resultValue.getText().toString()+"5");
                break;
            case R.id.six:
                resultValue.setText(resultValue.getText().toString()+"6");
                break;
            case R.id.seven:
                resultValue.setText(resultValue.getText().toString()+"7");
                break;
            case R.id.eight:
                resultValue.setText(resultValue.getText().toString()+"8");
                break;
            case R.id.nine:
                resultValue.setText(resultValue.getText().toString()+"9");
                break;
            case R.id.zero:
                resultValue.setText(resultValue.getText().toString()+"0");
                break;
        }
        enterCnt++;
    }

}