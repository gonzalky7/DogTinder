package com.hfad.dogtinder;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoggedInFragment extends Fragment {
    private static final String TAG = "MyActivity";

    public LoggedInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Calling GetData() method from the Parent Activity LoggedInActivity.java
        String DogName = ((LoggedInActivity)getContext()).GetData();


        // Inflate the layout for this fragment
        RecyclerView mRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_logged_in,container,false);

        List<String> dogNamesList = new ArrayList<>();

        for (int i = 0; i < Dog.dogs.length; i++) {
            if (DogName == Dog.dogs[i].getName()){
                continue;
            }
            dogNamesList.add(Dog.dogs[i].getName());
        }

        String[] dogNames = dogNamesList.toArray(new String[dogNamesList.size()]);
        List<Integer> dogImagesList = new ArrayList<>();

        for (int i = 0; i < Dog.dogs.length; i++) {
            if (DogName == Dog.dogs[i].getName()){
                continue;
            }
            dogImagesList.add(Dog.dogs[i].getImageResourceId());
        }

        int[] dogImages = ArrayUtils.toPrimitive(dogImagesList.toArray(new Integer[0]));

        DogImagesAdapter adapter = new DogImagesAdapter(dogNames, dogImages);
        mRecyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        //this sends the chosen dog's id to the SelecteDogDetailsActivity
        adapter.setListener(new DogImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SelectedDogDetailsActivity.class);
                intent.putExtra(SelectedDogDetailsActivity.EXTRA_DOG_SELECTED_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return mRecyclerView;
    }

}
