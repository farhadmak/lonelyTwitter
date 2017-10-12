package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

import static android.R.id.list;

/**
 * Created by farhadmakiabady on 2017-10-11.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddtweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try{
            tweets.add(tweet);
            assertTrue(tweets.hasTweet(tweet));
        }
        catch (IllegalArgumentException e){

        }
    }

    public void testDelete(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        Tweet returnedTweet = list.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }
    public void testGetTweets(){
        TweetList tweets = new TweetList();

        Tweet first = new NormalTweet("first", new Date(1000));
        Tweet second = new NormalTweet("second", new Date(5000));
        Tweet third = new NormalTweet("third", new Date(7000));

        tweets.add(third);
        tweets.add(second);
        tweets.add(first);

        ArrayList<Tweet> returnedTweet = tweets.getTweets();
        assertEquals(returnedTweet.get(0), first);
        assertEquals(returnedTweet.get(1), second);
        assertEquals(returnedTweet.get(2), third);
    }
    public void testGetCount(){
        TweetList tweets = new TweetList();

        Tweet first = new NormalTweet("test");
        Tweet second = new NormalTweet("test2");
        tweets.add(first);
        tweets.add(second);
        //ArrayList<Tweet> returnedTweet = tweets.getCount();
        assertEquals(tweets.getCount(), 2);


    }
}
