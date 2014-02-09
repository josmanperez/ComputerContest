package coursera.perez.computercontest;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WinningGame extends Activity {

	MediaPlayer winningMusic = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hooray);

		ImageView imageH = (ImageView) findViewById(R.id.imageViewH);
		imageH.setVisibility(View.VISIBLE);
		Animation anim = AnimationUtils.makeInAnimation(
				this.getApplicationContext(), true);
		imageH.setAnimation(anim);

		

	}

	public void buttonRestartcontest(View v) {
		startActivity(new Intent(this, FirstQuestion.class));
		finish();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		winningMusic = MediaPlayer.create(this, R.raw.hooray);
		winningMusic.start();
		super.onResume();
		

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		winningMusic.stop();
		winningMusic.release();
		super.onPause();

	}

	public void proccesRecomemded(View v) {
		Intent myintent = new Intent(this, Recommended.class);
		startActivity(myintent);
	}

}
