package com.hfad.dogtinder;

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

        int dogID = (Integer)getIntent().getExtras().get(EXTRA_DOG_LOGGED_IN_ID);
        String dogName = Dog.dogs[dogID].getName();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView = (TextView) toolbar.findViewById(R.id.logged_in_user);
        textView.setText(dogName);
        setSupportActionBar(toolbar);

        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) findViewById(R.id.dog_recycle_logged);

        List<String> dogNamesList = new ArrayList<>();

        for (int i = 0; i < Dog.dogs.length; i++) {
            if (dogName == Dog.dogs[i].getName()){
                continue;
            }
            dogNamesList.add(Dog.dogs[i].getName());
        }

        String[] dogNames = dogNamesList.toArray(new String[dogNamesList.size()]);

        List<Integer> dogImagesList = new ArrayList<>();


        for (int i = 0; i < Dog.dogs.length; i++) {
            if (dogName == Dog.dogs[i].getName()){
                continue;
            }
            dogImagesList.add(Dog.dogs[i].getImageResourceId());
        }

        int[] dogImages = ArrayUtils.toPrimitive(dogImagesList.toArray(new Integer[0]));

        DogImagesAdapter adapter = new DogImagesAdapter(dogNames, dogImages);
        mRecyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
