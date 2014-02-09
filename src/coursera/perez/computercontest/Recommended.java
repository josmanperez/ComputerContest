package coursera.perez.computercontest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Recommended extends Activity {

	private EditText mName;
	private EditText mEmail;
	private EditText mComments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommended);

		mName = (EditText) findViewById(R.id.name);
		mEmail = (EditText) findViewById(R.id.email);
		mComments = (EditText) findViewById(R.id.comments);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recommended, menu);
		return true;
	}
	
	public void onResume(){
		super.onResume();
	}

	/*
	 * public void processForm(View v) { String comments =
	 * mComments.getText().toString(); String name = mName.getText().toString();
	 * String mail = mEmail.getText().toString();
	 * 
	 * int position = mail.indexOf("@");
	 * 
	 * // Notice '==' means see if these integers are the same if (position ==
	 * -1) { // Alternatively... if( ! email.contains("@") )
	 * Toast.makeText(this.getApplicationContext(), "Invalid email address!",
	 * Toast.LENGTH_LONG).show(); mEmail.requestFocus(); return; }
	 * 
	 * int len = comments.length();
	 * 
	 * // To see if two integer values are equal use == // But don't use == for
	 * Strings (see below)! if (len == 0) {
	 * Toast.makeText(this.getApplicationContext(), "Give me comments!",
	 * Toast.LENGTH_LONG).show(); mComments.requestFocus(); return; }
	 * 
	 * String username = mail.substring(0, position); String thankyou =
	 * "Thank you " + username + "!";
	 * 
	 * Toast.makeText(this.getApplicationContext(), thankyou,
	 * Toast.LENGTH_LONG).show();
	 * 
	 * Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
	 * emailIntent.setData(Uri.fromParts("mailto",
	 * "feedback@myapp.somewhere...", null));
	 * emailIntent.putExtra(Intent.EXTRA_SUBJECT, "feedback");
	 * 
	 * String message = name + " comments that " + comments;
	 * 
	 * emailIntent.putExtra(Intent.EXTRA_TEXT, message);
	 * 
	 * if (emailIntent.resolveActivity(getPackageManager()) == null) {
	 * Toast.makeText(getApplicationContext(),
	 * "Please configure your email client!", Toast.LENGTH_LONG) .show(); } else
	 * { // Secondly, use a chooser will gracefully handle 0,1,2+ matching //
	 * activities startActivity(Intent.createChooser(emailIntent,
	 * "Please choose your email app!")); }
	 * 
	 * }
	 */

	public void processFormOriginal(View v) {
		// Not used in this video
		// Validate and Animate
		String comments = mComments.getText().toString();
		String email = mEmail.getText().toString();
		String name = mName.getText().toString();
		// Notice '=' means assign to the variable on the left
		// to the value of the right hand side

		int position = email.indexOf("@");

		// Notice '==' means see if these integers are the same
		if (position == -1) {
			// Alternatively... if( ! email.contains("@") )
			Toast.makeText(this.getApplicationContext(),
					"Invalid email address!", Toast.LENGTH_LONG).show();
			mEmail.requestFocus();
			return;
		}

		// You can ask a string for its length (number of characters)
		int len = comments.length();

		// To see if two integer values are equal use ==
		// But don't use == for Strings (see below)!
		if (len == 0) {
			Toast.makeText(this.getApplicationContext(), "Give me comments!",
					Toast.LENGTH_LONG).show();
			mComments.requestFocus();
			return;
		}
		// To see if two String objects are equal use the "equals" method
		// For String pointers, '==' compares two memory pointers to see if they
		// point to the same object
		//
		// if (name == "Fred") Not OK! (because name can point to a different
		// String object, that might also contain F-r-e-d)
		//
		// if( name == null) is OK for this special case of comparing with null
		//
		if (name.equals("Fred")) {
			Toast.makeText(this.getApplicationContext(), "Hi Fred!",
					Toast.LENGTH_LONG).show();
		}

		// We might run into some surprises when we try to convert
		// a string to an integer value
		// Convert a string (a sequence of characters) "123123123" into an
		// integer value

		String username = email.substring(0, position);
		String thankyou = "Thank you " + username + "!";

		Toast.makeText(this.getApplicationContext(), thankyou,
				Toast.LENGTH_LONG).show();

		String message = name + " says.. \n" + comments;
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
		emailIntent.setData(Uri.fromParts("mailto",
				"feedback@myapp.somewhere...", null));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "important news");

		emailIntent.putExtra(Intent.EXTRA_TEXT, message);

		// Better .... use resolveActivity
		// We can check to see if there is a configured email client
		// BEFORE trying to start an activity
		// Using this test we could have prevented the user from ever opening
		// the survey...
		
/*		Intent i = new Intent(Intent.ACTION_SEND);
		i.setType("text/plain");
		i.putExtra(Intent.EXTRA_TEXT, message);
		startActivity(i);*/
		
		
		if (emailIntent.resolveActivity(getPackageManager()) == null) {
			Toast.makeText(getApplicationContext(),
					"Please configure your email client!", Toast.LENGTH_LONG)
					.show();
		} else {
			// Secondly, use a chooser will gracefully handle 0,1,2+ matching
			// activities
			startActivity(Intent.createChooser(emailIntent,
					"Please choose your email app!"));
		}

	}

}
