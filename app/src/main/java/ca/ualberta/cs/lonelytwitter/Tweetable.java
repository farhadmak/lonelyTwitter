package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;


/**
 * This is the Tweet interface
 *
 * @author Team Farhad
 * @version 1.0
 *
 */

public interface Tweetable {
    public String getMessage();
    public Date getDate();
    public void addMood(Mood mood);
}
