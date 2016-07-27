package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {

    private List<String> jokes;

    public Joker() {
        jokes = new ArrayList<>();
        jokes.add("Q: What did the DNA say to the other DNA?\n" +
                "A: Do these genes make my butt look fat.");
        jokes.add("I'm afraid of my computer. I know when I turn it off, it's learning new things without me.");
        jokes.add("What's the difference between a blonde and Windows 95?\n" +
                "The blonde operates on more laptops!");
        jokes.add("Much like a shuttle launch, my rocket also comes in multiple stages.");
        jokes.add("Q: How many IT guys does it take to screw in a light bulb?\n" +
                "\n" +
                "A: None, that's a Facilities problem.");
        jokes.add("How many IBM employees does it take to screw in a light bulb?\n" +
                "10,000: one to hold up the light bulb, and 9,999 to turn the building around.");
        jokes.add("You look just like my girlfriend avatar!");
        jokes.add("I'm more machine now than man... and I think you know what I mean.");
        jokes.add("Q: Why does Ford still manufacture cars and trucks?\n" +
                "A: They're trying to keep the towing industy alive.");
        jokes.add("Q: How do cows do mathematics?\n" +
                "A: They use a cow-culator.");
        jokes.add("Q: How does a computer tell you it needs more memory?\n" +
                "A: It says ''byte me''");
        jokes.add("I get nine e-mails a week from my mom. If it doesn't have 'I have cancer' in the subject line, I delete it.");
    }


    public String tellRandomJoke() {
        int max = jokes.size() - 1;
        int index = randInt(0, max);
        return jokes.get(index);

    }


    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

}
