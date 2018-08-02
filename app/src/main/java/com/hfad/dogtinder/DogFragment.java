package com.hfad.dogtinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;
import android.content.Intent;

public class DogFragment extends Fragment {


    public DogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        RecyclerView dogRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_dog,container,false);

        String[] dogNames = new String[Dog.dogs.length];
        for (int i = 0; i < dogNames.length; i++) {
            dogNames[i] = Dog.dogs[i].getName();
        }

        int[] dogImages = new int[Dog.dogs.length];
        for (int i =0; i < dogImages.length; i++) {
            dogImages[i] = Dog.dogs[i].getImageResourceId();
        }

        DogImagesAdapter adapter = new DogImagesAdapter(dogNames, dogImages);
        dogRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        dogRecycler.setLayoutManager(layoutManager);


        adapter.setListener(new DogImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), LoggedInActivity.class);
                intent.putExtra(LoggedInActivity.EXTRA_DOG_LOGGED_IN_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return dogRecycler;

    }

}
