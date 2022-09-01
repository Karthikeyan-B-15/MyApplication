package com.example.myapplication.calc;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.R;

public class calcin extends AppCompatActivity {
    TextView text,results;
    EditText num1,num2;
    Button calc,life;
    int finalresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcin);
        text=(TextView) findViewById(R.id.textlog);
        num1=(EditText) findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        calc=(Button)findViewById(R.id.calc);
        results=(TextView)findViewById(R.id.results);
        life=(Button)findViewById(R.id.life);
        Intent intent=getIntent();
        text.setText("Welcome"+" "+intent.getStringExtra("logname"));
        ActivityResultLauncher<Intent> result=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode()== Activity.RESULT_OK){
                                Intent data=result.getData();
                                finalresult=data.getIntExtra("finalres",0);
                                results.setText("Result :"+finalresult);
                            }
                    }
                }
        );
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbers=new Intent(calcin.this,calcout.class);
                numbers.putExtra("nums1",num1.getText().toString());
                numbers.putExtra("nums2",num2.getText().toString());
                result.launch(numbers);
            }
        });
        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(calcin.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}