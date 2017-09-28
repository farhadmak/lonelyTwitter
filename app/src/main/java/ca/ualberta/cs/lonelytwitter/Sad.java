package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Sad Mood
 *
 * @author Team Farhad
 * @version 1.0
 * @see Mood
 */


public class Sad extends Mood {
    public Sad(Date date){
        super(date);
    }

    public Sad(){
        super();
    }

    public String displayMood() {
        return "I am so sad";
    }
}