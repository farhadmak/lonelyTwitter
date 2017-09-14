package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by farhadmakiabady on 2017-09-13.
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private List<Mood> moodList = new ArrayList<Mood>();

    public Tweet(String message){
        date = new Date();
        this.message = message;
    }

    public Tweet(String message, Date date){
        this.date = date;
        this.message = message;
    }
    public void addMood(Mood mood){
        moodList.add(mood);
    }

    public String getMessage(){
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setMessage(String message) throws TweetToolLongException{
        if (message.length() <= 140){
            this.message = message;
        }
        else{
            throw new TweetToolLongException();
        }
    }

    public abstract Boolean isImportant();
}
