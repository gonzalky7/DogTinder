package com.hfad.dogtinder;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SelectedDogDetailsActivity extends AppCompatActivity {


    public static final String EXTRA_DOG_SELECTED_NAME = "dogId";
    public static final String EXTRA_DOG_SELECTED_IMAGE = "dogImage";
    public static final String EXTRA_DOG_SELECTED_DESCRIPTION = "dogDESC";
    public static final String EXTRA_DOG_LOGGED_IN_NAME = "dogAlreadyLoggedin";

    private static final String TAG = "TAGActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_dog_details);

        //Getting the name of the dog already logged in
        String dogLogged = (String) getIntent().getExtras().get(EXTRA_DOG_LOGGED_IN_NAME);

        //Display details of chosen dog
        String dogName = (String) getIntent().getExtras().get(EXTRA_DOG_SELECTED_NAME);
        int dogImage = (Integer)getIntent().getExtras().get(EXTRA_DOG_SELECTED_IMAGE);
        String dogDescription = (String) getIntent().getExtras().get(EXTRA_DOG_SELECTED_DESCRIPTION);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.logged_in_user);
        mTitle.setText(dogLogged);
        setSupportActionBar(toolbar);


        TextView textView = (TextView) findViewById(R.id.dog_text);
        textView.setText(dogName);

        ImageView imageView =(ImageView) findViewById(R.id.dog_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, dogImage));
        imageView.setContentDescription(dogName);

        TextView textView1 = findViewById(R.id.description);
        textView1.setText(dogDescription);

    }
}
