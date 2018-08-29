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

        //Once logged in dog likes a dog. Then need to search the selected dogs dogName array and search if
        //logged in dog was like by selected dog as well
        listImageResources = (searchDogListForMatch(dogNameMatchOrNot, dogLoggedIn));
        Intent intent = new Intent(LikeActivity.this, LoggedInActivity.class);
        if(listImageResources.isEmpty()) {
            //This is not working!!!!!
            startActivity(intent);
        }else {
            //set pictures and value
            ImageView imageView = findViewById(R.id.dogLoggedIn);
            imageView.setImageResource(listImageResources.get(0));

            ImageView imageView1 = findViewById(R.id.dogLiked);
            imageView1.setImageResource(listImageResources.get(1));

        }
    }
    //Search name of liked dog and then search its liked dog names array to search for logged in dog
    //Expensive method...in the future this would be handled in the database
    public List<Integer> searchDogListForMatch (String nameOfLikedDog, String dogLoggedIn){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < Dog.dogs.length; i++) {
            if (nameOfLikedDog.equals(Dog.dogs[i].getName())) {

                int lengthOfDogLiked = Dog.dogs[i].getDogLikes().length;

                for (int j = 0; j < Dog.dogs[i].getDogLikes().length; j++) {
                    String nameOfDogsLiked = Dog.dogs[i].getDogLikes()[j];

                    if (dogLoggedIn.equals(Dog.dogs[i].getDogLikes()[j])) {
                        //add image resource for liked dog
                        list.add(Dog.dogs[i].getImageResourceId());
                        //add image resource for logged in dog
                        for (int k = 0; k < Dog.dogs.length; k++) {
                            if (dogLoggedIn.equals(Dog.dogs[k].getName())) {
                                list.add(Dog.dogs[k].getImageResourceId());
                            }
                        }
                    }

                }
               break;
            }
        }
        return list;
    }

}
