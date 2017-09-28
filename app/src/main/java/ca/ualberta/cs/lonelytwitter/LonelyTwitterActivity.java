package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
		;import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Lonley Twitter activity
 *
 * @author Team Farhad
 * @version 1.0
 *
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	

	/**
	 * Called when the activity is first created
	 *
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById((R.id.clear));
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				tweets.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){

				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
				saveInFile();

////				Tweet tweet = new ImportantTweet("",new Date());
////
////				Tweet tweet1 = new NormalTweet("Hi");
////				try{
////					tweet.setMessage("Hello");
////				} catch (TweetToolLongException e){
////					// e.printStackTrace();
////				}
////
////				Tweetable tweet3 = new ImportantTweet("");
////				ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
////				tweetList.add(tweet);
////				tweetList.add(tweet1);
//
//				Log.d("", "This isImportant method on tweet returns " + tweet.isImportant());
//				Log.d("", "This isImportant method on tweet1 returns " + tweet1.isImportant());
//				//finish();

			}
		});
	}

	@Override
	/**
	 * Method that is called when activity starts
	 *
	 */
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Method that loads data from file
	 *
	 * @see FileNotFoundException
	 * @see IOException
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method that saves data to file when activity stops
	 *
	 * @see FileNotFoundException
	 * @see IOException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}