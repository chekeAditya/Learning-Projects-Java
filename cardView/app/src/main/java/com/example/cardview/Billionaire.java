package com.example.cardview;

public class Billionaire {
        private int Image;
        private String Heading;
        private String Age;
        private String Profession;

    public Billionaire(int image, String heading, String age, String profession) {
        Image = image;
        Heading = heading;
        Age = age;
        Profession = profession;
    }

    public int getImage() {
        return Image;
    }

    public String getHeading() {
        return Heading;
    }

    public String getAge() {
        return Age;
    }

    public String getProfession() {
        return Profession;
    }
}
