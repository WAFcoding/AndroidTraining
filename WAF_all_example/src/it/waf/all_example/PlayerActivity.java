package it.waf.all_example;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class PlayerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		
		if(keyCode == KeyEvent.KEYCODE_BACK){

			finish();
			overridePendingTransition(R.anim.right_out, R.anim.left_in);
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
}
