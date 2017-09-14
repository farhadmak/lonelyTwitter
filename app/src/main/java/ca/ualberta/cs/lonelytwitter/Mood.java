package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by farhadmakiabady on 2017-09-13.
 */

public abstract class Mood{
    private Date date;

    public Mood(Date date){
        this.date = date;
    }

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
