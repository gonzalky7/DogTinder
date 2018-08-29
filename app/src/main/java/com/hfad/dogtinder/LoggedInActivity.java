package com.hfad.dogtinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.List;



public class LoggedInActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static final String EXTRA_DOG_LOGGED_IN_ID = "dogId";
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        //This is to populate the toolbar with the logged in dog's name
        int dogID = (Integer)getIntent().getExtras().get(EXTRA_DOG_LOGGED_IN_ID);
        String dogName = Dog.dogs[dogID].getName();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView = (TextView) toolbar.findViewById(R.id.logged_in_user);
        textView.setText(dogName);
        setSupportActionBar(toolbar);
    }

    //This is for the child fragment to pass it the intent retrieved from parent activity called by (LoggedInFragment)
    public String GetData()
    {
        int dogID = (Integer)getIntent().getExtras().get(EXTRA_DOG_LOGGED_IN_ID);
        String dogName = Dog.dogs[dogID].getName();
        return dogName;
    }


}
