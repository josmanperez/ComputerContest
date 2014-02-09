package coursera.perez.computercontest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Answer extends Activity {

	Puntos points = new Puntos();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.correct_answer);

		ImageView correctI = (ImageView) findViewById(R.id.imageViewC);
		correctI.setVisibility(View.VISIBLE);
		Animation anim = AnimationUtils.makeInAnimation(this, true);
		correctI.startAnimation(anim);

	}

	public void onResume() {
		super.onResume();

	}

	public void tryAnotherQuestion(View v) {
		Log.e("Answer", "valor de puntos " + points.mostrarPuntos());
		Intent myIntent = getIntent();
		int flag = myIntent.getIntExtra("Activity", 0);

		if (flag == 1) {
			points.addPuntos();
			startActivity(new Intent(this, SecondQuestion.class));
		}
		if (flag == 2) {
			points.addPuntos();
			startActivity(new Intent(this, ThirdQuestion.class));
		}
		if (flag == 3) {
			points.addPuntos();
			startActivity(new Intent(this, WinningGame.class));
		}
	}

}