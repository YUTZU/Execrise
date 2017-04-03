package com.example.yutzuliu.execrise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button main2Btn;
    TextView main2Txv;
    int radius;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toCaculateCircle();


    }


    public void toCaculateCircle(){
        main2Btn=(Button)findViewById(R.id.main2_btn);
        main2Txv=(TextView)findViewById(R.id.main2_txv);
        Bundle bundle = getIntent().getExtras();
        radius = bundle.getInt("radius");
        main2Txv.setText("the area of circle is :" + radius*radius*3.14);
        main2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    public void fromBundle(){
        main2Btn=(Button)findViewById(R.id.main2_btn);
        main2Txv=(TextView)findViewById(R.id.main2_txv);

        Bundle bundle = getIntent().getExtras();
        main2Txv.setText(bundle.getString("input"));

        main2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }






    public  void fromIntent(){
        main2Btn=(Button)findViewById(R.id.main2_btn);
        main2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
