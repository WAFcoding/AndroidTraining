package it.maxlax.changecolor;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ChangeBackColor extends Activity {
	private Button btOK;
	private EditText etColor;
	private RelativeLayout lyBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_back_color);
        
        btOK = (Button)findViewById(R.id.btOK);
        etColor = (EditText)findViewById(R.id.etColor);
        lyBase = (RelativeLayout)findViewById(R.id.lyBase);

        etColor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(v.getContext(), "The color is ", Toast.LENGTH_LONG).show();
			}
		});

        lyBase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(v.getContext(), "The color is ", Toast.LENGTH_LONG).show();
			}
		});

        btOK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(v.getContext(), "CIAO HAI CLICCATO", Toast.LENGTH_LONG).show();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.change_back_color, menu);
        return true;
    }
    
}
