package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Happy Mood
 *
 * @author Team Farhad
 * @version 1.0
 * @see Mood
 */

public class Happy extends Mood {
    /**
     * Happy method with date functionality
     * @param date date
     */
    public Happy(Date date){
        super(date);
    }

    public Happy(){
        super();
    }

    public String displayMood() {
        return "I am happy";
    }
}
