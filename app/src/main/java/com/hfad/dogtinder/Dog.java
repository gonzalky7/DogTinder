package com.hfad.dogtinder;

public class Dog {
    private String name;
    private int imageResourceId;
    private String description;

    public static final Dog[] dogs = {
            new Dog("Peanut", "Totally cute", R.drawable.peanut),
            new Dog("Mrs. Moppins", "Spoon Full of Sugar", R.drawable.mrs_moppins),
            new Dog("Ben", "I love cake", R.drawable.ben),
            new Dog("Bosko", "So Handsome", R.drawable.bosko),
            new Dog("Tessi", "So sweet", R.drawable.tessi)
    };


    public Dog(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
