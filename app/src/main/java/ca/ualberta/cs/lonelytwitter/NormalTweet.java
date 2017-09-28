package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * @author Team Farhad
 * @version 1.0
 */

public class NormalTweet extends Tweet {

    /**
     * Normal Tweet with no date functionality
     *
     * @param message message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Normal Tweet with message and date functionality
     *
     * @param message message
     * @param date date
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
