package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private TextView inputText,outputText;
    private String input="",output,newOutput;
    private Button cbtn0,cbtn1,cbtn2,cbtn3,cbtn4,cbtn5,cbtn6,cbtn7,cbtn8,cbtn9,
            clearbtn,backbtn,percentbtn,dividerbtn,multiplybtn,subbtn,addbtn,dot,equlabtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff7f50")));
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));
        cbtn0=(Button) findViewById(R.id.cbtn0);clearbtn=(Button) findViewById(R.id.clearbtn);
        cbtn1=(Button) findViewById(R.id.cbtn1);backbtn=(Button)findViewById(R.id.backbtn);
        cbtn2=(Button) findViewById(R.id.cbtn2);percentbtn=(Button)findViewById(R.id.percentbtn);
        cbtn3=(Button) findViewById(R.id.cbtn3);dividerbtn=(Button)findViewById(R.id.dividerbtn);
        cbtn4=(Button) findViewById(R.id.cbtn4);multiplybtn=(Button)findViewById(R.id.multiplybtn);
        cbtn5=(Button) findViewById(R.id.cbtn5);subbtn=(Button)findViewById(R.id.subbtn);
        cbtn6=(Button) findViewById(R.id.cbtn6);addbtn=(Button)findViewById(R.id.addbtn);
        cbtn7=(Button) findViewById(R.id.cbtn7);dot=(Button)findViewById(R.id.dot);
        cbtn8=(Button) findViewById(R.id.cbtn8);equlabtn=(Button)findViewById(R.id.equalbtn);
        cbtn9=(Button) findViewById(R.id.cbtn9);outputText=(TextView) findViewById(R.id.text1);
        inputText=(TextView) findViewById(R.id.outtext2);


    }
    public void onButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "1":
                input+="1";
                inputText.setText(input);
                break;
            case "2":
                input+="2";
                inputText.setText(input);
                break;
            case "3":
                input+="3";
                inputText.setText(input);
                break;
            case "4":
                input+="4";
                inputText.setText(input);
                break;
            case "5":
                input+="5";
                inputText.setText(input);
                break;
            case "6":
                input+="6";
                inputText.setText(input);
                break;
            case "7":
                input+="7";
                inputText.setText(input);
                break;
            case "8":
                input+="8";
                inputText.setText(input);
                break;
            case "9":
                input+="9";
                inputText.setText(input);
                break;
            case "0":
                input+="0";
                inputText.setText(input);
                break;
            case "C":
                input="";
                outputText.setText("0");
                inputText.setText(input);
                break;
            case "+":
                input+="+";
                inputText.setText(input);
                break;
            case "-":
                input+="-";
                inputText.setText(input);
                break;
            case "x":
                input+="x";
                inputText.setText(input);
                break;
            case "/":
                input+="/";
                inputText.setText(input);
                break;
            case "\u232b":
                if(!inputText.getText().toString().equals("")){
                    String value=inputText.getText().toString();
                    if(value.length()>0){
                        value=value.substring(0,value.length()-1);
                        input=value;
                        inputText.setText(value);
                    }
                }
                break;
            case "=":
                solve();
                break;
        }
    }
    private void solve(){
        if(input.contains("/")){
            double count=0;
            String numbers[] = input.split("/");
            try {
                for(int i=0;i<numbers.length;i++) {
                     count = Integer.parseInt(numbers[i])/Integer.parseInt(numbers[i+1]);break;
                }
                outputText.setText(String.valueOf(count));

            }catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if(input.contains("+")){
            int count=0;
            String numbers[] = input.split("\\+");
            try {
                for(int i=0;i<numbers.length;i++) {
                     count += Integer.parseInt(numbers[i]);
                }
                outputText.setText(String.valueOf(count));

            }catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }

//            int count=1;
//            int cout=0;
//            String numbers[] = input.split("\\+");
//            try {
//                for(int i=0;i<numbers.length;i++) {
//                     count += Integer.parseInt(numbers[i]);
//                }
//                outputText.setText(String.valueOf(count));
//
//            }catch (Exception e) {
//                outputText.setText(e.getMessage().toString());
//            }
//        String number[] = input.split("-");
//        try {
//            for(int i=0;i<number.length;i++) {
//                cout = Integer.parseInt(number[i])-Integer.parseInt(number[i+1]);break;
//            }
//            outputText.setText(String.valueOf(cout));
//
//        }catch (Exception e) {
//            outputText.setText(e.getMessage().toString());
//        }
//        String numbers[] = input.split("x");
//        try {
//            for(int i=0;i<numbers.length;i++) {
//                count *= Integer.parseInt(numbers[i]);
//            }
//            outputText.setText(String.valueOf(count));
//
//        }catch (Exception e) {
//            outputText.setText(e.getMessage().toString());
//        }
        }

//    private String cutDecimal(String number){
//        String n [] = number.split("\\.");
//        if (n.length >1){
//            if (n[1].equals("0")){
//                number = n[0];
//            }
//        }
//        return number;
//    }
}