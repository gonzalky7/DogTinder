package com.hfad.dogtinder;

public class Dog {
    private String name;
    private int imageResourceId;
    private String description;
    private String [] dogLikes;


    static String [] dogNamesPeanut = {"Tessi","Ben","Mrs. Moppins"};
    static String [] dogNamesMoppins = {"Tessi","Ben","Bokso","Peanut"};
    static String [] dogNamesBen = {"Tessi","Peanut"};
    static String [] dogNamesBosko= {"Peanut","Ben"};
    static String [] dogNamesTessi = {"Bosko","Ben"};

    public static final Dog[] dogs = {
            new Dog("Peanut", "Totally cute", R.drawable.peanut, dogNamesPeanut),
            new Dog("Mrs. Moppins", "Spoon Full of Sugar", R.drawable.mrs_moppins, dogNamesMoppins),
            new Dog("Ben", "I love cake", R.drawable.ben, dogNamesBen),
            new Dog("Bosko", "So Handsome", R.drawable.bosko, dogNamesBosko),
            new Dog("Tessi", "So sweet", R.drawable.tessi, dogNamesTessi)
    };


    public Dog(String name, String description, int imageResourceId, String [] dogLikes) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.dogLikes = dogLikes;
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

    public String [] getDogLikes() {
        return dogLikes;
    }

}
