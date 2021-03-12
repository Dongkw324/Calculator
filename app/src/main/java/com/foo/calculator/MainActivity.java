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
    private int enterCnt = 0;
    private int option;
    private int operator;
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
        option = DEFAULT;
        operator = DEFAULT;
        enterCnt = 0;
    }

    public void function(View view){
        switch(view.getId()){
            case R.id.remove_all:
                number = "";
                resultValue.setText("0");
                operator = DEFAULT;
                option = DEFAULT;
                enterCnt = 0;
                break;
            case R.id.plus_minus:
                number = resultValue.getText().toString();
                if(Double.parseDouble(number)-(int)(Double.parseDouble(number)) == 0.0){
                    resultValue.setText(""+Integer.parseInt(number)*-1);
                } else {
                    resultValue.setText("" + Double.parseDouble(number) * -1);
                }
                break;
            case R.id.percent100:
                number = resultValue.getText().toString();
                BigDecimal num = new BigDecimal(number);
                BigDecimal number100 = new BigDecimal(100);
                if(resultValue.length()<=10){
                    resultValue.setText(""+num.divide(number100));
                } else{
                    double temp = Double.parseDouble(String.valueOf(num.divide(number100)));
                    resultValue.setText(""+temp);
                }
                option = PERCENT;
                break;
           
            case R.id.plus:
                number = resultValue.getText().toString();
                resultValue.setText("");
                operator = PLUS;
                break;
            case R.id.minus:
                number = resultValue.getText().toString();
                resultValue.setText("");
                operator = MINUS;
                break;
            case R.id.multiple:
                number = resultValue.getText().toString();
                resultValue.setText("");
                operator = MULTI;
                break;
            case R.id.divide:
                number = resultValue.getText().toString();
                resultValue.setText("");
                operator = DIVIDE;
                break;
            case R.id.equal:
                Double ans = null;
                switch(operator){
                    case PLUS:
                        ans = Double.parseDouble(number)+Double.parseDouble(resultValue.getText().toString());
                        break;
                    case MINUS:
                        ans = Double.parseDouble(number)-Double.parseDouble(resultValue.getText().toString());
                        break;
                    case MULTI:
                        ans = Double.parseDouble(number)*Double.parseDouble(resultValue.getText().toString());
                        break;
                    case DIVIDE:
                        ans = Double.parseDouble(number)/Double.parseDouble(resultValue.getText().toString());
                        if(ans.toString().length()>=10){
                            ans = (double)Math.round(ans*10000000)/10000000.0;
                        }
                        if(ans.isInfinite() || ans.isNaN()){
                            number = null;
                            resultValue.setText("오류");
                            return;
                        }
                        break;
                }
                resultValue.setText(""+ans);
                number = resultValue.getText().toString();
                break;
        }
    }

    public void num(View view){

        if(enterCnt == 0){
            resultValue.setText("");
        }

        if(resultValue.getText().toString().contains("E") || option == PERCENT ){
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