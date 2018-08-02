package com.hfad.dogtinder;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SelectedDogDetailsActivity extends AppCompatActivity {


    public static final String EXTRA_DOG_SELECTED_ID = "dogId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_dog_details);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.logged_in_user);
        mTitle.setText("Figure out how to keep dog logged in");
        setSupportActionBar(toolbar);


        //Display details of chosen dog
        int dogID = (Integer) getIntent().getExtras().get(EXTRA_DOG_SELECTED_ID);
        String dogName = Dog.dogs[dogID].getName();

        TextView textView = (TextView) findViewById(R.id.dog_text);
        textView.setText(dogName);

        int dogImage = Dog.dogs[dogID].getImageResourceId();
        ImageView imageView =(ImageView) findViewById(R.id.dog_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, dogImage));
        imageView.setContentDescription(dogName);

    }
}
