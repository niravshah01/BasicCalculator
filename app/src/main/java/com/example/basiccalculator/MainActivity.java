package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button add;
    Button sub;
    Button mul;
    Button div;
    Button clear;
    Button equal;

    TextView textView;

    String result;
    String temp;
    String ope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);

        textView = findViewById(R.id.textview);

        initcontrolListener();
    }

    private void initcontrolListener(){

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("0");}
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("1");}
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("2");}
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("3");}
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("4");}
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("5");}
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("6");}
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("7");}
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("8");}
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {numberclicked("9");}
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {operatorclicked("+");}
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {operatorclicked("-");}
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {operatorclicked("*");}
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {operatorclicked("/");}
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {clearclicked();}
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {equalclicked();}
        });
    }

    private void numberclicked(String n){
        result = textView.getText().toString();
        result = result + n;
        textView.setText(result);
    }

    private void operatorclicked(String ope){
        temp = textView.getText().toString();
        clearclicked();
        this.ope = ope;
    }

    private void clearclicked(){
        result = "";
        textView.setText("");
    }

    private void equalclicked(){
        int res = 0;
        try{
            int num = Integer.valueOf(temp);
            int num2 = Integer.valueOf(textView.getText().toString());

            switch (ope){
                case "+":
                    res = num + num2;
                    break;

                case "-":
                    res = num - num2;
                    break;

                case "*":
                    res = num * num2;
                    break;

                case "/":
                    res = num / num2;
                    break;
            }
            result = String.valueOf(res);
            textView.setText(result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}