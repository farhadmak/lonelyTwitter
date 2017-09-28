package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Mood class
 *
 * @author Team Farhad
 * @version 1.0
 *
 */

public abstract class Mood{
    private Date date;

    /**
     * Mood Method that includes date
     * @param date date
     */
    public Mood(Date date){
        this.date = date;
    }

    /**
     * Mood method without needing date
     */
    public Mood() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String displayMood() {
        return "I am moodless";
    }
}
