package net.nemesis2074.endless.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnFragmentDemo = (Button)this.findViewById(R.id.main_btn_fragment_demo);
        btnFragmentDemo.setOnClickListener(this);
        
        Button btnActivityDemo = (Button)this.findViewById(R.id.main_btn_activity_demo);
        btnActivityDemo.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.main_btn_fragment_demo:
				Intent intent1 = new Intent(this, DemoListFragmentActivity.class);
				startActivity(intent1);
				break;
			case R.id.main_btn_activity_demo:
				Intent intent2 = new Intent(this, DemoListActivity.class);
				startActivity(intent2);
				break;
		}
	}
    
}
