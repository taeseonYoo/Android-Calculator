package com.taetae.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button num[];
    String number="";
    String number2 = "";
    String tmp ;
    Double dtmp;
    Double ruf1;
    boolean chos=false;
    char ch='\0';  // 자바는 char 형에서 char ch = '';식의 초기화를 허용하지 않음
    Button plus,minus,div,mul,result,allc,plma,percent,point;
    Integer[] numId = {R.id.Num0,R.id.Num1,R.id.Num2,R.id.Num3,R.id.Num4,R.id.Num5
            ,R.id.Num6,R.id.Num7,R.id.Num8,R.id.Num9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num = new Button[10]; //button array
        tv = findViewById(R.id.result);
        for(int i=0;i<10;i++){
            num[i] = findViewById(numId[i]);
        }

        plus = findViewById(R.id.Plus);
        minus = findViewById(R.id.Minus);
        div =findViewById(R.id.Divide);
        mul = findViewById(R.id.Multi);
        result = findViewById(R.id.Turn);
        allc = findViewById(R.id.All_Clear);
        plma = findViewById(R.id.Plus_Minus);
        percent = findViewById(R.id.Percent);
        point = findViewById(R.id.Point);



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = tv.getText().toString();
                if(number2 == ""){ return;}
                ch ='+';
                number = "";

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = tv.getText().toString();
                if(number2 == ""){ return;}
                ch = '-';
                number = "";

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = tv.getText().toString();
                if(number2 == ""){ return;}
                ch ='/';
                number = "";

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number2 = tv.getText().toString();
                if(number2 == ""){ return;}
                ch ='*';
                number = "";

            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp = tv.getText().toString();
                if(tmp.charAt(tmp.length()-1)!='.'){
                    tmp = tmp + '.';
                    tv.setText(tmp);
                }

                return;


            }
        });



        for(int i=0;i<10;i++){
            final int index;
            index = i;

            num[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tmp = tv.getText().toString();
                    chos = true;
                    if(chos == true) allc.setText("C");

                    if(tmp.equals("0") && tmp.length()==1) {
                        number =  num[index].getText().toString();
                        tv.setText(number);
                    }
                    else {
                        if(ch != '\0'&& number.equals("")){
                            number = num[index].getText().toString();
                            tv.setText(number);
                        }
                        else {
                            number = tmp + num[index].getText().toString();
                            tv.setText(number);
                        }
                    }
                }
            });
        }

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tmp = tv.getText().toString();

                switch(ch){
                    case '+':
                        ruf1 = Double.parseDouble(number2)+Double.parseDouble(tmp);
                        int k = ruf1.intValue();
                        if( k == ruf1 ){
                            tv.setText(Integer.toString(k));
                        }
                        else
                            tv.setText(ruf1.toString());
                        break;
                    case '-':
                        ruf1 = Double.parseDouble(number2)-Double.parseDouble(tmp);
                        int k2 = ruf1.intValue();
                        if( k2 == ruf1 ){
                            tv.setText(Integer.toString(k2));
                        }
                        else
                            tv.setText(ruf1.toString());
                        break;
                    case '/':
                        ruf1 = Double.parseDouble(number2)/Double.parseDouble(tmp);
                        int k3 = ruf1.intValue();
                        if( k3 == ruf1 ){
                            tv.setText(Integer.toString(k3));
                        }
                        else
                            tv.setText(ruf1.toString());
                        break;
                    case '*':
                        ruf1 = Double.parseDouble(number2)*Double.parseDouble(tmp);
                        int k4 = ruf1.intValue();
                        if( k4 == ruf1 ){
                            tv.setText(Integer.toString(k4));
                        }
                        else
                            tv.setText(ruf1.toString());
                        break;
                    default:
                        break;
                }


            }
        });

        allc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "";
                number2 = "";
                ch = '\0';
                chos = false;
                allc.setText("AC");
                tv.setText("0");

            }
        });

        plma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmp = tv.getText().toString();
                if(tmp=="") return;

                if(tmp.charAt(0)=='-') {
                    tmp = tmp.substring(1);
                    tv.setText(tmp);
                }
                else {
                    tmp = '-' + tmp;
                    tv.setText(tmp);
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                tmp = tv.getText().toString();
                if(tmp=="" || tmp.equals("0")) return;

                dtmp = Double.parseDouble(tmp);
                double t = dtmp/100.0;
                tv.setText(Double.toString(t));

            }
        });




    }
}