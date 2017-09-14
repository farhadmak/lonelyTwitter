package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by farhadmakiabady on 2017-09-14.
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