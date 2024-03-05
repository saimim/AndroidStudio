package com.example.myapplication;
import java.util.Scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView primarydispobj,secodndarydispobj;
    Button digitbtnobj,operatorbtnobj;
    String number1Text,number2Text,operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primarydispobj = findViewById(R.id.primaryDispobj);
        secodndarydispobj = findViewById(R.id.secondaryDispobj);
    }

    public void backbtnFn(View view) {
        String oldText = primarydispobj.getText().toString();
        String newText = oldText.substring(0,oldText.length()-1);
        primarydispobj.setText(""+newText);
    }

    public void DigitFunction(View Myview) {
        digitbtnobj = findViewById(Myview.getId());
        String initialValue = primarydispobj.getText().toString();
        String btnText = digitbtnobj.getText().toString();
        if(initialValue.equals("0")){
            primarydispobj.setText(""+btnText);
        }
        else{
            primarydispobj.setText(initialValue+btnText);
        }
    }

    public void operationFunction(View view) {
        number1Text = primarydispobj.getText().toString();
        operatorbtnobj = findViewById(view.getId());
        operator = operatorbtnobj.getText().toString();
        secodndarydispobj.setText(number1Text+""+operator);
        primarydispobj.setText("0");

    }

    public void clearFunction(View view) {
        primarydispobj.setText("0");
        secodndarydispobj.setText("");
        number1Text = " ";
        number2Text = "";
        operator = "";
    }

    public void ResultFunction(View view) {
        Double num1,num2,result = 0.0;
        num1 = Double.parseDouble(number1Text);
        number2Text = primarydispobj.getText().toString();
        num2 = Double.parseDouble(number2Text);
        if(operator.equals("+")){
            result = num1+num2;
        } else if (operator.equals("-")) {
            result = num1-num2;
        }
        else if(operator.equals("/")){
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                primarydispobj.setText("Cannot divide by zero.");
                return;
            }
        }
        else if(operator.equals("X")){
            result = num1*num2;
        }
        else if(operator.equals("sqr")){
            result = num1 * num1;
        }
        else if(operator.equals("sqrt")){
            if (num1 >= 0) {
                result = Math.sqrt(num1); // Square root of num1
            } else {
                primarydispobj.setText("Error! Cannot compute square root of a negative number.");
                return;
            }
        }
        secodndarydispobj.setText(number1Text+""+operator+""+number2Text+"=");
        primarydispobj.setText(""+result);
    }

    public void SignFunction(View view) {
        number1Text = primarydispobj.getText().toString();
        primarydispobj.setText("-"+number1Text);
    }
}