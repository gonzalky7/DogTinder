package com.hfad.dogtinder;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class LikeActivity extends AppCompatActivity {


    public static final String EXTRA_DOG_MATCH_OR_NOT = "dogMatch";
    public static final String EXTRA_DOG_LOGGED_IN_NAME = "dogAlreadyLoggedin";
    List<Integer> listImageResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String dogNameMatchOrNot = (String) getIntent().getExtras().get(EXTRA_DOG_MATCH_OR_NOT);
        String dogLoggedIn = (String) getIntent().getExtras().get(EXTRA_DOG_LOGGED_IN_NAME);

        //Chosen dog will search its array of liked dogs. If the dog who liked is in that array then there is a match,
        //if not go back to loggedInFragment.
        listImageResources = (searchDogListForMatch(dogNameMatchOrNot, dogLoggedIn));

        if(listImageResources.isEmpty()) {
            Intent intent = new Intent(this, LoggedInActivity.class);
            startActivity(intent);
        }else {
            //set pictures and value
            ImageView imageView = findViewById(R.id.dogLoggedIn);
            imageView.setImageResource(listImageResources.get(0));

            ImageView imageView1 = findViewById(R.id.dogLiked);
            imageView1.setImageResource(listImageResources.get(1));

        }

    }


    public List<Integer> searchDogListForMatch (String nameOfLikedDog, String dogLoggedIn){
        List<Integer> list = new ArrayList<>();
        boolean flag1 = false;
        for (int i = 0; i < Dog.dogs.length; i++) {
            if (dogLoggedIn.equals(Dog.dogs[i].getName())) {
                for (int j = 0; j < Dog.dogs[i].getDogLikes().length; j++) {
                    if (nameOfLikedDog.equals(Dog.dogs[i].getDogLikes()[j])) {
                        list.add(Dog.dogs[i].getImageResourceId());
                        flag1 = true;
                        continue;
                    }
                }
            }
        }
        if(flag1) {
            for (int i = 0; i < Dog.dogs.length; i++) {
                if (nameOfLikedDog.equals(Dog.dogs[i].getName())) {
                    list.add(Dog.dogs[i].getImageResourceId());
                }
            }
        }
        return list;
    }

}
