package com.hfad.dogtinder;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;

public class SelectedDogDetailsActivity extends AppCompatActivity {


    public static final String EXTRA_DOG_SELECTED_NAME = "dogId";
    public static final String EXTRA_DOG_SELECTED_IMAGE = "dogImage";
    public static final String EXTRA_DOG_SELECTED_DESCRIPTION = "dogDESC";
    public static final String EXTRA_DOG_LOGGED_IN_NAME = "dogAlreadyLoggedin";

    private static final String TAG = "TAGActivity";
    public String dogName;
    public String dogLogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_dog_details);

        //Getting the name of the dog already logged in
        dogLogged = (String) getIntent().getExtras().get(EXTRA_DOG_LOGGED_IN_NAME);

        //Display details of chosen dog
        dogName = (String) getIntent().getExtras().get(EXTRA_DOG_SELECTED_NAME);
        int dogImage = (Integer)getIntent().getExtras().get(EXTRA_DOG_SELECTED_IMAGE);
        String dogDescription = (String) getIntent().getExtras().get(EXTRA_DOG_SELECTED_DESCRIPTION);

        Toolbar toolbar_bottom =  findViewById(R.id.toolbar_bottom);
        setSupportActionBar(toolbar_bottom);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        TextView mTitle =  toolbar.findViewById(R.id.logged_in_user);
//        mTitle.setText(dogLogged);
//        setSupportActionBar(toolbar);


        TextView textView = (TextView) findViewById(R.id.dog_text);
        textView.setText(dogName);

        ImageView imageView =(ImageView) findViewById(R.id.dog_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, dogImage));
        imageView.setContentDescription(dogName);

        TextView textView1 = findViewById(R.id.description);
        textView1.setText(dogDescription);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this add items to the app bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_like_dog:
                Intent intent = new Intent(this, LikeActivity.class);
                intent.putExtra(LikeActivity.EXTRA_DOG_MATCH_OR_NOT, dogName);
                intent.putExtra(LikeActivity.EXTRA_DOG_LOGGED_IN_NAME, dogLogged);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
