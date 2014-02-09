package coursera.perez.computercontest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WrongAnswer extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wrong_answer);

		ImageView imageW = (ImageView) findViewById(R.id.imageViewW);
		imageW.setVisibility(View.VISIBLE);
		Animation anim = AnimationUtils.makeInAnimation(
				this.getApplicationContext(), true);
		imageW.setAnimation(anim);

	}
	/*
	 * public void backButtonImage (View v){ super.onBackPressed(); }
	 */
}
