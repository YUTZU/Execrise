package com.example.yutzuliu.execrise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mainBtn , secondBtn ;
    EditText mainEdt;

    Button clearnBtn , submitBtn;
    CheckBox viewChk1,viewChk2;
    RadioGroup radioGroup;
    RadioButton view_rdb1,view_rdb2;


    Spinner spinner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useview();
    }


    public void useview(){
        setContentView(R.layout.touseview);
        viewChk1=(CheckBox)findViewById(R.id.view_chk1);
        viewChk2=(CheckBox)findViewById(R.id.view_chk2);
        clearnBtn =(Button)findViewById(R.id.clearnBtn);

        viewChk1.setOnCheckedChangeListener(checkedChangeListener);
        viewChk2.setOnCheckedChangeListener(checkedChangeListener);

        clearnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewChk1.setChecked(false);
                viewChk2.setChecked(false);
            }
        });


        radioGroup=(RadioGroup)findViewById(R.id.view_rdg);
        view_rdb1=(RadioButton)findViewById(R.id.view_rdb1);
        view_rdb2=(RadioButton)findViewById(R.id.view_rdb2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.view_rdb1:
                        Toast.makeText(MainActivity.this,view_rdb1.getText().
                                toString(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.view_rdb2:
                        Toast.makeText(MainActivity.this,view_rdb2.getText().
                                toString(),Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        spinner=(Spinner)findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.number,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,parent.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    private CompoundButton.OnCheckedChangeListener checkedChangeListener =
            new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(MainActivity.this,"you check :"+buttonView.getText().
                        toString(),Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this,"you cancel"+buttonView.getText().
                        toString(),Toast.LENGTH_SHORT).show();
            }
        }
    };












    public void getCircle(){
        mainBtn=(Button)findViewById(R.id.main_btn);
        mainEdt=(EditText)findViewById(R.id.main_edt);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("radius",Integer.parseInt(mainEdt.getText().toString()));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }



    public void useBundle(){
        mainBtn=(Button)findViewById(R.id.main_btn);
        mainEdt=(EditText)findViewById(R.id.main_edt);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("input",mainEdt.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }




    public void useIntent(){
        mainBtn =(Button)findViewById(R.id.main_btn);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }


    public void mainLayout(){
        setContentView(R.layout.activity_main);
        mainBtn=(Button)findViewById(R.id.main_btn);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondLayout();
            }
        });

    }

    public void secondLayout(){
        setContentView(R.layout.activity_second);
        secondBtn=(Button)findViewById(R.id.second_btn);
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout();
            }
        });

    }

}
