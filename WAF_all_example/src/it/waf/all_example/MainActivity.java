package it.waf.all_example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button btn_player_music;
	private TextView label_player_music;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_player_music= (Button) findViewById(R.id.button1);
		
		addButtonListener();
		
		label_player_music= (TextView) findViewById(R.id.textView1);
	}
	
	public void addButtonListener(){
		
		btn_player_music.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, PlayerActivity.class));
				overridePendingTransition(R.anim.left_out, R.anim.right_in);
			}
		});
	}
}
