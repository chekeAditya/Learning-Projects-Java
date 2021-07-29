package com.example.animaldetails;

public class Animal {
    private String AnimalHeading;
    private int animalImage;
    private String animalName;
    private String animalSound;

    public Animal(String animalHeading, int animalImage, String animalName, String animalSound) {
        AnimalHeading = animalHeading;
        this.animalImage = animalImage;
        this.animalName = animalName;
        this.animalSound = animalSound;
    }

    public String getAnimalHeading() {
        return AnimalHeading;
    }

    public int getAnimalImage() {
        return animalImage;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalSound() {
        return animalSound;
    }
}