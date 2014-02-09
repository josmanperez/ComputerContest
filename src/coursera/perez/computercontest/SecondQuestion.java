package coursera.perez.computercontest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondQuestion extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_question);
	}

	public void onResume() {
		Toast.makeText(this.getApplicationContext(), "Question two", Toast.LENGTH_SHORT).show();
		super.onResume();
	}

	public void buttonClick(View v) {
		RadioButton rbc;
		final RadioGroup rg;
		rg = (RadioGroup) findViewById(R.id.radioGroup1);

		// This is the radio button who has the correct answer
		rbc = (RadioButton) findViewById(R.id.r0);
		// This will give the button who is pressed
		int aux = rg.getCheckedRadioButtonId();

		if (rbc.getId() == aux) {
			// if is the right answer
			Intent myintent = new Intent(this, Answer.class);
			myintent.putExtra("Activity", 2);
			startActivity(myintent);

		} else {
			// if is the wrong answer
			startActivity(new Intent(this, WrongAnswer.class));
		}
	}
}