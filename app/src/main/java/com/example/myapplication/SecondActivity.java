package com.example.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;


public class SecondActivity extends Activity {
    private EditText mid;
    private EditText mpassword;
    private EditText mname;
    private EditText mphone;
    private EditText maddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mid=(EditText)findViewById(R.id.idText);
        mpassword=(EditText)findViewById(R.id.passwordText);
        mname=(EditText)findViewById(R.id.nameText);
        mphone=(EditText)findViewById(R.id.phoneText);
        maddress=(EditText)findViewById(R.id.addressText);

        if (savedInstanceState==null){
            SharedPreferences prefs= getSharedPreferences("person_info",0);
            String id=prefs.getString("id","");
            String password=prefs.getString("password","");
            String name=prefs.getString("name","");
            String phone=prefs.getString("phone","");
            String address=prefs.getString("address","");

            mid.setText(id);
            mpassword.setText(password);
            mname.setText(name);
            mphone.setText(phone);
            maddress.setText(address);
        }
        Button registerButton=(Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    protected void onDestroy(){
        super.onDestroy();
        SharedPreferences prefs=getSharedPreferences("person_info",0);
        SharedPreferences.Editor editor=prefs.edit();
        String id=mid.getText().toString();
        String password=mpassword.getText().toString();
        String name=mname.getText().toString();
        String phone=mphone.getText().toString();
        String address=maddress.getText().toString();

        editor.putString("id",id);
        editor.putString("password",password);
        editor.putString("name",name);
        editor.putString("phone",phone);
        editor.putString("address",address);
        editor.apply();

    }
}
