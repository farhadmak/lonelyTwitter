package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by farhadmakiabady on 2017-09-13.
 */

public class Happy extends Mood {
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
