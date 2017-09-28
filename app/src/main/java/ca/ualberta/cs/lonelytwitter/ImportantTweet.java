package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * @author Team Farhad
 * @version 1.0
 *
 * @see Tweet
 */

public class ImportantTweet extends Tweet {
    /**
     * Important Tweet with no date functionality
     * @param message message
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Important Tweet with message and date functionality
     *
     * @param message tweet message
     * @param date tweet date
     */
    public ImportantTweet(String message, Date date){
        super(message, date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
