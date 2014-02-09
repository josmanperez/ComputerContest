package coursera.perez.computercontest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FirstQuestion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_question);
	}

	public void buttonClick(View v) {
		RadioButton rbc;
		final RadioGroup rg;
		rg = (RadioGroup) findViewById(R.id.radioGroup);

		// This is the radio button who has the correct answer
		rbc = (RadioButton) findViewById(R.id.r1);
		// This will give the button who is pressed
		int aux = rg.getCheckedRadioButtonId();

		if (rbc.getId() == aux) {
			// if is the right answer
			Intent myintent = new Intent(this, CorrectAnswer.class);
			myintent.putExtra("Activity", 1);
			startActivity(myintent);
			// startActivity(new Intent(this,CorrectAnswer.class));

		} else {
			// if is the wrong answer
			startActivity(new Intent(this, WrongAnswer.class));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onResume() {
		Toast.makeText(this.getApplicationContext(), "Question one", Toast.LENGTH_SHORT).show();
		super.onResume();
	}



	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
