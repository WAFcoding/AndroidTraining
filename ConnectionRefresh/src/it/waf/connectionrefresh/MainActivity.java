package it.waf.connectionrefresh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText edttxt_seconds;
	private Button btn_seconds;
	private Button btn_refresh_now;
	private TextView txtvw_log;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//edit text seconds
		edttxt_seconds= (EditText)findViewById(R.id.editText1);
		
		//button seconds
		btn_seconds= (Button)findViewById(R.id.button1);
		
		btn_seconds.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "seconds setted", Toast.LENGTH_LONG).show();
			}
		});
		
		//button refresh now
		btn_refresh_now= (Button)findViewById(R.id.button2);
		
		btn_refresh_now.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "refresh now", Toast.LENGTH_LONG).show();
				txtvw_log.setText("");
				ping();
			}
		});
		
		//text view log
		txtvw_log= (TextView)findViewById(R.id.textView1);
		
		//txtvw_log.setText("LOG");
	}
	
	public void ping(){
		try {
			String pingCmd = "ping -c 5 " + "www.google.it";
			String pingResult = "";
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(pingCmd);
			BufferedReader in = new BufferedReader(new
			InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				txtvw_log.append(inputLine+"\n");
				
				/*System.out.println(inputLine);
				txtvw_log.setText(inputLine + "\n\n");
				pingResult += inputLine;
				txtvw_log.setText(pingResult);*/
			}
			in.close();
		}//try
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
