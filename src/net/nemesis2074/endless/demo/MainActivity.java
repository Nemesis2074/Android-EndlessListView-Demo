/*
 * Copyright (c) 2012 Adair Castillo (Nemesis2074)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
