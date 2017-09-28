/*
 * Tweet
 *
 * Version 1.0
 *
 * September 27, 2017
 *
 * Copyright (C) 2017 Team Farhad, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a tweet
 *
 * @author Team Farhad
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet implements Tweetable {


    private String message;
    private Date date;
    private List<Mood> moodList = new ArrayList<Mood>();

    /**
     * Construct a tweet object with no date
     *
     * @param message message
     */
    public Tweet(String message){
        date = new Date();
        this.message = message;
    }

    /**
     * Constructs a Tweet object with date
     *
     * @param message tweet message
     * @param date tweet date
     */
    public Tweet(String message, Date date){
        this.date = date;
        this.message = message;
    }

    /**
     * Adds a mood
     *
     * @param mood mood
     */
    public void addMood(Mood mood){
        moodList.add(mood);
    }

    public String getMessage(){
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {this.date = date;}

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

    /**
     * Sets the tweet message
     *
     * @param message tweet message
     * @throws TweetToolLongException
     */
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
