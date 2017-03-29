package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TorS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tor_s);
    }
    public void studentloginpage(View v)
    {
        Intent j=new Intent(this,MainActivity.class);
        startActivity(j);

    }
    public void teacherlog(View v)
    {
        Intent teacher=new Intent(this,TeacherLogin.class);
        startActivity(teacher);
    }
}
