package net.nemesis2074.endless.demo;

import net.nemesis2074.endless.demo.fragment.DemoListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DemoListFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_demo);
		
		DemoListFragment fragment = (DemoListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_demo);
		fragment.init();
	}

	
	
}
