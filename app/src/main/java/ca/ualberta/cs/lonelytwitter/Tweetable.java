package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by farhadmakiabady on 2017-09-13.
 */

public interface Tweetable {
    public String getMessage();
    public Date getDate();
    public void addMood(Mood mood);
}
