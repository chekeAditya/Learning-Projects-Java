package com.example.identitycard;

public class LayoutModel {
    private String Heading;
    private int Image;
    private String Age;
    private String Profession;

    public LayoutModel(String heading, int image, String age, String profession) {
        Heading = heading;
        Image = image;
        Age = age;
        Profession = profession;
    }

    public String getHeading() {
        return Heading;
    }

    public int getImage() {
        return Image;
    }

    public String getAge() {
        return Age;
    }

    public String getProfession() {
        return Profession;
    }
}
