package com.example.user.project;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Testing1 extends AppCompatActivity {
    private DatabaseReference mDatabasereference;
    private DatabaseReference md;
    Button b;
    Button b2;
    int count=0;
    String arr[]={"1BM14CS077","1BM14CS078","1BM14CS079"};
    private ListView listView;
    ArrayList<String> arrayList=new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    private FirebaseAuth mAuth1;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing1);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_gallery_item,arrayList);

        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);
        b2=(Button)findViewById(R.id.button7);
        mAuth1 = FirebaseAuth.getInstance();


        mDatabasereference= FirebaseDatabase.getInstance().getReference();

        md=mDatabasereference.child("SUBJECT").child("MAD");
        b=(Button)findViewById(R.id.button6);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in

                    Log.d("message", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("message", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };







        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,String> datamap=new HashMap<String, String>();
                datamap.put("Name","Rajath");
                datamap.put("marks","76");
                mDatabasereference.child("USER1").setValue(datamap);







            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<2) {
                    md=mDatabasereference.child("SUBJECT").child("MAD");
                    md = md.child(arr[count]);
                    Log.d("hello",arr[count]);
                    count = count + 1;
                }
                    md.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            String value = dataSnapshot.getValue(String.class);


                            arrayList.add(value);
                            Log.d("hello","I was here");
                            arrayAdapter.notifyDataSetChanged();


                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


            }
        });




    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth1.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth1.removeAuthStateListener(mAuthListener);
        }
    }





}
