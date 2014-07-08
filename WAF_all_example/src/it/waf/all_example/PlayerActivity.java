package it.waf.all_example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayerActivity extends Activity {
	
	private Button btn_select_music;
	private TextView label_selected_file;
	
	private static final int FILE_RESULT_CODE= 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		
		btn_select_music= (Button) findViewById(R.id.button1);
		
		addButtonListener();
		
		label_selected_file= (TextView) findViewById(R.id.textView1);
	}
	
	public void addButtonListener(){
		
		btn_select_music.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				fileChooserGeneric();
			}
		});
	}
	
	public void fileChooserGeneric(){
		Intent file_chooser= new Intent(Intent.ACTION_GET_CONTENT);
		file_chooser.setType("*/*");
		file_chooser.addCategory(Intent.CATEGORY_OPENABLE);
		
		try{
			startActivityForResult(Intent.createChooser(file_chooser, "Select file"), FILE_RESULT_CODE);
		}catch(Exception e){
			Log.d("FILE_CHOOSER", "eccezione nella creazione del chooser");
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
		switch(requestCode){
		
			case FILE_RESULT_CODE:
				if(resultCode == RESULT_OK){
					Uri uri= data.getData();
					String path= uri.getPath();
					
					label_selected_file.append("  " + path +"\n");
				}
				break;
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		
		if(keyCode == KeyEvent.KEYCODE_BACK){

			finish();
			overridePendingTransition(R.anim.right_in, R.anim.left_out);
			return true;
		}
		
		return super.onKeyDown(keyCode, event); 
	}
}
