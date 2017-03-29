package com.example.user.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Teacher extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private DatabaseReference mDatabasereference;
    private DatabaseReference md;
    Spinner s1;

    FragmentManager fragmentManager1=getSupportFragmentManager();
    FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDatabasereference= FirebaseDatabase.getInstance().getReference();




        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Teacherdata f1=new Teacherdata();
        


        fragmentTransaction1.replace(R.id.rel1,f1);

        Log.d("hello","it stopped here");

        fragmentTransaction1.commit();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();


        if (id == R.id.nav_camera) {
            Teacherdata f1=new Teacherdata();


            fragmentTransaction.replace(R.id.rel1,f1);

            Log.d("hello","it stopped here");

            fragmentTransaction.commit();

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Editfragment e1=new Editfragment();
            fragmentTransaction.replace(R.id.rel1,e1);
            fragmentTransaction.commit();



        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            DataChanged d1=new DataChanged();
            fragmentTransaction.replace(R.id.rel1,d1);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if(id==R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent j=new Intent(this,TorS.class);
            startActivity(j);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void calculate(View view)
    {
        EditText e1,e2,e3;
        String usn,cie,see,finalm,finalg;
        TextView t1;
        e1=(EditText)findViewById(R.id.ciemarks);
        e2=(EditText)findViewById(R.id.seemarks);
        e3=(EditText)findViewById(R.id.finalmarks) ;
        t1=(TextView)findViewById(R.id.finalgrade);
        s1=(Spinner)findViewById(R.id.usns);
        cie=e1.getText().toString();
        see=e2.getText().toString();
        usn=s1.getSelectedItem().toString();
        float fm=Float.parseFloat(cie)+(Float.parseFloat(see))/2;
        String s=Float.toString(fm);
        e3.setText(s);
        if(fm>=90&&fm<=100)
        {
            t1.setText("S");
        }
        else if(fm>=75&&fm<90)
        {
            t1.setText("A");
        }
        else if(fm>=60&&fm<75)
        {
            t1.setText("A");
        }


    }


    public void submitted(View view) {
        EditText e1,e2,e3;
        TextView t1;

        String usn,cie,see,finalm,finalg;
        ArrayAdapter<String> sarryadapter;


        e1=(EditText)findViewById(R.id.ciemarks);
        e2=(EditText)findViewById(R.id.seemarks);
        e3=(EditText)findViewById(R.id.finalmarks) ;
        t1=(TextView)findViewById(R.id.finalgrade);
        s1=(Spinner)findViewById(R.id.usns);

        cie=e1.getText().toString();
        see=e2.getText().toString();
        usn=s1.getSelectedItem().toString();
        float fm=Float.parseFloat(cie)+(Float.parseFloat(see))/2;
        String s=Float.toString(fm);
        finalm=e3.getText().toString();
        finalg=t1.getText().toString();

        HashMap<String,String> datamap=new HashMap<String, String>();
        datamap.put("CIE",cie);
        datamap.put("SEE",see);
        datamap.put("FINAL",finalm);
        datamap.put("FINALGRADE",finalg);

        mDatabasereference.child("SUBJECT").child("MAD").child(usn).setValue(datamap);
        e1.setText("");
        e2.setText("");
        e3.setText("");
        t1.setText("");
        int i=s1.getSelectedItemPosition()+1;
        int j=s1.getCount();
        Log.d("message",Integer.toString(j));


        if(i<=s1.getLastVisiblePosition())
        {
            s1.setSelection(i);
        }

    }
}
